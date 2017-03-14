package kø.med.generics;

public class Kø <item> {
    private LinkedList first;
    private LinkedList last;
    private int size = 0;
    
    void enQueue(item value) {
        if (size == 0) {
            last = new LinkedList(value);
            first = last;
        }
        else{
            last.createObject(value);
            last = last.getObject();
        }
        size++;
    }
    
    item deQueue() {
        item i = (item)first.getValue();
        first = first.getObject();
        size--;
        return i;        
    }
}
