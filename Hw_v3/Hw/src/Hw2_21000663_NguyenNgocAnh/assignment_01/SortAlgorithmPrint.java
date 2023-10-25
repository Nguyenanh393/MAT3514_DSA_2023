package Hw2_21000663_NguyenNgocAnh.assignment_01;

import java.util.*;

public class SortAlgorithmPrint {

    public static void bubbleSort(Integer[] array, Integer N) {
        Integer[] arr = array.clone();
        Integer[] arr1 = array.clone();
        Integer count_1 = 0; // số lần so sánh
        Integer count_2 = 0; // số lần đổi chỗ
        System.out.println("==========================================");
        System.out.println("Bubble Sort");
        for (int i = 0; i < N; ++i) {
            boolean is_sorted = true;
            for (int j = 1; j < N - i; ++j) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    is_sorted = false;
                }
                count_1++;
                if (arr != arr1) {
                    count_2++;
                }
                arr1 = arr.clone();
                System.out.println(Arrays.toString(arr));
            }
            if (is_sorted) {
                System.out.println("So lan so sanh: " + count_1);
                System.out.println("So lan doi cho: " + count_2);
                return;
            }
        }
    }

    public static void selectionSort(Integer[] array, Integer N) {

        Integer[] arr = array.clone();
        //Integer[] arr1 = array.clone();
        Integer count_1 = 0; // số lần so sánh
        Integer count_2 = 0; // số lần đổi chỗ
        System.out.println("==========================================");
        System.out.println("Selection Sort");
        for (int i = N - 1; i >= 1; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j) {
                count_1++;
                if (arr[j] >= arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            count_2++;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("So lan so sanh: " + count_1);
        System.out.println("So lan doi cho: " + count_2);
    }

    public static void insertionSort(Integer[] array, Integer N) {

        Integer[] arr = array.clone();
        Integer count_1 = 0; // số lần so sánh
        Integer count_2 = 0; // số lần đổi chỗ

        System.out.println("==========================================");
        System.out.println("Insertion Sort");

        for (int i = 0; i < N; ++i) {
            int next = arr[i];
            int j;

            for (j = i - 1; j >= 0 && arr[j] > next; --j) {
                arr[j + 1] = arr[j];
                count_1++;
                count_2++;
            }

            arr[j + 1] = next;
            count_2++;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("So lan so sanh: " + count_1);
        System.out.println("So lan doi cho: " + count_2);
    }

    public static void quickSortAlgo(Integer[] array, Integer low, Integer high, Integer[] count) {    
        int pivotIdx;

        System.out.println(Arrays.toString(array));

        if (low < high) {
            pivotIdx = partition(array, low, high, count);

            quickSortAlgo(array, low, pivotIdx - 1, count);
            quickSortAlgo(array, pivotIdx + 1, high, count);
        }
    }

    private static int partition(Integer[] array, Integer low, Integer high, Integer[] count) {
        int p = array[low];
        int m = low;

        for (int k = low + 1; k <= high; ++k) {
            count[0]++;
            if (array[k] < p) {
                ++m;
                int temp = array[k];
                array[k] = array[m];
                array[m] = temp;
                count[1]++;
            }
        }
        int temp = array[low];
        array[low] = array[m];
        array[m] = temp;
        count[1]++;
        
        return m;
    }

    public static void quickSort(Integer[] array, int N) {
        Integer[] count = {0, 0}; // số lần so sánh, đổi chỗ
        Integer[] arr = array.clone();
        System.out.println("==========================================");
        System.out.println("Quick Sort");
        quickSortAlgo(arr, 0, N - 1, count);
        System.out.println("So lan so sanh: " + count[0]);
        System.out.println("So lan doi cho: " + count[1]);
    }

    public static void mergeSortAlgo(Integer[] array, Integer low, Integer high, Integer[] count) {
        System.out.println(Arrays.toString(array));

        if (low < high) {
            int mid = (low + high) / 2;

            mergeSortAlgo(array, low, mid, count);
            mergeSortAlgo(array, mid + 1, high, count);

            merge(array, low, mid, high, count);
        }
    }

    private static void merge(Integer[] array, Integer low, Integer mid, Integer high, Integer[] count) {
        int i = low;
        int j = mid + 1;
        int k = low;

        Integer[] temp = new Integer[array.length];

        while (i <= mid && j <= high) {
            count[0]++;
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count[1]++;
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (int m = low; m <= high; ++m) {
            array[m] = temp[m];
        }
    }

    // merge sort
    public static void mergeSort(Integer[] array, Integer N) {
        Integer[] count = {0, 0}; // số lần so sánh, đổi chỗ
        Integer[] arr = array.clone();
        System.out.println("==========================================");
        System.out.println("Merge Sort");
        mergeSortAlgo(arr, 0, N - 1, count);
        System.out.println(Arrays.toString(arr));
        System.out.println("So lan so sanh: " + count[0]);
        System.out.println("So lan doi cho: " + count[1]);
    }
}
