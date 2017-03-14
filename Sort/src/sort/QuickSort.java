package sort;

public class QuickSort {
    Comparable[] arr;
    Comparable[] arrCopy;
    
    public void sort (Comparable[] arr) {
        this.arr = arr;        
        quickSort(0, arr.length);
    }    
    
    private void quickSort(int start, int end) {
        if (end - start < 1) return;
        Comparable pivot = arr[end - 1];
        int index = start;
        int wall = start;
        
        while (index < end - 1) {
            if (arr[index].compareTo(pivot) <= 0) {
                if (wall < index) {
                    swap(wall, index);
                }
                wall++;
            }
            index++;            
        }
        swap(end - 1, wall);
        
        quickSort(start, wall);
        quickSort(wall + 1, end);                
    }
    
    private void swap(int index1, int index2) {
        Comparable help;
        help = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = help;
    }
}
