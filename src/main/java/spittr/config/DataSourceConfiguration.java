package spittr.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;


/**
 * 根据激活的profile获取
 */
@Configuration
public class DataSourceConfiguration {

//    @Profile("development")
//    @Bean
//    public DataSource embeddedDataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }

//    @Profile("qa")
//    @Bean
//    public DataSource Data(){
//        BasicDataSource ds=new BasicDataSource();
//        ds.setDriverClassName("org.h2.Driver");//
//        ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
//        ds.setUsername("sa");
//        ds.setPassword("");
//        ds.setInitialSize(5);
//        ds.setMaxActive(10);
//        return ds;
//
//    }

//    @Profile("production")
//    @Bean
//    public DataSource dataSource(){
//        JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource) jndiObjectFactoryBean.getObject();
//
//    }

    /**
     * 连接oracle数据库
     * @return
     */
    @Bean
    public DataSource Data(){
        BasicDataSource ds=new BasicDataSource();

        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@10.1.210.179:1521:dev");
        ds.setUsername("cmfuser");
        ds.setPassword("cmfuser");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        return ds;

    }
}
