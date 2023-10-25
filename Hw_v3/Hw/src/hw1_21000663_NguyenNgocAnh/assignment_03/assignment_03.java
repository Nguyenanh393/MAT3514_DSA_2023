package hw1_21000663_NguyenNgocAnh.assignment_03;

import java.util.Scanner;

public class assignment_03 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        System.out.println("Input complexNum1: ");
        System.out.println("real: ");
        Integer real = sc.nextInt();
        System.out.println("imaginary: ");
        Integer imaginary = sc.nextInt();

        ComplexNumber complexNum1 = new ComplexNumber(real, imaginary);
        System.out.println("complexNum1: ");
        System.out.println(complexNum1.toString());

        System.out.println("Input complexNum2: real and imaginary");
        ComplexNumber complexNum2 = new ComplexNumber(sc.nextInt(), sc.nextInt());

        System.out.println("Sum of 2 number: ");
        ComplexNumber tolal_2 = complexNum1.add(complexNum2);
        System.out.println(tolal_2.toString());

        System.out.println("Input n (length of array): ");
        Integer n = sc.nextInt();
        ComplexNumber[] ComplexNumArray = new ComplexNumber[n];
        System.out.println("Input array of complex Numbers with real, imaginary: ");
        for(int i = 0; i < n; i++) {
            ComplexNumArray[i] = new ComplexNumber(sc.nextInt(), sc.nextInt());
        }

        System.out.println("Sum of array: ");
        System.out.println(ComplexNumber.adds(n, ComplexNumArray));

        System.out.println("Multiply of array: ");
        System.out.println(ComplexNumber.muls(n, ComplexNumArray));
        sc.close();
    }
}
