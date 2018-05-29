package com.ducklale.user.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({DataSourceUserProperties.class})
@ConditionalOnProperty(prefix = "ducklale.jdbc",value = "enable",matchIfMissing = true)
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {

    @Autowired
    DataSourceUserProperties dfaultdsproperties;

    @Bean(name="ducklaleUserDataSource")
    public DataSource datasource(){
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
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(datasource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource());
        try{
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setConfigLocation(resolver.getResource("classpath:/conf/mybatis-config.xml"));
            bean.setTypeAliasesPackage("com.ducklale.user.domain.entity");
            bean.setMapperLocations(resolver.getResources("classpath:/mappings/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
