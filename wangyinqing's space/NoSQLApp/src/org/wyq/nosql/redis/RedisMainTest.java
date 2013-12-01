package org.wyq.nosql.redis;

import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class RedisMainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis redis = new Jedis("192.168.0.105",6379); 
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while(!"quit".equalsIgnoreCase(input)){
			if(input.startsWith("set")){
				String value = input.substring(input.indexOf("set") + "set".length()).trim();
				String[] values = value.split(" ");
				if(values.length == 2){
					redis.set(values[0], values[1]);
					System.out.println("set " + values[0] + " : " + values[1]);
				}else{
					redis.set("default", values[0]);
					System.out.println("set default : " + value);
				}
			}else if(input.startsWith("get")){
				String key = input.substring(input.indexOf("get") + "get".length()).trim();
				String value = redis.get(key);
				System.out.println("get " + value);
			}else{
				System.out.println("Not valid command " + input);
			}
			input = scanner.nextLine();
		}
		scanner.close();
	}

}
