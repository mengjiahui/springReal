package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spittr.AspectJ.LogProcess;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("spittr.AspectJ")
public class AspectJConfig {

    @Bean
    public LogProcess audience(){
        return new LogProcess();
    }
}
