package com.charakhovich.servlet.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private volatile static ConnectionPool instance = null;
    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> busyConnections;
    private ConnectorCreator connectorCreator = ConnectorCreator.getInstance();
    private int poolSize;

    private ConnectionPool() {
        poolSize = connectorCreator.getPoolSizeMin();
        freeConnections = new LinkedBlockingQueue<Connection>();
        busyConnections = new LinkedList<Connection>();
        try {
            for (int i = 0; i < poolSize; i++) {
                Connection connection = connectorCreator.createConnection();
                freeConnections.offer(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null)
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        return (ConnectionPool) instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        if (!freeConnections.isEmpty()) {
            connection = freeConnections.poll();
            busyConnections.offer(connection);
            return connection;
        }
        try {
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
    }

    public boolean returnConnection(Connection connection) {
        boolean flag=false;
        if (busyConnections.remove(connection)) {
            freeConnections.offer(connection);
            flag = true;
        }
        return flag;
    }

    public void destroyPool() {
        try {
            int countConnection = freeConnections.size();
            for (int i = 0; i < countConnection; i++) {
                Connection connection = freeConnections.poll();
                connection.close();
            }
            countConnection = busyConnections.size();
            for (int i = 0; i < countConnection; i++) {
                Connection connection = busyConnections.poll();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


