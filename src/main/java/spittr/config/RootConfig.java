//package spittr.config;
//
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import spittr.AspectJ.LogProcess;
//
//import javax.sql.DataSource;
//
///**
// * web组件的bean不适用于RootConfig定义的组件扫描
// * RootConfig这个名字 ==
// */
//@Configuration
//@ComponentScan(basePackages = {"spittr"},excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,value= EnableWebMvc.class)
//})
//
//public class RootConfig {
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//
//
//}
