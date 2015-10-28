package implementations;

import interfaces.AdtList;

/**
 * 
 * @author Marc
 *
 */
public class AdtListImpl implements AdtList {

	protected int _list[]; // protected statt private ggf. für Vererbung
//	protected List<Integer> _list;
	
	/**
	 * privater Konstruktor
	 */
	private AdtListImpl() {
		_list = new int[0];
//		_list = new ArrayList<Integer>();
	}
	
	/**
	 * Initialisiert das Objekt
	 * @return
	 */
	public static AdtList create() {
		return new AdtListImpl();
	}

	
	// TODO
	//	Warum wird das referenzierte Objekt im Parameter mit übergeben? -> Methode wird doch am referenzierten Objekt aufgerufen
	//	Muss intern ein Array (new int[]) benutzt werden oder ist ArrayList erlaubt?
	// Ende TODO
	
	@Override
	public boolean isEmpty(AdtList list) {
		if(list.laenge(list) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int laenge(AdtList list) {
		return _list.length;
	}

	@Override
	public void insert(AdtList list, int pos, int elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AdtList list, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int find(AdtList list, int elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int retrieve(AdtList list, int pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdtList concat(AdtList list1, AdtList list2) {
		// TODO Auto-generated method stub
		return null;
	}
}
