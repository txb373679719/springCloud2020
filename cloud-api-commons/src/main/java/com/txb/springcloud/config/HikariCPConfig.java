package com.txb.springcloud.config;//package com.cntaiping.tplife.ft.activity.config;
//
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import com.cntaiping.tplife.ft.activity.util.DataSourceSwitchUtil;
//import com.zaxxer.hikari.HikariDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by xk on 2020/03/16
// */
//@Configuration
//@Slf4j
//public class HikariCPConfig {
//
//    @Autowired
//    private PaginationInterceptor paginationInterceptor;
//
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    @Bean
//    public DataSource masterDataSource() {
//        return new HikariDataSource();
//    }
//
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    @Bean
//    public DataSource slaveDataSource() {
//        return new HikariDataSource();
//    }
//
//    @Bean
//    public DynamicDataSourceConfig dynamicDataSourceConfig() {
//        DynamicDataSourceConfig dynamicDataSourceConfig = new DynamicDataSourceConfig();
//        Map<Object, Object> map = new HashMap<>();
//        map.put(DataSourceSwitchUtil.master, masterDataSource());
//        map.put(DataSourceSwitchUtil.slave, slaveDataSource());
//        dynamicDataSourceConfig.setDefaultTargetDataSource(masterDataSource());
//        dynamicDataSourceConfig.setTargetDataSources(map);
//        return dynamicDataSourceConfig;
//    }
//
//    @Bean
//    public PlatformTransactionManager txManager(DynamicDataSourceConfig dynamicDataSourceConfig) {
//        return new DataSourceTransactionManager(dynamicDataSourceConfig);
//    }
//
//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DynamicDataSourceConfig dynamicDataSourceConfig) throws Exception {
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        mybatisSqlSessionFactoryBean.setDataSource(dynamicDataSourceConfig);
//        try {
//            mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*Mapper.xml"));
//        } catch (IOException e) {
//            log.error("get resources exception:{}", e.getMessage());
//        }
//        mybatisSqlSessionFactoryBean.setPlugins(new PaginationInterceptor[]{paginationInterceptor});
//        return mybatisSqlSessionFactoryBean;
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean) throws Exception {
//        return new SqlSessionTemplate(mybatisSqlSessionFactoryBean.getObject());
//    }
//
//}
