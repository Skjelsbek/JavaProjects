package kø.med.linked.list;

public class Kø {
    private LinkedList first;
    private LinkedList last;
    private int size = 0;
    
    void enQueue(int tall) {
        if (size == 0) {
            last = new LinkedList(tall);
            first = last;
        }
        else{
            last.createObject(tall);
            last = last.getObject();
        }
        size++;
    }
    
    int deQueue() {
        int i = first.getTall();
        first = first.getObject();
        size--;
        return i;        
    }
}
