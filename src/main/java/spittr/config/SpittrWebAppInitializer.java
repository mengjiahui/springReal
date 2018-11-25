//package spittr.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * 该类用于定义DispatcherServlet处理的请求和注册bean的配置文件；
// * 启用springMVC使用注解：@EnableWebMvc
// * 有两个上下文来加载bean:DispatcherServlet和ContextLoaderListener
// */
//public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//    /**
//     * ContextLoaderListener加载其他bean,如中间层和数据层组件，她们定义在方法getRootConfigClasser指定的类RootConfig中；
//     * @return
//     */
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{RootConfig.class};
//    }
//
//    /**
//     * DispatcherServlet会加载包含web组件的bean,如控制器、视图解析器、处理器映射，她们定义在方法getServletConfigClasser指定的类WebConfig中；
//     * 使用注解@EnableWebMvc启用springMVC常放在这个类里
//     * @return
//     */
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{WebConfig.class};
//    }
//
//    /**
//     * dispatcherServlet处理的请求
//     * @return
//     */
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//}
