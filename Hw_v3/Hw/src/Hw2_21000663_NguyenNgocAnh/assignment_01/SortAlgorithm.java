package Hw2_21000663_NguyenNgocAnh.assignment_01;

public class SortAlgorithm {

    public static void bubbleSort(Integer[] array, Integer N) {
        Integer[] arr = array.clone();
        for (int i = 0; i < N; ++i) {
            boolean is_sorted = true;
            for (int j = 1; j < N - i; ++j) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    is_sorted = false;
                }
            }
            if (is_sorted) {
                return;
            }
        }
    }

    public static void selectionSort(Integer[] array, Integer N) {

        Integer[] arr = array.clone();
        for (int i = N - 1; i >= 1; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j) {;
                if (arr[j] >= arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(Integer[] array, Integer N) {

        Integer[] arr = array.clone();

        for (int i = 0; i < N; ++i) {
            int next = arr[i];
            int j;

            for (j = i - 1; j >= 0 && arr[j] > next; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = next;
        }
    }

    public static void quickSortAlgo(Integer[] array, Integer low, Integer high) {    
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSortAlgo(array, low, pivotIdx - 1);
            quickSortAlgo(array, pivotIdx + 1, high);
        }
    }

    private static int partition(Integer[] array, Integer low, Integer high) {
        int p = array[low];
        int m = low;

        for (int k = low + 1; k <= high; ++k) {
            if (array[k] < p) {
                ++m;
                int temp = array[k];
                array[k] = array[m];
                array[m] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[m];
        array[m] = temp;
        
        return m;
    }

    public static void quickSort(Integer[] array, int N) {
        Integer[] arr = array.clone();
        quickSortAlgo(arr, 0, N - 1);
    }

    public static void mergeSortAlgo(Integer[] array, Integer low, Integer high) {

        if (low < high) {
            int mid = (low + high) / 2;

            mergeSortAlgo(array, low, mid);
            mergeSortAlgo(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    private static void merge(Integer[] array, Integer low, Integer mid, Integer high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        Integer[] temp = new Integer[array.length];

        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
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
        Integer[] arr = array.clone();
        mergeSortAlgo(arr, 0, N - 1);
    }
}
