package shell.merge.quick.sort;

public class ShellSort {
    int counter = 0;
    public void sort(Comparable[] arr) {
        int gap = arr.length / 2;        
        Comparable tmp;
        boolean sorted = false;        
        while (!sorted) {            
            if (gap > 1) {                 
                for (int i = 0; i < arr.length - gap; i++) {
                    int j = i + gap;
                    if (arr[j].compareTo(arr[i]) == -1) {
                        tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;                                                
                    }                    
                }
                gap /= 2;                
            } else {                      
                for (int i = 1; i < arr.length; i++) {
                    int j = i - 1;
                    while (j >= 0 && arr[j].compareTo(arr[j + 1]) == 1) {
                        tmp = arr[j];                        
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        j--;
                    }
                }
                sorted = true;                
            }
        }
    }       
}
