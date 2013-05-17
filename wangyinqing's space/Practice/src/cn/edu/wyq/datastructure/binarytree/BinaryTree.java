package cn.edu.wyq.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree
 * 
 * @author wangyinqing
 *
 * @param <E>
 */
public class BinaryTree<E extends Comparable<? super E>> {
	TreeNode<E> root;
	
	public void insert(E e){
		if(root == null)
			root = new TreeNode<E>(e); // if root is null, build root
		else{
			TreeNode<E> current = root;
			TreeNode<E> parent;
			for(;;){
				parent = current;
				if(e.compareTo(current.value) < 0){
					current = current.left;
					if(current == null){
						parent.left = new TreeNode<E>(e);
						break;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = new TreeNode<E>(e);
						break;
					}
				}
			}
		}
	}
	
	public List<E> preOrder(){
		return preOrder(root, new ArrayList<E>());
	}
	
	public List<E> preOrder(TreeNode<E> node, List<E> list){
		if(node != null){
			list.add(node.value);
			inOrder(node.left, list);
			inOrder(node.right, list);
		}
		return list;
	}
	
	public List<E> inOrder(){
		return inOrder(root, new ArrayList<E>());
	}
	
	public List<E> inOrder(TreeNode<E> node, List<E> list){
		if(node != null){
			inOrder(node.left, list);
			list.add(node.value);
			inOrder(node.right, list);
		}
		return list;
	}
	
	public List<E> postOrder(){
		return postOrder(root, new ArrayList<E>());
	}
	
	public List<E> postOrder(TreeNode<E> node, List<E> list){
		if(node != null){
			inOrder(node.left, list);
			inOrder(node.right, list);
			list.add(node.value);
		}
		return list;
	}
	
	public boolean contains(E e){
		TreeNode<E> current = root;
		while(e.compareTo(current.value) != 0){
			if(e.compareTo(current.value) < 0)
				current = current.left;
			else
				current = current.right;
			if(current == null)
				return false;
		}
		return true;
	}
	
	public boolean delete(E e){
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		boolean isLeft = false;
		while(current.value.compareTo(e) != 0){
			parent = current;
			if(current.left.value.compareTo(e) < 0){
				isLeft = true;
				current = current.left;
			}else{
				isLeft = false;
				current = current.right;
			}
			if(current == null)
				return false;
		}
		if(current.isLeaf()){
			if(parent == null)
				root = null;
			else if(isLeft)
				parent.left = null;
			else 
				parent.right = null;	
		} else if (current.left == null){
			if (parent == null)
				root = current.right;
			else if(isLeft)
				parent.left = current.right;
			else
				parent.right = current.right;
		} else if (current.right == null){
			if (parent == null)
				root = current.left;
			else if(isLeft)
				parent.left = current.left;
			else
				parent.right = current.left;
		} else{
			
		}
		return true;
	}

}
