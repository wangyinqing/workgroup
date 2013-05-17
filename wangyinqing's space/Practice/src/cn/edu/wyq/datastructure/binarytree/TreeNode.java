package cn.edu.wyq.datastructure.binarytree;

/**
 * 
 * 
 * @author wangyinqing
 *
 * @param <E>
 */
class TreeNode<E> {
	E value;
	TreeNode<E> left = null;
	TreeNode<E> right = null;
	
	public TreeNode(E e){
		this.value = e;
	}

	public boolean isLeaf(){
		return left == null && right == null;
	}
	
}
