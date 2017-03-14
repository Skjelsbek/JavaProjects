package insertion.sort;

public class Sort {
    
    public void insertionSort (Comparable[] arr) {
        Comparable temp;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j + 1].compareTo(arr[j]) == -1) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }
    
    public void selectionSort(Comparable[] arr) {
        int index;
        Comparable temp;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i; j < arr.length; j++){                
                if (arr[j].compareTo(arr[index]) == -1) {                    
                    index = j;
                }
            }
            if (index != i) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i]= temp;
            }
        }
    }
}
