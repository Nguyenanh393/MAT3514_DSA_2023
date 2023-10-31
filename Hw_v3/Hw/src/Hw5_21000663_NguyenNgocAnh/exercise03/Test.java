package Hw5_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

import Hw5_21000663_NguyenNgocAnh.exercise02.ExpressionTree;

public class Test {
    public static void main(String[] args) {
        String str = " (6 / 2 + 3) * (7 - 4)";
        System.out.println(StringToTree.convertToStack(str));
        
        String[] str2 = {"(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")"};
        System.out.println(StringToTree.convertToStack(str2));

        StringToTree.Test(str);

        StringToTree.Test(str2);

        // [(, 6, /, 2, +, 3, ), *, (, 7, -, 4, )]
        // [(, 6, /, 2, +, 3, ), *, (, 7, -, 4, )]
        // The string ' (6 / 2 + 3) * (7 - 4)' is valid
        //                 4
        //         -
        //                 7
        // *
        //                 3
        //         +
        //                         2
        //                 /
        //                         6
        // 18
        // The array of token '*[(, 6, /, 2, +, 3, ), *, (, 7, -, 4, )]' is valid    
        //                 4
        //         -
        //                 7
        // *
        //                 3
        //         +
        //                         2
        //                 /
        //                         6
        // 18
    }
}
