package kø.med.generics;

public class LinkedList <item>{
    private item value;
    private LinkedList next;
    
    public LinkedList(item i) {
        value = i;
        next = null;
    }
    
    public void createObject(item i) {
        next = new LinkedList(i);
    }
    
    public LinkedList getObject(){
        return next;
    }
    
    public item getValue() {
        return value;
    }
    
}
