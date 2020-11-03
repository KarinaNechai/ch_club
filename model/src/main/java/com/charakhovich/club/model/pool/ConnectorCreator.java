package com.charakhovich.club.model.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectorCreator {
    static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    private static final int POOL_SIZE_MIN;
    private static final int POOL_SIZE_MAX;
    private static final String FILE_PROPERTIES = "db.properties";
    private static ConnectorCreator instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    static {
        try {
            InputStream inputStream = null;
            inputStream = ConnectorCreator.class.getClassLoader().getResourceAsStream(FILE_PROPERTIES);
            if (inputStream == null) throw new AssertionError();
            properties.load(inputStream);
            String driver = (String) properties.get("db.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        DATABASE_URL = (String) properties.getProperty("db.url");
        POOL_SIZE_MIN = Integer.parseInt(properties.getProperty("pool.size.min"));
        POOL_SIZE_MAX = Integer.parseInt(properties.getProperty("pool.size.max"));
    }

    private ConnectorCreator() {
    }

    public static ConnectorCreator getInstance() {
        try {
            lock.lock();
            if (instance == null) {
                instance = new ConnectorCreator();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }

    public int getPoolSizeMin() {
        return POOL_SIZE_MIN;
    }

    public int getPoolSizeMax() {
        return POOL_SIZE_MAX;
    }
}
