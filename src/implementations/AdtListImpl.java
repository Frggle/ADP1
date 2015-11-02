package implementations;

import java.util.Arrays;

import interfaces.AdtList;

/**
 * 
 * @author Marc & Constantin
 *
 */
public class AdtListImpl implements AdtList
{

    private int[] _array; 
    
    private int _laenge;
    
    /**
     * privater Konstruktor
     */
    private AdtListImpl()
    {
        _array = new int[100];
        _laenge = 0;
    }

    /**
     * Initialisiert das Objekt
     * 
     * @return
     */
    public static AdtList create()
    {
        return new AdtListImpl();
    }

    @Override
    public boolean isEmpty(AdtList list)
    {
        return (_laenge == 0 ? true : false);
    }

    @Override
    public int laenge(AdtList list)
    {
        return _laenge;
    }

    @Override
    public void insert(AdtList list, int pos, int elem)
    {
        if (pos <= list.laenge(list) + 1)
        {
            // pruefen, ob max. Groesse von Array erreicht -> wenn ja
            // vergroessern und kopieren
            if (list.laenge(list) == _array.length)
            {
                int[] _tmpArray = _array;
                _array = new int[_array.length + 100];
                for (int i = 0; i <= _tmpArray.length; i++)
                {
                    _array[i] = _tmpArray[i];
                }
            }
            _array[list.laenge(list)] = elem;
            _laenge++;
        }
    }
    
    @Override
    public void delete(AdtList list, int pos)
    {
        if (pos <= list.laenge(list))
        {
            for (int i = pos - 1; i <= list.laenge(list); i++)
            {
                _array[i] = _array[i + 1];
            }
            _laenge--;
        }
    }

    @Override
    public int find(AdtList list, int elem)
    {
        for(int i = 0; i <= list.laenge(list); i++) 
        {
            if (_array[i] == elem)
            {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public int retrieve(AdtList list, int pos)
    {
        if(pos > list.laenge(list) || pos <= 0) {
            return -99999999;
        }
        return _array[pos - 1];
    }

    @Override
    public AdtList concat(AdtList list1, AdtList list2)
    {
        for (int i = 0; i < list2.laenge(list2); i++)
        {
            this.insert(list1, i + 1, list2.retrieve(list2, i + 1));
        }
        return list1;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(_array);
        result = prime * result + _laenge;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AdtListImpl other = (AdtListImpl) obj;
        if (!Arrays.equals(_array, other._array))
            return false;
        if (_laenge != other._laenge)
            return false;
        return true;
    }
}
