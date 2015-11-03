package implementations;

import interfaces.AdtList;
import interfaces.AdtStack;

public class AdtStackImpl implements AdtStack
{
    private AdtList _stack;
    
    private AdtStackImpl()
    {
        _stack = AdtListImpl.create();
    }
    
    public static AdtStack createS() {
        return new AdtStackImpl();
    }
    
    @Override
    public void push(AdtStack stack, int elem)
    {
        _stack.insert(_stack, 1, elem);
    }

    @Override
    public void pop(AdtStack stack)
    {
        if(_stack.laenge(_stack) != 0) {
            _stack.delete(_stack, 1);
        }
    }

    @Override
    public int top(AdtStack stack)
    {
        if(!_stack.isEmpty(_stack)) {
            return _stack.retrieve(_stack, 1);
        }
        return _stack.retrieve(_stack, 0);
    }

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
