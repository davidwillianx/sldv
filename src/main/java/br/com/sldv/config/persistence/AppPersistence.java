package br.com.sldv.config.persistence;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.sldv.model")
public class AppPersistence {

    @Bean
    public LocalContainerEntityManagerFactoryBean
         entityManagerFactory() throws IOException {

        LocalContainerEntityManagerFactoryBean em;
        em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setPackagesToScan("br.com.sldv.model.domains");

        JpaVendorAdapter jpaAdapter;
        jpaAdapter = new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(jpaAdapter);
        em.setJpaProperties(getAdditionalProperties());

        return em;
    }


    @Bean
    public DataSource dataSource() throws IOException {

        Resource resource;
        resource = new ClassPathResource("/persistence.properties");

        Properties properties;
        properties = PropertiesLoaderUtils.loadProperties(resource);

        DriverManagerDataSource dataSource;
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));


        return  dataSource;
    }


    public Properties getAdditionalProperties(){

        Properties additionalProperties;

        additionalProperties  = new Properties();
        additionalProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        additionalProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        additionalProperties.setProperty("hibernate.show_sql", "false");

        return additionalProperties;

    }

}
