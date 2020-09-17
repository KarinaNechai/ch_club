package com.charakhovich.servlet.pool;

import com.charakhovich.servlet.dao.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool {
    private static ConnectionPool instance = null;
    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> busyConnections;
    private ConnectorCreator connectorCreator = ConnectorCreator.getInstance();
    private int poolSize;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean create = new AtomicBoolean(false);
    static final Logger logger = LogManager.getLogger(ConnectionPool.class);


    private ConnectionPool() {
        poolSize = connectorCreator.getPoolSizeMin();
        freeConnections = new LinkedBlockingQueue<>();
        busyConnections = new LinkedBlockingQueue<>();
        Thread timeThread = new Thread(new TimeThread(), "TimeThread ");
        timeThread.start();
        try {
            for (int i = 0; i < poolSize; i++) {
                Connection connection = connectorCreator.createConnection();
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.offer(proxyConnection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (!create.get()) synchronized (ConnectionPool.class) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        ProxyConnection connection = null;
        connection = freeConnections.take();
        busyConnections.offer(connection);
        return connection;
    }
    /*    try {
            if (freeConnections.isEmpty() && (
                    (freeConnections.size() + busyConnections.size()) < connectorCreator.getPoolSizeMax())) {
                connection = connectorCreator.createConnection();
                poolSize++;
                busyConnections.offer(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }*/

    public boolean returnConnection(Connection connection) throws DaoException {
        boolean flag = false;
        if (connection instanceof ProxyConnection) {
            ProxyConnection proxyConnection = (ProxyConnection) connection;
            if (busyConnections.contains(connection)) {
                busyConnections.remove(proxyConnection);
                freeConnections.offer(proxyConnection);
                flag = true;
            } else {
                throw new DaoException("Strange connection");
            }
        } else {
            throw new DaoException("Strange connection");
         //  logger.log(Level.WARN, "This connection is not connection of this pool");
        }
        return flag;
    }

    public void destroyPool() {
        try {
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection = freeConnections.take();
                connection.closeProxyConnection();
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destroyDrivers() throws SQLException {
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements(); ) {
            Driver driver = e.nextElement();
            if (driver.getClass().equals(ConnectorCreator.properties.get("db.driver"))) {
                DriverManager.deregisterDriver(driver);
            }
        }
    }

    class TimeThread implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                int t = poolSize - freeConnections.size() - busyConnections.size();
                if (t > 0) {
                    for (int i = 0; i < t; i++) {
                        Connection connection = connectorCreator.createConnection();
                        ProxyConnection proxyConnection = new ProxyConnection(connection);
                        freeConnections.offer(proxyConnection);
                    }
                }
                int sizeBusyConnection = busyConnections.size();
                if ((busyConnections.size() == poolSize) && (poolSize < connectorCreator.getPoolSizeMax())) {
                    Connection addConnection = connectorCreator.createConnection();
                    ProxyConnection addProxyConnection = new ProxyConnection(addConnection);
                    freeConnections.offer(addProxyConnection);
                }
                lock.unlock();
                TimeUnit.SECONDS.sleep(1000);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}


