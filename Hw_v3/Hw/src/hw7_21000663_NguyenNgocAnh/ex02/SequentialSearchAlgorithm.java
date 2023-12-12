package hw7_21000663_NguyenNgocAnh.ex02;

public class SequentialSearchAlgorithm {
    public int sequentialSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
