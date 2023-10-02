import java.util.*;

public class Assignment01d {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = sc.nextInt();
        System.out.println("Input array:");
        Integer[] array = new Integer[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(array));

        SortAlgorithmPrint.bubbleSort(array, n);
        SortAlgorithmPrint.selectionSort(array, n);
        SortAlgorithmPrint.insertionSort(array, n);
        SortAlgorithmPrint.quickSort(array, n);
        SortAlgorithmPrint.mergeSort(array, n);
        sc.close();
    }

}
