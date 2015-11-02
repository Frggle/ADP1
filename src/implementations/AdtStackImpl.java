package implementations;

import interfaces.AdtList;
import interfaces.AdtStack;

public class AdtStackImpl implements AdtStack
{
    private AdtList _stack;
    
    private AdtStackImpl()
    {
        _stack = AdtList.create();
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

}
