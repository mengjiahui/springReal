package soundsystem;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * web组件的bean不适用于RootConfig定义的组件扫描
 * RootConfig这个名字 ==
 */
@Configuration
@ComponentScan(basePackages = {"soundsystem"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
@EnableAspectJAutoProxy //启用切面
@EnableCaching //启用缓存
public class RootConfig {
    /**
     * 缓存管理器ConcurrentMapCacheManager,使用java.util.concurrent.ConcurrentHashMap作为缓存存储
     * 适合开发和测试，不适合生产
     *
     * @return
     */
//    @Bean
//    public CacheManager cacheManager(){
//        return new ConcurrentMapCacheManager();
//    }
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory redisCF) {
        RedisTemplate<String, String> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCF);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;

    }
}
