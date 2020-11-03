package com.charakhovich.club.model.pool;

import com.charakhovich.club.model.exeption.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
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
        //  Thread timeThread = new Thread(new TimeThread(), "TimeThread ");
        //  timeThread.start();
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

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            busyConnections.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean returnConnection(Connection connection) {
        boolean flag = false;
        try {
            if (connection instanceof ProxyConnection) {
                ProxyConnection proxyConnection = (ProxyConnection) connection;
                if (busyConnections.remove(proxyConnection)) {
                    freeConnections.put(proxyConnection);
                    flag = true;
                } else {
                    throw new DaoException("!!!!!!!");
                }
            } else {
                throw new DaoException("!!!!! ");
                //  logger.log(Level.WARN, "This connection is not connection of this pool");
            }
        } catch (DaoException | InterruptedException e) {
            e.getStackTrace();
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
        deregisterDriver();
        logger.info("Connection Pool was destroyed, drivers were deregistered");
    }

    private void deregisterDriver() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error(e);
            }
        });
    }


 /*   class TimeThread implements Runnable {
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
    }*/
}


