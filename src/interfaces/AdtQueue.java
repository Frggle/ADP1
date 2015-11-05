package interfaces;

public interface AdtQueue
{

    public static AdtQueue createQ() {
        return null;
    }
    
    public void enqueue(int elem);
    
    public void dequeue();
    
    public int front();
    
    public boolean isEmptyQ();
}
