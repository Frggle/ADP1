package interfaces;

public interface AdtStack
{
    public static AdtStack createS()
    {
        return null;
    }
    
    public void push(int elem);
    
    public void pop();
    
    public int top();
    
    public boolean isEmptyS();
}
