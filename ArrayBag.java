//TODO gotta import stuff here
import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class ArrayBag<E> implements BagInterface{
	
	//Same code from ArrayThing
	int size;
	E[] bag;
	long concurrentModificationCounter;
	
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		size = 0;
		bag = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	/* Gets the current number of enters in this bag.
	 * @return  The integer number of entries currently in the bag.
	 */
	@Override
	public int getCurrentSize() {
		// TODO Fix this pseudo code
		int counter = 0;
		
		for(Object elem : bag) {
			counter++;
		}
		return 0;
	}

	/* Checks whether this bag is empty.
	 * @return  True if the bag is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Fix pseudo code
		
		if(bag == null) {
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
		// TODO Fix code here
		//Check if item fits within index
		bag[size] = (E) newEntry;
		size++;
		return true;
		
		//return false;
	}

	/* Remove one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry if successful, null otherwise.
	 */
	@Override
	public Object remove() {
		// TODO Fix pseudo code + add real code
		if(!isEmpty()) {
			//Remove 'unspecified' entry and return it
			//I am assuming that this function is the same as .get(index) from ArrayThing
			return bag[size];
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
		// TODO Fix pseudo code + add real code
		if(contains(anEntry)) {
			//Remove anEntry from bag
			
			//Need to find index of anEntry. patch() will close the null hole
			//bag[index] = null;
			//patch()
			
			return true;
		} else {
			return false;
		}
	}

	/* Removes all entries from this bag.
	 */
	@Override
	public void clear() {
		// TODO implement method
		
		//Use for loop?
		//What happens if I just set the whole bag = null?
		
	}

	/* Counts the number of times a given entry appears in this bag.
	 * @param  anEntry  The entry to be counted.
	 * @return  The number of times anEntry appears in the bag.
	 */
	@Override
	public int getFrequencyOf(Object anEntry) {
		// TODO Fix pseudo code
		int counter = 0;
		
		for(int i = 0; i < bag.length; i++) {
			if(bag[i] == anEntry) {
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
		// TODO Fix pseudo code
		boolean exists = false;
		
		for(int i = 0; i < bag.length; i++) {
			if(bag[i] == anEntry) {
				exists = true;
				break;
				//Check to see if break actually works. I really gotta learn how to use this...
			}
		}
		
		return exists;
	}

	/* Retrieves all entries that are in this bag.
	 * @return  A newly allocated array of all the entries in this bag.
	 *          If the bag is empty, returns an empty array.
	 */
	@Override
	public Object[] toArray() {
		// TODO Fix pseudo code + add real code
		Object freshArr[] = new Object[bag.length];
		if(!isEmpty()) {
			//Fill freshArr with all elems from bag using enhanced for-loop
		} else {
			freshArr = null;
		}
		return freshArr;
	}
	
	//TODO make extend() to make array bigger/infinite
	//TODO make patch() to adjust array when an item is removed
	
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
