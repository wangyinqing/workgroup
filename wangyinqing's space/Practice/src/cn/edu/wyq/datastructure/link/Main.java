package cn.edu.wyq.datastructure.link;

import java.util.Scanner;

import cn.edu.wyq.util.StringUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		SortedLink<Integer> sl = new SortedLink<Integer>();
		while(!"q".equalsIgnoreCase(s)){
			if(s.startsWith("d")){
				int i = Integer.parseInt(s.substring(1,s.length()));
				boolean deleted = sl.delete(i);
				System.out.println(i + (deleted ? " was ": " was not ") + "deleted");
			}else if(s.startsWith("p")){
				System.out.println(StringUtil.combine2String(sl.toArray(), "-->"));
			}else{
				int i = Integer.parseInt(s);
				sl.insert(i);
			}
			s = scan.next();
		}
		scan.close();
	}

}
