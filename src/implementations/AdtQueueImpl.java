package implementations;

import interfaces.AdtQueue;
import interfaces.AdtStack;

public class AdtQueueImpl implements AdtQueue
{

    /**
     * Interne Architektur wird mit 2 Stacks repraesentiert
     */
    private AdtStack _queueIn;
    private AdtStack _queueOut;

    /**
     * privater Konstruktor
     */
    private AdtQueueImpl() {
        _queueIn = AdtStackImpl.createS();
        _queueOut = AdtStackImpl.createS();
    }
    
    /**
     * Initialisiert das Objekt
     * 
     * @return AdtQueue
     */
    public static AdtQueue createQ() {
        return new AdtQueueImpl();
    }
    
    /**
     * Fuegt das Element der Queue hinzu -> nach dem FIFO Prinzip
     * 
     * @param int elem
     */
    @Override
    public void enqueue(int elem)
    {
        _queueIn.push(elem);
    }

    /**
     * Entfernt das aelteste Element, ohne es zurueckzugeben
     * 
     */
    @Override
    public void dequeue()
    {
        if(!(_queueIn.isEmptyS() && _queueOut.isEmptyS())) {
           
            if(_queueOut.isEmptyS()) {
                // Umschachteln, von In nach Out -> unterstes In danach oberste Out
                while(!_queueIn.isEmptyS()) {
                    int elem = _queueIn.top();  // holt das unterste Element (ohne es zu entfernen)
                    _queueIn.pop();             // entfernt anschlieﬂend das Element
                    _queueOut.push(elem);       // fuegt es der QueueOut hinzu
                }                
            }
           _queueOut.pop();
        }
    }

    /**
     * Liefert das aelteste Element, ohne es zu entfernen
     * Wenn die Queue leer ist, wird -99999999 als Fehler zurueckgegeben
     * 
     * @return int, das Element
     */
    @Override
    public int front()
    {
        if(!(_queueIn.isEmptyS() && _queueOut.isEmptyS())) {
            
            if(_queueOut.isEmptyS()) {
                // Umschachteln, von In nach Out -> unterstes In danach oberste Out
                while(!_queueIn.isEmptyS()) {
                    int elem = _queueIn.top();  // holt das unterste Element (ohne es zu entfernen)
                    _queueIn.pop();             // entfernt anschlieﬂend das Element
                    _queueOut.push(elem);    // fuegt es der QueueOut hinzu
                }    
            }
           return _queueOut.top();
        }
        return -99999999;
    }

    /**
     * Prueft ob die Queue leer ist
     * 
     * @return boolean, ob Queue leer
     */
    @Override
    public boolean isEmptyQ()
    {
       return _queueIn.isEmptyS() && _queueOut.isEmptyS();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((_queueIn == null) ? 0 : _queueIn.hashCode());
        result = prime * result
                + ((_queueOut == null) ? 0 : _queueOut.hashCode());
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
        AdtQueueImpl other = (AdtQueueImpl) obj;
        if (_queueIn == null)
        {
            if (other._queueIn != null)
                return false;
        } else if (!_queueIn.equals(other._queueIn))
            return false;
        if (_queueOut == null)
        {
            if (other._queueOut != null)
                return false;
        } else if (!_queueOut.equals(other._queueOut))
            return false;
        return true;
    }
}
