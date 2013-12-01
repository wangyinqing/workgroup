package org.wyq.nosql.mongo;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;


@Configuration
@EnableMongoRepositories
public class MongoAppConfig extends AbstractMongoConfiguration {
	
	@Bean(name="mongo")
	public Mongo mongo() throws UnknownHostException{
		return new Mongo("localhost",27017);
	}
	
	
	@Bean(name="mongofacotry")
	public SimpleMongoDbFactory mongoDbFactory() throws Exception {
		return super.mongoDbFactory();
	}

	@Override
	protected String getDatabaseName() {
		return "mytest";
	}

}
