package com.hotaru.core.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceFactory {
    private static DataSourceFactory INSTANCE;
    private static boolean INITIALIZED;

    private Map<String, DataSource> dataSources;

    private DataSourceFactory(Map<String, DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public static DataSourceFactory getInstance() {
        if (!INITIALIZED) {
            throw new RuntimeException("Data source factory not initialized");
        }

        return INSTANCE;
    }

    public static void initialize() {
        Map<String, DataSource> dataSources = new HashMap<>();

        HikariConfig config = new HikariConfig(getResourcePath() + "datasources/datasource.properties");
        DataSource mainDatasource = new HikariDataSource(config);

        dataSources.put("main", mainDatasource);
        INSTANCE = new DataSourceFactory(dataSources);
        INITIALIZED = true;
    }

    public DataSource getDataSource(String key) {
        return this.dataSources.get(key);
    }

    public static String getResourcePath() {
        return DataSourceFactory.class.getResource("../../../../").getPath();
    }
}
