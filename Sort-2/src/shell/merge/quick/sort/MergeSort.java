package shell.merge.quick.sort;

public class MergeSort {
    private Comparable[] arr;
    private Comparable[] helpArr;
    private int length;
    
    public void sort(Comparable[] arr) {
        this.arr = arr;
        this.length = arr.length;
        this.helpArr = new Comparable[this.length];
        mergeSort(0, this.length - 1);
    }
    
    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }
    
    private void merge(int low, int middle, int high) {
        // low = 0
        // middle = 0
        // high = 1
        for (int i = low; i <= high; i++) {
            helpArr[i] = arr[i];
        }
        
        int i = low;
        int j = middle + 1;
        int k = low;
        
        while (i <= middle && j <= high) {
            if (helpArr[i].compareTo(helpArr[j]) == -1) {
                arr[k] = helpArr[i];
                i++;
            } else {
                arr[k] = helpArr[j];
                j++;
            }
            k++;
        }
        
        while (i <= middle) {
            arr[k] = helpArr[i];
            i++;
            k++;
        }
    }
}
