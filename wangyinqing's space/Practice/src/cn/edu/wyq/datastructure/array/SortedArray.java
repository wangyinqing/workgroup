package cn.edu.wyq.datastructure.array;

/**
 * Ordered array stores all elements in ascending, it does not allow null value, 
 * also does not allow duplicated elements.
 * 
 * @author wangyinqing
 *
 * @param <E>
 */
public class SortedArray<E extends Comparable<? super E>> {
	
	/**
	 * array that stores the elements
	 */
	private Comparable<?super E>[] elements;
	
	/**
	 * size of the actual array, must <= elements size
	 */
	private int size = 0;
	
	/**
	 * the initial array length of the elements array
	 */
	private int initialCapacity = 10;
	
	public SortedArray(){
		elements = new Comparable[initialCapacity];
	}
	
	public SortedArray(int initialCapacity){
		elements = new Comparable[initialCapacity];
		this.initialCapacity = initialCapacity;
	}

	
	/**
	 * add the element, if the element is already in the array, return false, else return true
	 * 
	 * @param e
	 * @return
	 */
	public boolean add(E e){
		if(e == null)
			return false;
		ensureCapacity(size);
		int insert = findNearest(e);
		if(insert < 0)
			return false;
		System.arraycopy(elements, insert, elements, insert + 1, elements.length - insert - 1);
		elements[insert] = e;
		size++;
		return true;
	}
	
	/**
	 * Find the nearest index of the give array, the index is used to insert, the index of the original must be 
	 * the least larger value than the specified element
	 * 
	 * @param e
	 * @return
	 */
	protected int findNearest(E e) {
		return getIndex(e, false);
	}
	
	protected int getIndex(E e, boolean isExactIndex) {
		int left = 0;
		int right = size;
		int mid = (left + right) / 2;
		while (left <= right && mid < size) {
			E selected = (E) elements[mid];
			if (selected.equals(e))
				return isExactIndex ? mid : -1;
			else if (e.compareTo(selected) < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
//		return right < left ? left : right;
		return isExactIndex ? -1 : left;
	}
	
	
	/**
	 * true if element is in the array
	 * 
	 * @param e element
	 * @return true if contains
	 */
	public boolean contains(E e) {
		int left = 0;
		int right = size;
		int mid = (left + right) / 2;
		while (left <= right && mid < size) {
			E selected = (E) elements[mid];
			if (selected.equals(e))
				return true;
			else if (e.compareTo(selected) < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		return false;
	}
	
	/**
	 * remove the specified element
	 * 
	 * @param e element to remove
	 * @return true if removed, false if the element is not in the array
	 */
	public boolean remove(E e) {
		int index = indexOf(e);
		if(index < 0)
			return false;
		System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
		elements[--size] = null;
		return true;
	}
	
	/**
	 * remove all elements of the array
	 */
	public void removeAll(){
		elements = new Comparable[this.initialCapacity];
		size = 0;
	}
	
	/**
	 * return the array size
	 * 
	 * @return
	 */
	public int size(){
		return size;
	}
	
	/**
	 * return the index of the element, if array does not contain it, return -1
	 * 
	 * @param e element
	 * @return index of the element, -1 if not found
	 */
	public int indexOf(E e){
		return getIndex(e, true);
	}
	
	private void ensureCapacity(int size){
		int capacity = elements.length;
		if(size < capacity ){
			return;
		}else{
			capacity = capacity << 1;
		}
		Comparable<?super E>[] newElement = new Comparable[capacity];
		System.arraycopy(elements, 0, newElement, 0, elements.length);
		elements = newElement;
	}
	
	/**
	 * get the element by the index
	 * 
	 * @param i
	 * @return
	 */
	public E get(int i){
		if(i < 0) throw new IllegalArgumentException();
		if(i > size) throw new IndexOutOfBoundsException();
		return (E)elements[i];
	}
}
