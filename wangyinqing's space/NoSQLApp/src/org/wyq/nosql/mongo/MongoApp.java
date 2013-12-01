package org.wyq.nosql.mongo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoApp {

	private static final Log log = LogFactory.getLog(MongoApp.class);

	public static void main(String[] args) throws Exception {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MongoAppConfig.class);
		context.refresh();
		MongoTemplate tempalte = context.getBean(MongoTemplate.class);
		tempalte.insert(new Person("Alice", 24),"tester");
		
//		MongoOperations mongoOps = new MongoTemplate(new Mongo(), "mytest");
//
//		mongoOps.insert(new Person("Alice", 24),"tester");
//		
//		log.info("success");

//		log.info(mongoOps.findOne(new Query(where("name").is("Joe")),
//				Person.class));
		
	}

}
