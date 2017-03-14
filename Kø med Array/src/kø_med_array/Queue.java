package kø_med_array;

public class Queue {
    int[] arr = new int[10];
    int first = -1;
    int last = -1;
    int size = 0;    
    
    public void enQueue(int num) {
        if (size == arr.length) {
            resize();
        }
        
        arr[(last+1)%arr.length] = num;
        if (size == 0) {
            first = 0;
        }
        last = (last+1)%arr.length;
        size++;        
    }
    
    public int deQueue() {        
        int i = arr[first];        
        size--;
        first++;
        return i;
    }

    public void resize() {
        int[] arrCopy = new int[arr.length*2];
        System.out.println("Nå kopierer jeg altså");
        if (last < first) {
            System.arraycopy(arr, first, arrCopy, 0, arr.length - first);
            System.arraycopy(arr, 0, arrCopy, arr.length - first, first);
        } else {
            System.arraycopy(arr, 0, arrCopy, 0, size);            
        }
        first = 0;
        last = arr.length - 1;
        arr = arrCopy;
    }    
}
