package implementations;

import interfaces.AdtList;
import interfaces.AdtStack;

public class AdtStackImpl implements AdtStack
{
    private AdtList _stack;
 
    /**
     * privater Konstruktor
     */
    private AdtStackImpl()
    {
        _stack = AdtListImpl.create();
    }
    
    /**
     * Initialisiert das Objekt
     * 
     * @return AdtStack
     */
    public static AdtStack createS() {
        return new AdtStackImpl();
    }
    
    /**
     * Legt das Element oben auf den Stack
     * 
     * @param AdtStack stack -> wird ignoriert
     * @param int elem
     */
    @Override
    public void push(AdtStack stack, int elem)
    {
        _stack.insert(_stack, 1, elem);
    }

    /**
     * Entfernt das oberste Element vom Stack
     * Wenn der Stack leer ist, wird nichts gemacht
     * 
     * @param AdtStack stack -> wird ignoriert
     */
    @Override
    public void pop(AdtStack stack)
    {
        if(_stack.laenge(_stack) != 0) {
            _stack.delete(_stack, 1);
        }
    }

    /**
     * Liefert das oberste Element vom Stack
     * 
     * @param AdtStack stack -> wird ignoriert
     * @return int, das Element
     */
    @Override
    public int top(AdtStack stack)
    {
        if(!_stack.isEmpty(_stack)) {
            return _stack.retrieve(_stack, 1);
        }
        return _stack.retrieve(_stack, 0);
    }

    /**
     * Prueft ob der Stack leer ist
     * 
     * @param AdtStack stack -> wird ignoriert
     * @return boolean, ob Stack leer
     */
    @Override
    public boolean isEmptyS(AdtStack stack)
    {
        return _stack.isEmpty(_stack);
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_stack == null) ? 0 : _stack.hashCode());
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
        AdtStackImpl other = (AdtStackImpl) obj;
        if (_stack == null)
        {
            if (other._stack != null)
                return false;
        } else if (!_stack.equals(other._stack))
            return false;
        return true;
    }
}
