package hw7_21000663_NguyenNgocAnh.pr01;

// https://practice.geeksforgeeks.org/problems/inorder-traversal-and-bst5855/1
// Đã submit
class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return 0;
            }
        }
        return 1;
    }
}
