package implementations;

import interfaces.AdtList;

public class StartUp {
	
	public static void main(String[] args) {
		AdtList adt = AdtListImpl.create();
		AdtList adt2 = AdtListImpl.create();
				
		adt2.insert(adt, 0, 1);
		
		System.err.println(adt.isEmpty(adt));
		System.err.println(adt2.isEmpty(adt));
		System.err.println(adt2.laenge(adt2));
	}
	
}
