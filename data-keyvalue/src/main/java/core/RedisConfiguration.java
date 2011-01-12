package core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.keyvalue.redis.connection.RedisConnectionFactory;
import org.springframework.data.keyvalue.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfiguration {

	@Bean
	RedisConnectionFactory connectionFactory() {
		JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
		jedisConnFactory.setPooling(false);
		jedisConnFactory.afterPropertiesSet();
		return jedisConnFactory;
	}
}
