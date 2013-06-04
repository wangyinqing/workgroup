package cn.edu.wyq.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class Statistics {
	
	private AtomicReference<Pair> ar;
	{
		ar = new AtomicReference<Pair>(new Pair(0,0));
	}
	
	
	public void increase(long i, long sum){
		for(;;){
			Pair p = ar.get();
			Pair update = p.clonePair(); 
			update.counterIncrement(i);
			update.sumIncrement(sum);
			if(ar.compareAndSet(p, update))
				return;
		}
		
	}

	public void unsafeIncrease(long i, long sum){
		Pair p = ar.get();
		Pair update = p.clonePair();
		update.counterIncrement(i);
		update.sumIncrement(sum);
		ar.set(update);
	}
	
	public synchronized void lockIncrease(long i, long sum){
		Pair p = ar.get();
		Pair update = p.clonePair();
		update.counterIncrement(i);
		update.sumIncrement(sum);
		ar.set(update);
	}

	public void unsafeIncrease2(long i, long sum){
		Pair p = ar.get();
		p.counterIncrement(i);
		p.sumIncrement(sum);
	}
	
	public Pair get(){
		return ar.get();
	}
	
	public static class Pair{
		long counter;
		long sum;

		private Pair(long counter,long sum){
			this.counter = counter;
			this.sum = sum;
		}
		
		private void counterIncrement(long counter){
			this.counter +=counter;
		}
		
		private void sumIncrement(long sum){
			this.sum += sum;
		}
		
		Pair clonePair(){
			return new Pair(this.counter,this.sum);
		}
		
	}
}
