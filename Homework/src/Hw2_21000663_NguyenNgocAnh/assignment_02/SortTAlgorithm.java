public class SortTAlgorithm {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr, Integer N) {
        for (int i = 0; i < N; ++i) {
            boolean is_sorted = true;
            for (int j = 1; j < N - i; ++j) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    T temp = arr[j - 1];
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

    public static <T extends Comparable<T>> void selectionSort(T[] arr, Integer N) {
        for (int i = N - 1; i >= 1; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j) {
                if (arr[j].compareTo(arr[maxIdx]) >= 0) {
                    maxIdx = j;
                }
            }
            T temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, Integer N) {

        for (int i = 0; i < N; ++i) {
            T next = arr[i];
            int j;

            for (j = i - 1; j >= 0 && arr[j].compareTo(next) > 0; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = next;
        }
    }

    public static <T extends Comparable<T>> void quickSortAlgo(T[] array, Integer low, Integer high) {    
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(array, low, high);

            quickSortAlgo(array, low, pivotIdx - 1);
            quickSortAlgo(array, pivotIdx + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, Integer low, Integer high) {
        T p = array[low];
        int m = low;

        for (int k = low + 1; k <= high; ++k) {
            if (array[k].compareTo(p) < 0) {
                ++m;
                T temp = array[k];
                array[k] = array[m];
                array[m] = temp;
            }
        }
        T temp = array[low];
        array[low] = array[m];
        array[m] = temp;
        
        return m;
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int N) {
        quickSortAlgo(arr, 0, N - 1);
    }

    public static <T extends Comparable<T>> void mergeSortAlgo(T[] array, Integer low, Integer high) {

        if (low < high) {
            int mid = (low + high) / 2;

            mergeSortAlgo(array, low, mid);
            mergeSortAlgo(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, Integer low, Integer mid, Integer high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        T[] temp = (T[]) new Comparable[array.length];

        while (i <= mid && j <= high) {
            if (array[i].compareTo(array[j]) <= 0) {
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
    public static <T extends Comparable<T>> void mergeSort(T[] arr, Integer N) {
        mergeSortAlgo(arr, 0, N - 1);
    }
}
