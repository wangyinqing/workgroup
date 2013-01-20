package cn.edu.wyq.algorithm.perfectnumber;

import java.util.Scanner;

/**
 * @author wangyinqing
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please input a range of looking for perfect nunbers");
		Scanner scan = new Scanner(System.in);
		long input = scan.nextLong(10);
		PerfectNumber p = new PerfectNumber();
		for (long i = 1; i <= input; i++) {
			p.isPerfectNumber(i);
		}
		scan.close(); 
	}

}
// 6, 28, 496, 8128,33550336, 8589869056