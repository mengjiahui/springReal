package soundsystem.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

/**
 * 启用web安全功能，来配置Spring Security
 */
@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity//使用springmvc开发时，用来替代@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

//    /**
//     * 使用基于内存的用户存储，适合开发和测试
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()//添加用户，并设置密码和权限
//                .withUser("admin").password("password").roles("USER", "ADMIN");//同上
//    }

    @Autowired
    DataSource dataSource;
    /**
     * 使用基于数据库的用户存储，可用于生产
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource);
    }
}
