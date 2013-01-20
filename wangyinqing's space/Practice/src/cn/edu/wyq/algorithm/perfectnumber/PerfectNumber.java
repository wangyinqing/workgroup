package cn.edu.wyq.algorithm.perfectnumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PerfectNumber {
	public boolean isPerfectNumber(long number) {
		boolean b = false;
		List<Long> factorList = new ArrayList<Long>();
		long remain = number;
		for (long i = 1; i < (number/2+1); i++) {
			if (number % i == 0) {
				factorList.add(i);
				remain -= i;
				if (remain < 0) {
					break;
				}
			}
		}
	    b = remain == 0;
	    if(b){
	    	System.out.println("Number " + number + " is a perfect number, factors are : " + combind(factorList,", "));
	    }
	    return b;
	};
	
	private String combind(Collection<?> c, String conStr){
		StringBuilder sb = new StringBuilder();
		if(c== null || c.isEmpty()){
			return null;
		}
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()){
			sb.append(iter.next());
			if(iter.hasNext()){
				sb.append(conStr);
			}
		}
		return sb.toString();
	}
}
