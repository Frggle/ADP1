package implementations;

import interfaces.AdtQueue;
import interfaces.AdtStack;

public class AdtQueueImpl implements AdtQueue
{

    private AdtStack _queueIn;
    private AdtStack _queueOut;

    
    private AdtQueueImpl() {
        _queueIn = AdtStackImpl.createS();
        _queueOut = AdtStackImpl.createS();
    }
    
    public static AdtQueue createQ() {
        return new AdtQueueImpl();
    }
    
    @Override
    public void enqueue(AdtQueue queue, int elem)
    {
        _queueIn.push(_queueIn, elem);
    }

    @Override
    public void dequeue(AdtQueue queue)
    {
        if(!(_queueIn.isEmptyS(_queueIn) && _queueOut.isEmptyS(_queueOut))) {
           
            if(_queueOut.isEmptyS(_queueOut)) {
                // Umschachteln, von In nach Out -> unterstes In danach oberste Out
                while(!_queueIn.isEmptyS(_queueIn)) {
                    int elem = _queueIn.top(_queueIn);  // holt das unterste Element (ohne es zu entfernen)
                    _queueIn.pop(_queueIn);             // entfernt anschlieﬂend das Element
                    _queueOut.push(_queueOut, elem);    // fuegt es der QueueOut hinzu
                }                
            }
           _queueOut.pop(_queueOut);
        }
    }

    @Override
    public int front(AdtQueue queue)
    {
        if(!(_queueIn.isEmptyS(_queueIn) && _queueOut.isEmptyS(_queueOut))) {
            
            if(_queueOut.isEmptyS(_queueOut)) {
                // Umschachteln, von In nach Out -> unterstes In danach oberste Out
                while(!_queueIn.isEmptyS(_queueIn)) {
                    int elem = _queueIn.top(_queueIn);  // holt das unterste Element (ohne es zu entfernen)
                    _queueIn.pop(_queueIn);             // entfernt anschlieﬂend das Element
                    _queueOut.push(_queueOut, elem);    // fuegt es der QueueOut hinzu
                }    
            }
           return _queueOut.top(_queueOut);
        }
        return -99999999;
    }

    @Override
    public boolean isEmptyQ(AdtQueue queue)
    {
       return _queueIn.isEmptyS(_queueIn) && _queueOut.isEmptyS(_queueOut);
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
