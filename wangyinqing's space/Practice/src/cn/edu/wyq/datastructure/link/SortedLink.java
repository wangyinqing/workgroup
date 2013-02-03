package cn.edu.wyq.datastructure.link;

public class SortedLink<E extends Comparable<? super E>> {
	private LinkedNode<E> first;
	private int size = 0;
	
	public SortedLink(){
		
	}
	
	public void insert(E e){
		if(first == null){
			first = new LinkedNode<E>(e);
		}else{
			LinkedNode<E> node = first;
			while(node.next != null)
				node = node.next;
			node.next = new LinkedNode<E>(e);
		}
		size++;
	}
	
	
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
		for(int i=0;i<size;i++){
			if(array == null)
				array = (E[])java.lang.reflect.Array.newInstance(node.value.getClass(), size);
			array[i] = node.value;
			node = node.next;
		}
		return array;
	}
	
	static class LinkedNode<E>{
		E value;
		LinkedNode<E> next = null;
		
		
		private LinkedNode(E e){
			this.value = e;
		}
			
	}
	
	
	

}
