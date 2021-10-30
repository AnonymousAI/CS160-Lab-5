//TODO gotta import stuff here
import java.util.Iterator;
//import java.util.Arrays;
import java.util.Random;
import java.util.ConcurrentModificationException;

public class ArrayBag<E> implements BagInterface<E>, Iterable<E>{
	
	//Same code from ArrayThing
	private int size;
	private int elem;
	private E[] bag;
	private long concurrentModificationCounter;
	private Random ran = new Random();
	
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		size = DEFAULT_CAPACITY;
		elem = 0;
		bag = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	/* Gets the current number of enters in this bag.
	 * @return  The integer number of entries currently in the bag.
	 */
	@Override
	public int getCurrentSize() {
		return size;
	}

	/* Checks whether this bag is empty.
	 * @return  True if the bag is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if(bag == null || bag[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	/* Adds a new entry to this bag.
	 * @param  newEntry  The object to be added to as a new entry.
	 * @return true if the addition is successful, false otherwise.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object newEntry) {
		if(isEmpty()) {
			size = DEFAULT_CAPACITY;
			bag = (E[]) new Object[DEFAULT_CAPACITY];
			bag[elem] = (E) newEntry;
			elem++;
			return true;
		} else if(elem == size) {
			extend();
			bag[elem] = (E) newEntry;
			elem++;
			return true;
		} else if(elem < size) {
			bag[elem] = (E) newEntry;
			elem++;
			return true;
		} else {
			return false;
		}
	}

	/* Remove one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry if successful, null otherwise.
	 */
	@Override
	public E remove() {
		int index = ran.nextInt(elem);
		E obj;
		
		if(!isEmpty()) {
			obj = bag[index];
			patch(index);
			return obj;
		} else {
			return null;
		}
	}
	
	/* Removes one occurrence of a given entry from this bag, if possible.
	 * @param  anEntry  The entry to be removed.
	 * @return true if the removal was successful, false otherwise
	 */
	@Override
	public boolean remove(Object anEntry) {
		if(contains(anEntry)) {
			for(int i = 0; i < elem; i++) {
				if(bag[i].equals(anEntry)) {
					patch(i);
					break;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/* Removes all entries from this bag.
	 */
	@Override
	public void clear() {
		bag = null;
		size = 0;
		elem = 0;
	}

	/* Counts the number of times a given entry appears in this bag.
	 * @param  anEntry  The entry to be counted.
	 * @return  The number of times anEntry appears in the bag.
	 */
	@Override
	public int getFrequencyOf(Object anEntry) {
		int counter = 0;
		
		for(int i = 0; i < elem; i++) {
			if(bag[i].equals(anEntry)) {
				counter++;
			}
		}
		
		return counter;
	}

	/* Tests whether this bag contains a given entry.
	 * @param  anEntry   The entry to locate.
	 * @return true if the bag contains anEntry, false otherwise.
	 */
	@Override
	public boolean contains(Object anEntry) {
		boolean exists = false;
		
		for(int i = 0; i < elem; i++) {
			if(bag[i].equals(anEntry)) {
				exists = true;
				break;
			}
		}
		
		return exists;
	}

	/* Retrieves all entries that are in this bag.
	 * @return  A newly allocated array of all the entries in this bag.
	 *          If the bag is empty, returns an empty array.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		Object freshArr[] = new Object[elem];
		if(!isEmpty()) {
			for(int i = 0; i < elem; i++) {
				freshArr[i] = bag[i];
			}
		} else {
			freshArr = null;
		}
		return (E[]) freshArr;
	}
	
	//Makes array bigger/infinite
	@SuppressWarnings("unchecked")
	public void extend() {
		E temp[] = null;
		if(elem == size) {
			temp = (E[]) new Object[getCurrentSize() * 2]; 
			{
				for(int i = 0; i < size; i++) {
					temp[i] = bag[i];
				}
			}
			
		}
		
		bag = temp;
		size *= 2;
	}
	
	//Puts last element in hole
	public void patch(int index) {
		bag[index] = bag[elem - 1];
		bag[elem - 1] = null;
		elem--;
	}
	
	//Code is taken directly from ArrayThing. I need an Iterator for some reason
	//TODO Figure out what Iterator is used for. Something about counting things?
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
