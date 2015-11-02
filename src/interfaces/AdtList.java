package interfaces;


public interface AdtList {
	
	/**
	 * 
	 * @return
	 */
	public static AdtList create() {
		return null;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean isEmpty(AdtList list);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int laenge(AdtList list);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 * @param elem
	 */
	public void insert(AdtList list, int pos, int elem);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 */
	public void delete(AdtList list, int pos);
	
	/**
	 * 
	 * @param list
	 * @param elem
	 * @return
	 */
	public int find(AdtList list, int elem);
	
	/**
	 * 
	 * @param list
	 * @param pos
	 * @return
	 */
	public int retrieve(AdtList list, int pos);
	
	/**
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public AdtList concat(AdtList list1, AdtList list2);
}
