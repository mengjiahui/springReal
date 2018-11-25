package spittr.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import soundsystem.RootConfig;

@Configuration
@Import({AspectJConfig.class,DataSourceConfiguration.class, RootConfig.class})
@ImportResource("classpath:cd-config.xml")//在javaConfig中引用XML中声明的注解
public class WholeConfig {
}
