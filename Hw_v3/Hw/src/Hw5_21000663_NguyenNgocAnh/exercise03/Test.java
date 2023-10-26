package Hw5_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str = "(6/2 + 3) * (7 - 4)";
        System.out.println(StringToTree.convertStringToStack(str));
        

        Stack<String> st = StringToTree.convertStringToStack(str);

        System.out.println(st.get(0));

        Stack<String> st2 = StringToTree.infixToPostfix(st);

        System.out.println(st2);
    }
}
