package org.wyq.nosql.mongo;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;


@Configuration
public class MongoAppConfig {
	
	@Bean(name="mongo")
	public Mongo mongo() throws UnknownHostException{
		return new Mongo("localhost",27017);
	}
	
	
	@Bean(name="mongofacotry")
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), "mytest");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}
