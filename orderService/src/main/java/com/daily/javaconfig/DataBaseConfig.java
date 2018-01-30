package com.daily.javaconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据库配置
 *
 * @author wangjiangtao
 * @date 2017/12/28
 **/
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@MapperScan(value = "com.daily.mapper")
public class DataBaseConfig implements EnvironmentAware{

    private RelaxedPropertyResolver propertyResolver;

    private RelaxedPropertyResolver propertyResolver2;

    @Override
    public void setEnvironment(Environment env) {
        propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
        propertyResolver2 = new RelaxedPropertyResolver(env, "mybatis.");
    }

    @Bean(name = "hexin6")
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive")));
        datasource.setMaxWait(Long.parseLong(propertyResolver.getProperty("maxWait")));
        return datasource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hexin6") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources(propertyResolver2.getProperty("mapper-locations")));
        bean.setConfigLocation(new DefaultResourceLoader()
        .getResource(propertyResolver2.getProperty("config-locations")));
        return bean.getObject();
    }

    @Bean("dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("hexin6") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
