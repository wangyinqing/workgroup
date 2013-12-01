package org.wyq.nosql.mongo;

import java.net.UnknownHostException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoMainTest {
	static Logger logger = LoggerFactory.getLogger(MongoMainTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			try {
				MongoClient client = new MongoClient("192.168.0.105",27017);
				DB db = client.getDB("mytest");
				DBCollection collection = db.getCollection("user");
				BasicDBObject obj = new BasicDBObject();
				obj.put("name", "aaaa");
				obj.put("createDate", new Date());
				collection.insert(obj);
			} catch (UnknownHostException e) {
				logger.error("",e);
			}
	}

}
