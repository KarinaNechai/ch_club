package com.charakhovich.servlet.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorCreator {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    private static final int POOL_SIZE_MIN;
    private static final int POOL_SIZE_MAX;
    private static final String FILE_PROPERTIES = "db.properties";
    private volatile static ConnectorCreator instance = null;

    static {
        try {
            InputStream inputStream = null;
            inputStream = ConnectorCreator.class.getClassLoader().getResourceAsStream(FILE_PROPERTIES);
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
        if (instance == null)
            synchronized (ConnectorCreator.class) {
                if (instance == null) {
                    instance = new ConnectorCreator();
                }
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
