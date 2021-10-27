/* File: a generic bag data structure implementation.
 */
public interface BagInterface<E> {

	final int DEFAULT_CAPACITY = 10;
	
	/* Gets the current number of enters in this bag.
	 * @return  The integer number of entries currently in the bag.
	 */
	public int getCurrentSize();
	
	/* Checks whether this bag is empty.
	 * @return  True if the bag is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/* Adds a new entry to this bag.
	 * @param  newEntry  The object to be added to as a new entry.
	 * @return true if the addition is successful, false otherwise.
	 */
	public boolean add(E newEntry);
	
	/* Remove one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry if successful, null otherwise.
	 */
	public E remove();
	
	/* Removes one occurrence of a given entry from this bag, if possible.
	 * @param  anEntry  The entry to be removed.
	 * @return true if te removal was successful, false otherwise
	 */
	public boolean remove(E anEntry);
	
	/* Removes all entries from this bag.
	 */
	public void clear();
	
	/* Counts the number of times a given entry appears in this bag.
	 * @param  anEntry  The entry to be counted.
	 * @return  The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(E anEntry);
	 
	/* Tests whether this bag contains a given entry.
	 * @param  anEntry   The entry to locate.
	 * @return true if the bag contains anEntry, false otherwise.
	 */
	public boolean contains(E anEntry);
	
	/* Retrieves all entries that are in this bag.
	 * @return  A newly allocated array of all the entries in this bag.
	 *          If the bag is empty, returns an empty array.
	 */
	public E[] toArray();
}