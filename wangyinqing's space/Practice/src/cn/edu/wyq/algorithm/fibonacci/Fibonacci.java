package cn.edu.wyq.algorithm.fibonacci;

/**
 * @author wangyinqing
 *
 */
public enum Fibonacci {
	RECURSION{
		public long calculate(long number){
			if(number == 0){
				return 0L;
			}
			if(number == 1 || number == 2){
				return 1L;
			}
			if(number > 2){
				return calculate(number - 2) + calculate(number -1);
			}
			throw new IllegalArgumentException(number + " is illegal");
		}
	},
	ITERARION{
		public long calculate(long number){
			if(number < 0){
				throw new IllegalArgumentException(number + " is illegal");
			}
			long prev1 = 0L;
			long prev2 = 1L;
			for (int i = 0; i < number; i++) {
				long value = prev2 + prev1;
				prev2 = prev1;
				prev1 = value;
			}
			return prev1;
		}
	};
	
	public abstract long calculate(long number);


}
