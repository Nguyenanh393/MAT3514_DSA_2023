package hw7_21000663_NguyenNgocAnh.ex02;

public class BinarySearchAlgorithm {
    public int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else if (x > arr[mid]) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}
