package cn.edu.wyq.datastructure.array;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedArray<Integer> sa = new SortedArray<Integer>();
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		while(!"q".equalsIgnoreCase(s)){
			if("d".equalsIgnoreCase(s)){
				for(int i=0;i<sa.size();i++){
					System.out.print(sa.get(i) + " ");
				}
				System.out.println();
			}else{
				try{
					Integer i = Integer.parseInt(s);
					sa.add(i);
				}catch(NumberFormatException e){
					
				}
			}
			s=scan.next();
		}
		scan.close();
	}

}
