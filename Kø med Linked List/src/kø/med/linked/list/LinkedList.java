package kø.med.linked.list;

public class LinkedList {
    private int tall = 0;
    private LinkedList next;
    
    public LinkedList(int i) {
        tall = i;
        next = null;
    }
    
    public void createObject(int i) {
        next = new LinkedList(i);
    }
    
    public LinkedList getObject(){
        return next;
    }
    
    public int getTall() {
        return tall;
    }
    
}
