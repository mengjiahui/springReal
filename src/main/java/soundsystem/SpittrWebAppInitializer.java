package soundsystem;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 该类用于定义DispatcherServlet处理的请求和注册bean的配置文件；
 * 启用springMVC使用注解：@EnableWebMvc
 * 有两个上下文来加载bean:DispatcherServlet和ContextLoaderListener
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置multipart解析器和细节
     * 使用MultipartFile之必备
     *
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/opt/spittr/uploads",//临时目录
                        2097152,//上传文件的最大字节容量，2Mb
                        4194304,//整个multipart请求最大字节容量，4Mb
                        0));//文件大小达到指定容量时，写入到硬盘；0标示所有上传的文件都写入磁盘
    }

    /**
     * ContextLoaderListener加载其他bean,如中间层和数据层组件，她们定义在方法getRootConfigClasser指定的类RootConfig中；
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * DispatcherServlet会加载包含web组件的bean,如控制器、视图解析器、处理器映射，她们定义在方法getServletConfigClasser指定的类WebConfig中；
     * 使用注解@EnableWebMvc启用springMVC常放在这个类里
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * dispatcherServlet处理的请求
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
