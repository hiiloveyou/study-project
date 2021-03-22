package com.chenyi.study.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author BG344144
 * @date 2021/3/22-22:44
 * @description
 */
@Configuration
public class DataSourceConfiguration {
    @Autowired
    private MybatisAutoConfiguration mybatisAutoConfiguration;

    @Bean
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        return mybatisAutoConfiguration.sqlSessionFactory(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return mybatisAutoConfiguration.sqlSessionTemplate(sqlSessionFactory);
    }
}
