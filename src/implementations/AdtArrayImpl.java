package implementations;

import interfaces.AdtArray;
import interfaces.AdtList;

public class AdtArrayImpl implements AdtArray
{
    private AdtList _array;
    
    private AdtArrayImpl()
    {
        _array = AdtListImpl.create();
    }
    
    public static AdtArray initA() {
        return new AdtArrayImpl();
    }
    
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

    @Override
    public int getA(AdtArray array, int pos)
    {
        if(!(pos < 0 && pos >= _array.laenge(_array))) {
            return _array.retrieve(_array, pos + 1); 
        }
        return Integer.MIN_VALUE; // TODO ?
    }

    @Override
    public int lengthA(AdtArray array)
    {
       return _array.laenge(_array);
    }
}
