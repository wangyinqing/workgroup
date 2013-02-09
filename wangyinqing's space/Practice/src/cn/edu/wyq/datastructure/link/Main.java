package cn.edu.wyq.datastructure.link;

import java.util.Scanner;

import cn.edu.wyq.util.StringUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SortedLink<Integer> sl = new SortedLink<Integer>();
		String s = scan.next();
		while(!"q".equalsIgnoreCase(s)){
			if("size".equalsIgnoreCase(s)){
				System.out.println("size is " + sl.size());
			} else if("ra".equalsIgnoreCase(s)){
				sl.removeAll();
				System.out.println("array has been cleared");
			} else if("d".equalsIgnoreCase(s)){
				System.out.println(StringUtil.combine2String(sl.toArray(), "-->"));
			} else if(s.startsWith("f")){
				try{
					Integer i = Integer.parseInt(s.substring(1,s.length()));
					boolean found = sl.contains(i);
					System.out.println(i + (found?" was ":" was not ") + "found");
				}catch(NumberFormatException e){
				}
			} else if(s.startsWith("r")){
				try{
					Integer i = Integer.parseInt(s.substring(1,s.length()));
					boolean removed = sl.delete(i);
					System.out.println(i + (removed?" was ":" was not ") + "removed");
				}catch(NumberFormatException e){
				}
			} else{
				try{
					Integer i = Integer.parseInt(s);
					boolean added = sl.insert(i);
					System.out.println(i + (added?" was ":" was not ") + "added");
				}catch(NumberFormatException e){
				}
			}
			s = scan.next();
		}
		scan.close();
	}

}
