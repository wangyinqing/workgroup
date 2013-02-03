package cn.edu.wyq.datastructure.array;

/**
 * @author wangyinqing
 *
 * @param <E>
 */
public class SortedArray<E extends Comparable<? super E>> {
	private Comparable<?super E>[] elements;
	private int size = 0;
	
	public SortedArray(){
		elements = new Comparable[5];
	}
	
	public boolean add(E e){
		ensureCapacity(size);
		elements[size++] = e;
		return true;
	}
	
	public boolean remove(E e) {
		return true;
	}
	
	public int indexOf(E e){
		return -1;
	}
	
	private void ensureCapacity(int size){
		int capacity = elements.length;
		if(size < capacity ){
			return;
		}else{
			capacity = capacity << 1;
		}
		Comparable[] newElement = new Comparable[capacity];
		System.arraycopy(elements, 0, newElement, 0, elements.length);
		elements = newElement;
	}
	
	public int size(){
		return size;
	}
	
	public E get(int i){
		if(i < 0) throw new IllegalArgumentException();
		if(i > size) throw new IndexOutOfBoundsException();
		return (E)elements[i];
	}
}
