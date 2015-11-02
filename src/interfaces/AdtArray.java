package interfaces;

public interface AdtArray
{
    public static AdtArray initA() {
        return null;
    }
    
    public void setA(AdtArray array, int pos, int elem);
    
    public int getA(AdtArray array, int pos);
    
    public int lengthA(AdtArray array);
}
