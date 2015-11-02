package interfaces;

public interface AdtStack
{
    public static AdtStack createS()
    {
        return null;
    }
    
    public void push(AdtStack stack, int elem);
    
    public void pop(AdtStack stack);
    
    public int top(AdtStack stack);
    
    public boolean isEmptyS(AdtStack stack);
}
