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
			if("size".equalsIgnoreCase(s)){
				System.out.println("size is " + sa.size());
			} else if("ra".equalsIgnoreCase(s)){
				sa.removeAll();
				System.out.println("array has been cleared");
			} else if("d".equalsIgnoreCase(s)){
				for(int i=0;i<sa.size();i++){
					System.out.print(sa.get(i) + " ");
				}
				System.out.println();
			} else if(s.startsWith("f")){
				try{
					Integer i = Integer.parseInt(s.substring(1,s.length()));
					boolean found = sa.contains(i);
					System.out.println(i + (found?" was ":" was not ") + "found");
				}catch(NumberFormatException e){
				}
			} else if(s.startsWith("r")){
				try{
					Integer i = Integer.parseInt(s.substring(1,s.length()));
					boolean removed = sa.remove(i);
					System.out.println(i + (removed?" was ":" was not ") + "removed");
				}catch(NumberFormatException e){
				}
			} else{
				try{
					Integer i = Integer.parseInt(s);
					boolean added = sa.add(i);
					System.out.println(i + (added?" was ":" was not ") + "added");
				}catch(NumberFormatException e){
				}
			}
			s = scan.next();
		}
		scan.close();
	}

}
