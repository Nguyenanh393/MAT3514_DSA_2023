package Hw5_21000663_NguyenNgocAnh.practice21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MakeBinaryTreeFromLinkedList {
    class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }
        
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    
    class GfG 
    {
        public static Tree convert(Node head, Tree node) {
            if (head == null) {
                return null;
            }

            Queue<MakeBinaryTreeFromLinkedList.Tree> q = new LinkedList<>();
            MakeBinaryTreeFromLinkedList.Tree root = new MakeBinaryTreeFromLinkedList().new Tree(head.data);
            // remove MakeBinaryTreeFromLinkedList when submit on GFG
            q.add(root);
            head = head.next;

            while (head != null) {
                Tree parent = q.poll();

                Tree left = new MakeBinaryTreeFromLinkedList().new Tree(head.data); 
                // remove MakeBinaryTreeFromLinkedList when submit on GFG
                q.add(left);
                head = head.next;

                Tree right = null;
                if (head != null) {
                    right = new MakeBinaryTreeFromLinkedList().new Tree(head.data);
                    // remove MakeBinaryTreeFromLinkedList when submit on GFG
                    q.add(right);
                    head = head.next;
                }
                parent.left = left;
                parent.right = right;
            }
        return node;
        }
    }  
}
