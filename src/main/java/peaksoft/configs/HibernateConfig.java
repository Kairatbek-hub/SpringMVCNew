//package peaksoft.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Objects;
//import java.util.Properties;
//
//@Configuration
//@PropertySource("classpath:datasource.properties")
//@EnableTransactionManagement(proxyTargetClass = true)
//@ComponentScan(basePackages = "peaksoft")
//public class HibernateConfig {
//
//    private final Environment env;
//
//    public HibernateConfig(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("datasource.driverClassName")));
//        dataSource.setUrl(env.getProperty("datasource.url"));
//        dataSource.setUsername(env.getProperty("datasource.username"));
//        dataSource.setPassword(env.getProperty("datasource.password"));
//        return dataSource;
//    }
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
//        properties.put(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
//        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//        return properties;
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setGenerateDdl(true);
//        jpaVendorAdapter.setShowSql(true);
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        entityManagerFactoryBean.setPackagesToScan(env.getProperty("package.toScan"));
//        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
//        entityManagerFactoryBean.afterPropertiesSet();
//        return entityManagerFactoryBean.getObject();
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//}
