package implementations;

import interfaces.AdtArray;
import interfaces.AdtList;

public class StartUp {
	
	public static void main(String[] args) {
//		AdtList adt = AdtListImpl.create();
//		AdtList adt2 = AdtListImpl.create();
//				
//		adt.insert(adt, 1, 10);
//		adt.insert(adt, 2, 9);
//		adt.insert(adt, 3, 12);
//		
//		adt2.insert(adt2, 1, 100);
//	    adt2.insert(adt2, 2, 150);
//	    
//	    System.err.println(adt.retrieve(adt2, 3));
//	    
//	    System.err.println(adt.concat(adt, adt2));
//		
	    AdtArray _array = AdtArrayImpl.initA();
	    System.err.println(_array.lengthA(_array));
	    
//		adt.delete(adt, 2);
//		System.err.println(adt.laenge(adt));
		
//		System.err.println("find " + adt.find(adt, 12));
//		System.err.println("retrieve " + adt.retrieve(adt, 2));
		
//		System.err.println(adt2.isEmpty(adt));
//		System.err.println(adt2.laenge(adt2));
	}
	
}
