package interfaces;

public interface AdtQueue
{

    public static AdtQueue createQ() {
        return null;
    }
    
    public void enqueue(AdtQueue queue, int elem);
    
    public void dequeue(AdtQueue queue);
    
    public int front(AdtQueue queue);
    
    public boolean isEmptyQ(AdtQueue queue);
}
