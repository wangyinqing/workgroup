package cn.edu.wyq.datastructure.binarytree;

import java.util.Scanner;

import cn.edu.wyq.util.StringUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		String s = scan.next();
		while (!"q".equalsIgnoreCase(s)) {
			if (s.startsWith("f")) {
				try {
					int i = Integer.parseInt(s.substring(1, s.length()));
					boolean contains = btree.contains(i);
					System.out.println("Tree " + (contains ? "has " : "has not ") + i);
				} catch (NumberFormatException e) {
				}
			} else if (s.startsWith("in")) {
				System.out.println(StringUtil.combine2String(btree.inOrder(), ";"));
			} else if (s.startsWith("pr")) {
				System.out.println(StringUtil.combine2String(btree.preOrder(), ";"));
			} else if (s.startsWith("po")) {
				System.out.println(StringUtil.combine2String(btree.postOrder(), ";"));
			} else {
				try {
					int i = Integer.parseInt(s.substring(1, s.length()));
					btree.insert(i);
				} catch (NumberFormatException e) {
				}
			}  
			s = scan.next();
		}
		scan.close();
	}

}
