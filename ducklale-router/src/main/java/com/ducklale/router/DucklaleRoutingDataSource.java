package com.ducklale.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 通过元数据组装数据库的datasource
 */
public class DucklaleRoutingDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DataSourceKeyThreadLocal.getKey();
    }
}
