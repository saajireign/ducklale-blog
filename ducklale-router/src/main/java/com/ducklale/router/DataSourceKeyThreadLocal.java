package com.ducklale.router;

public class DataSourceKeyThreadLocal {
    private static final ThreadLocal<String> dataSource = new ThreadLocal<String>();
    private static final String DEFAULT_KEY="default-data";
    public static String getKey(){
        return dataSource.get();
    }
    public static void setKey(String key){
        dataSource.set(key);
    }
    public static void resetKey(){
        dataSource.set(DEFAULT_KEY);
    }
    public static String getDefaultKey(){
        return DEFAULT_KEY;
    }
}
