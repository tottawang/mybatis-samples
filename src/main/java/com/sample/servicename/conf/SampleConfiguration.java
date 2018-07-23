package com.sample.servicename.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sample.servicename.repository.SampleMapper;
import com.sample.servicename.repository.SampleRepository;

@Configuration
@ComponentScan(basePackages = "com.sample")
@EnableConfigurationProperties({DatabaseConnectionProperties.class})
public class SampleConfiguration {

  private static final String PATTERN_CHECK = " ?nullNamePatternMatchesAll=true";
  // TODO Get rid of PATTERN_CHECK when https://liquibase.jira.com/browse/CORE-2723 get solved

  @Autowired
  private DatabaseConnectionProperties dbProperties;

  @Autowired
  SampleMapper SampleMapper;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create().username(dbProperties.getName())
        .password(dbProperties.getPassword()).driverClassName("com.mysql.cj.jdbc.Driver")
        .url(dbProperties.getUrl() + PATTERN_CHECK).type(MysqlDataSource.class).build();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    sqlSessionFactory.setDataSource(dataSource());
    sqlSessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
    return sqlSessionFactory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    // Rather than create a new transaction manager specific to MyBatis
    // MyBatis-Spring leverages the existing DataSourceTransactionManager in Spring.
    // http://www.mybatis.org/spring/transactions.html
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public SampleRepository sampleRepository() {
    return new SampleRepository(SampleMapper);
  }


}
