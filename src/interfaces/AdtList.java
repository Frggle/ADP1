package interfaces;


public interface AdtList {
	
	public static AdtList create() {
		return null;
	}
	
	public boolean isEmpty(AdtList list);
	
	public int laenge(AdtList list);
	
	public void insert(AdtList list, int pos, int elem);
	
	public void delete(AdtList list, int pos);
	
	public int find(AdtList list, int elem);
	
	public int retrieve(AdtList list, int pos);

	public AdtList concat(AdtList list1, AdtList list2);
}
