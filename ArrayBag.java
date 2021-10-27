//TODO gotta import stuff here

public class ArrayBag implements BagInterface{
	
	//Temporary arr to act as our bag
	private Object[] arr;
	
	//Default constructor that assumes DEFAULT_CAPACITY as the capacity for the bag
	public ArrayBag() {
		arr = new Object[DEFAULT_CAPACITY];
	}
	
	//Overloaded constructor that takes user capacity for the bag
	public ArrayBag(int baseSpace) {
		arr = new Object[DEFAULT_CAPACITY];
	}
	
	/* Gets the current number of enters in this bag.
	 * @return  The integer number of entries currently in the bag.
	 */
	@Override
	public int getCurrentSize() {
		// TODO Fix this pseudo code
		int counter = 0;
		
		for(Object elem : arr) {
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
		
		if(arr == null) {
			return true;
		} else {
			return false;
		}
	}

	/* Adds a new entry to this bag.
	 * @param  newEntry  The object to be added to as a new entry.
	 * @return true if the addition is successful, false otherwise.
	 */
	@Override
	public boolean add(Object newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	/* Remove one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry if successful, null otherwise.
	 */
	@Override
	public Object remove() {
		// TODO Fix pseudo code + add real code
		if(!isEmpty()) {
			//Remove 'unspecified' entry and return it
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
			//Remove anEntry from arr
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
		//What happens if I just set the whole arr = null?
		
	}

	/* Counts the number of times a given entry appears in this bag.
	 * @param  anEntry  The entry to be counted.
	 * @return  The number of times anEntry appears in the bag.
	 */
	@Override
	public int getFrequencyOf(Object anEntry) {
		// TODO Fix pseudo code
		int counter = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == anEntry) {
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
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == anEntry) {
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
		Object freshArr[] = new Object[arr.length];
		if(!isEmpty()) {
			//Fill freshArr with all elems from arr using enhanced for-loop
		} else {
			freshArr = null;
		}
		return freshArr;
	}

}
