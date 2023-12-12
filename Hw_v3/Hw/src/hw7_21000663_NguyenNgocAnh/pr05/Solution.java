package hw7_21000663_NguyenNgocAnh.pr05;

// đã submit

class Solution {
    
    class Node {
        int data;
        Node left, right;
        Node(int x) {
            data = x;
            left = right = null;
        }
    }
    public int KthSmallestElement(Node root, int K) {
        int count = 0;
        
        Node curr = root;
        Node Ksmall = null;

        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == K) {
                    Ksmall = curr;
                }
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    if (count == K) {
                        Ksmall = curr;
                    }
                    curr = curr.right;
                }
            }
        }
        if (Ksmall != null) {
            return Ksmall.data;
        }
        return -1;
    }
}
