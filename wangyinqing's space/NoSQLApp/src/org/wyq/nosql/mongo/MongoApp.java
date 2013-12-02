package org.wyq.nosql.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.List;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		try {
			String input = scanner.nextLine();
			while (!"quit".equalsIgnoreCase(input)) {
				try {
					String[] commands = input.split(" ");
					if ("insert".equalsIgnoreCase(commands[0])) {
						tempalte.insert(new Person(commands[1], Integer
								.parseInt(commands[2])));
					} else if ("update".equalsIgnoreCase(commands[0])) {
						tempalte.updateFirst(
								query(where(commands[1]).is(
										tryConvert(commands[2]))),
								update(commands[3], tryConvert(commands[4])),
								Person.class);
					} else if ("updateall".equalsIgnoreCase(commands[0])) {
						tempalte.updateMulti(
								query(where(commands[1]).is(
										tryConvert(commands[2]))),
								update(commands[3], tryConvert(commands[4])),
								Person.class);
					} else if ("findone".equalsIgnoreCase(commands[0])) {
						Person p = tempalte.findOne(query(where(commands[1])
								.is(tryConvert(commands[2]))), Person.class);
						log.info(p);
					} else if ("find".equalsIgnoreCase(commands[0])) {
						List<Person> p = tempalte.find(query(where(commands[1])
								.is(tryConvert(commands[2]))), Person.class);
						for (Person _p : p)
							log.info(_p);
					} else if ("findall".equalsIgnoreCase(commands[0])) {
						List<Person> p = tempalte.findAll(Person.class);
						for (Person _p : p)
							log.info(_p);
					} else if ("remove".equalsIgnoreCase(commands[0])) {
						tempalte.remove(
								query(where(commands[1]).is(
										tryConvert(commands[2]))), Person.class);
					} else {
						log.warn("not a valid commnd " + input);
					}
				} catch (Exception e) {
					log.error("execution error", e);
				}
				input = scanner.nextLine();
			}
		} finally {
			scanner.close();
		}

		log.info("System exists");
	}

	public static Object tryConvert(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
		}
		return value;
	}

}
