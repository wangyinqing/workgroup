package cn.edu.wyq.algorithm.fibonacci;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
	static Logger logger = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		while(!"exit".equalsIgnoreCase(input)){
			long time = System.nanoTime();
			try{
				long number = Long.parseLong(input);
				long result = Fibonacci.ITERARION.calculate(number);
				logger.info(String.valueOf(result));
			}catch(IllegalArgumentException e){
				logger.info(e.getMessage());
			}
			System.out.println((System.nanoTime() - time)/1000000.0);
			input = scan.next();
		}
		scan.close();
		
	}

}
