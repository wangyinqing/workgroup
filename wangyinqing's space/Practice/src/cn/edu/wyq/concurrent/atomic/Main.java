package cn.edu.wyq.concurrent.atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		final Statistics s = new Statistics(); 
		ExecutorService es = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 10000000; i++) {
			es.submit(new Callable<Void>(){
				@Override
				public Void call() throws Exception {
					s.increase(1, 2); // as tested, CAS and synchronized has almost same time consuming
					return null;
				}
			});
		}
		es.shutdown();
		try {
			es.awaitTermination(10000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		}
		Statistics.Pair p = s.get();
		System.out.println("Counter:" + p.counter + " Sum: " + p.sum);
		System.out.println("Execution time " + (System.currentTimeMillis()-start) + " ms");
		
	}

}
