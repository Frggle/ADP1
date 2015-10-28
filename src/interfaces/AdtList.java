package interfaces;

public interface AdtList {
	
	// TODO: unsicher bezüglich Rückgabewert/typ
	
	/**
	 * 
	 * @return
	 */
	static AdtList create() {
		return null;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	boolean isEmpty(AdtList list);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	int laenge(AdtList list);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 * @param elem
	 */
	void insert(AdtList list, int pos, int elem);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 */
	void delete(AdtList list, int pos);
	
	/**
	 * 
	 * @param list
	 * @param elem
	 * @return
	 */
	int find(AdtList list, int elem);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 * @return
	 */
	int retrieve(AdtList list, int pos);
	
	/**
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	AdtList concat(AdtList list1, AdtList list2);
}
