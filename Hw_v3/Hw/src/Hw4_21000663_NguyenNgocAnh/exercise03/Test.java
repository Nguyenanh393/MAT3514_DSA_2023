package Hw4_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        StackCalculate stackCalculate = new StackCalculate();

        // Test case
        String s = "(10 + 8) / ((5 - 2) * 17)";
        String s1 = "(1 + ((2 + 3) * (8 * 5)))";
        String s2 = "(5 - (8 - 4) * (2 + 3)) + (8/4)";
        String s3 = "(10 - 8/((2 + 5) - 17)";

        Stack<String> stack, st = new Stack<>();
        stack = stackCalculate.inputStack(s);
        st = stackCalculate.inputStack(s1);

        System.out.println("______________________");
        System.out.println(stack);
        stackCalculate.calculate(stack);
        stackCalculate.calculate(st);
        stackCalculate.calculate(stackCalculate.inputStack(s2));
        stackCalculate.calculate(stackCalculate.inputStack(s3));
    }
}
// [(, 10, +, 8, ), /, (, (, 5, -, 2, ), *, 17, )]
// 0.35294117647058826
// 201.0
// -13.0
// Invalid expression
