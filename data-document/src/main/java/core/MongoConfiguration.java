package core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.document.mongodb.MongoExceptionTranslator;
import org.springframework.data.document.mongodb.MongoFactoryBean;

@Configuration
public class MongoConfiguration {

    public @Bean MongoFactoryBean mongo() {
    	return new MongoFactoryBean(); 
    }

    public @Bean MongoExceptionTranslator mongoExceptionTranslator() {
    	return new MongoExceptionTranslator(); 
    }

    public @Bean PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
    	return new PersistenceExceptionTranslationPostProcessor();
    }

}
