package com.ducklale.config;

import com.ducklale.metadata.dao.ShardingDao;
import com.ducklale.router.DataSourceKeyThreadLocal;
import com.ducklale.router.DucklaleRoutingDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class,DefaultDataSourceProperties.class})
@ConditionalOnClass(DucklaleRoutingDataSource.class)
@ConditionalOnProperty(prefix = "ducklale.jdbc",value = "enable",matchIfMissing = true)
public class MyBatisConfiguration {

    @Autowired
    DataSourceProperties dsproperties;
    @Autowired
    DefaultDataSourceProperties dfaultdsproperties;
    @Bean(name="allDucklaleDataSource",autowire = Autowire.BY_NAME)
    public DataSource dataSource(){
        DucklaleRoutingDataSource dataSource = new DucklaleRoutingDataSource();
        DataSource metaDataSource = metaDataSource();
        DataSource defaultDataSource = defaultDataSource();
        Map<Object,Object> sources = new HashMap<>();
        sources.put(DataSourceKeyThreadLocal.getDefaultKey(),defaultDataSource);
        Map<Object, Object> shardings = shardingDao().getAllShards(dsproperties);
        Iterator<Object> iter = shardings.keySet().iterator();
        while(iter.hasNext()){
            Object key = iter.next();
            sources.put(key,shardings.get(key));
        }
        dataSource.setDefaultTargetDataSource(defaultDataSource);
        dataSource.setTargetDataSources(sources);
//        dataSource.afterPropertiesSet();
        return dataSource;
    }
    @Bean(name="shardingDao")
    public ShardingDao shardingDao(){
        ShardingDao dao = new ShardingDao();
        dao.setMetaDataSource(metaDataSource());
        return dao;
    }
    @Bean(name="metaDataSource")
    public BasicDataSource metaDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dsproperties.getDriverClassName());
        dataSource.setUrl(dsproperties.getUrl());
        dataSource.setUsername(dsproperties.getUsername());
        dataSource.setPassword(dsproperties.getPassword());
        dataSource.setInitialSize(dsproperties.getInitialSize());
        dataSource.setMaxActive(dsproperties.getMaxActive());
        dataSource.setMaxIdle(dsproperties.getMaxIdle());
        dataSource.setMinIdle(dsproperties.getMinIdle());
        dataSource.setMaxWait(dsproperties.getMaxWait());
        return dataSource;
    }
    @Bean(name="defaultDataSource")
    public BasicDataSource defaultDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dfaultdsproperties.getDriverClassName());
        dataSource.setUrl(dfaultdsproperties.getUrl());
        dataSource.setUsername(dfaultdsproperties.getUsername());
        dataSource.setPassword(dfaultdsproperties.getPassword());
        dataSource.setInitialSize(dfaultdsproperties.getInitialSize());
        dataSource.setMaxActive(dfaultdsproperties.getMaxActive());
        dataSource.setMaxIdle(dfaultdsproperties.getMaxIdle());
        dataSource.setMinIdle(dfaultdsproperties.getMinIdle());
        dataSource.setMaxWait(dfaultdsproperties.getMaxWait());
        return dataSource;
    }

}
