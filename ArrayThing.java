import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class ArrayThing<E> implements Iterable<E> {
	int size;
	E[] bag;
	long concurrentModificationCounter;
	
	@SuppressWarnings("unchecked")
	public ArrayThing() {
		size = 0;
		bag = (E[]) new Object[10];
	}
	
	public void add(E obj) {
		bag[size] = obj;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public E get(int index) {
		return bag[index];
	}
	
	public Iterator<E> iterator() {
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<E> {
		int currentIndex = 0;
		long modCounter = concurrentModificationCounter;
		
		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}
		
		@Override
		public E next() {
			if (modCounter != concurrentModificationCounter) {
				throw new ConcurrentModificationException();
			}
			E element = null;
			if (hasNext()) {
				element = bag[currentIndex++];
			}
			return element;
		}
	}
}
