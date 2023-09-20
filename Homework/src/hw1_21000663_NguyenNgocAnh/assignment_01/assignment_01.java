package hw1_21000663_NguyenNgocAnh.assignment_01;

import java.util.Scanner;

public class assignment_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input boolean value:");
        boolean boolVal = sc.nextBoolean();
        System.out.println("Value = " + boolVal);

        System.out.println("Input byte value:");
        byte byteVal = sc.nextByte();
        System.out.println("Value = " + byteVal);
        
        System.out.println("Input short value:");
        short shortVal = sc.nextShort();
        System.out.println("Value = " + shortVal);

        System.out.println("Input int value:");
        int intVal = sc.nextInt();
        System.out.println("Value = " + intVal);

        System.out.println("Input long value:");
        long longVal = sc.nextLong();
        System.out.println("Value = " + longVal);
        
        System.out.println("Input float value:");
        float floatVal = sc.nextFloat();
        System.out.println("Value = " + floatVal);
        
        System.out.println("Input double value:");
        double doubVal = sc.nextDouble();
        System.out.println("Value = " + doubVal);
        sc.close();
    }  
}
