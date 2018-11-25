//package spittr.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("spittr.web")
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    /**
//     * 配置JSP视图解析器
//     *
//     * @return
//     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);//将视图解析为JstlView,jsp中可使用jstl
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }
//
//    /**
//     * 配置静态资金源的的处理：DispatcherServlet将对静态资源的访问转发到Servlet容器默认的Servlet上
//     *
//     * @param configurer
//     */
//
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//
//        configurer.enable();
//    }
//}
