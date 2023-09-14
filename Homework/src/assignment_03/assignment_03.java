package assignment_03;

import java.util.Scanner;

public class assignment_03 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        Integer real = sc.nextInt();
        Integer imaginary = sc.nextInt();

        ComplexNumber complexNum1 = new ComplexNumber(real, imaginary);
        System.out.println(complexNum1.toString());

        ComplexNumber complexNum2 = new ComplexNumber(sc.nextInt(), sc.nextInt());
        ComplexNumber tolal_2 = complexNum1.add(complexNum2);
        System.out.println(tolal_2.toString());

        Integer n = sc.nextInt();
        ComplexNumber[] ComplexNumArray = new ComplexNumber[n];
        for(int i = 0; i < n; i++) {
            ComplexNumArray[i] = new ComplexNumber(sc.nextInt(), sc.nextInt());
        }
        System.out.println(ComplexNumber.adds(n, ComplexNumArray));
        System.out.println(ComplexNumber.muls(n, ComplexNumArray));
        sc.close();
    }
}
//javac assignment_03/ComplexNumber.java assignment_03/assignment_03.java
//java assignment_03.assignment_03