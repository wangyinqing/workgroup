package cn.edu.wyq.datastructure.link;

/**
 * Sorted linked list, all values inserted are sorting in ascending
 * 
 * @author wangyinqing
 *
 * @param <E>
 */
public class SortedLink<E extends Comparable<? super E>> {
	private LinkedNode<E> first;
	private int size = 0;
	
	public SortedLink(){
	}
	
	/**
	 * @param e
	 * @return
	 */
	public boolean insert(E e){
		boolean added = false;
		if(first == null){
			first = new LinkedNode<E>(e);
			added = true;
		}else{
			LinkedNode<E> node = first;
			LinkedNode<E> pre = null;
			while(node != null){
				if(node.value.compareTo(e) == 0){
					return false;
				}
				if(node.value.compareTo(e) > 0){
					if(pre == null){
						first = new LinkedNode<E>(e);
						first.next = node;
					}else{
						pre.next = new LinkedNode<E>(e);
						pre.next.next = node;
					}
					added = true;
					break;
				}else{
					pre = node;
					node = node.next;
				}
			}
			if(!added){
				pre.next = new LinkedNode<E>(e);
			}
		}
		size++;
		return added;
	}
	
	
	/**
	 * @param e
	 * @return
	 */
	public boolean delete(E e) {
		if (first == null) {
			return false;
		}
		LinkedNode<E> current = first;
		LinkedNode<E> previous = null;
		while (current != null) {
			if (current.value.compareTo(e) == 0) {
				if (previous == null) {
					first = current.next;
				} else {
					previous.next = current.next;
				}
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public E[] toArray(){
		E[] array = null; 
		LinkedNode<E> node = first;
		for (int i = 0; i < size; i++) {
			if(array == null)
				array = (E[])java.lang.reflect.Array.newInstance(node.value.getClass(), size);
			array[i] = node.value;
			node = node.next;
		}
		return array;
	}
	
	public int size(){
		return size;
	}
	
	
	public void removeAll(){
		LinkedNode<E> node = first;
		while(node.next != null){
			LinkedNode<E> temp = node.next;
			node.next = null;
			node = temp;
			size--;
		}
		first = null;
		size--;
	}
	
	/**
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		LinkedNode<E> node = first;
		while(node != null){
			if(node.value.compareTo(e) == 0)
				return true;
			node =node.next;
		}
		return false;
	}
	
	static class LinkedNode<E>{
		E value;
		LinkedNode<E> next = null;
		
		private LinkedNode(E e){
			this.value = e;
		}
	}
	
	

}
