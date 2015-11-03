package implementations;

import interfaces.AdtArray;
import interfaces.AdtList;

public class AdtArrayImpl implements AdtArray
{
    private AdtList _array;
    
    /**
     * privater Konstruktor
     */
    private AdtArrayImpl()
    {
        _array = AdtListImpl.create();
    }
    
    /**
     * Initialisiert das Objekt
     * 
     * @return AdtArray
     */
    public static AdtArray initA() {
        return new AdtArrayImpl();
    }
    
    /**
     * Fuegt an dem aufrufenden Array ein Element an einer bestimmten Position hinzu
     * Wenn die Position kleiner als 0 ist, wird das Element nicht hinzugefuegt
     * Wenn die Position groesser als die aktuelle Laenge ist, 
     *                 wird das Array erweitert und die neuen Felder mit 0 beschrieben
     * 
     * @param AdtArray array -> wird ignoriert
     * @param int pos
     * @param int elem
     */
    @Override
    public void setA(AdtArray array, int pos, int elem)
    {
        if(pos >= 0) {
            while(pos > _array.laenge(_array)) {
                _array.insert(_array, _array.laenge(_array), 0);
            }
            _array.delete(_array, pos + 1);
            _array.insert(_array, pos, elem);
        }
    }

    /**
     * Gibt das Element an der Position zurueck
     * Wenn die Position ungueltig ist (kleiner als 0 oder groesser als die Laenge) wird 0 zurueckgegeben
     * 
     * @param AdtArray array -> wird ignoriert
     * @param int pos
     * @return int, das Element
     */
    @Override
    public int getA(AdtArray array, int pos)
    {
        if(pos >= 0 && pos <= _array.laenge(_array)) {
            return _array.retrieve(_array, pos + 1); 
        }
        return 0;
    }

    /**
     * Gibt die Laenge des Arrays zurueck
     * 
     * @param AdtArray array -> wird ignoriert
     * @return int, die Laenge
     */
    @Override
    public int lengthA(AdtArray array)
    {
       return _array.laenge(_array);
    }
}
