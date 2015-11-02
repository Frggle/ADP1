package implementations;

import interfaces.AdtQueue;
import interfaces.AdtStack;

public class AdtQueueImpl implements AdtQueue
{

    private AdtStack _queueIn;
    private AdtStack _queueOut;

    
    private AdtQueueImpl() {
        _queueIn = AdtStack.createS();
        _queueOut = AdtStack.createS();
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
                do{
                    int elem = _queueIn.top(_queueIn);
                    _queueOut.push(_queueOut, elem);
                } while(!_queueIn.isEmptyS(_queueIn));
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
                do{
                    int elem = _queueIn.top(_queueIn);
                    _queueOut.push(_queueOut, elem);
                } while(!_queueIn.isEmptyS(_queueIn));
            }
           return _queueOut.top(_queueOut);
        }
        return Integer.MIN_VALUE; // TODO ?
    }

    @Override
    public boolean isEmptyQ(AdtQueue queue)
    {
       return _queueIn.isEmptyS(_queueIn) && _queueOut.isEmptyS(_queueOut);
    }
}
