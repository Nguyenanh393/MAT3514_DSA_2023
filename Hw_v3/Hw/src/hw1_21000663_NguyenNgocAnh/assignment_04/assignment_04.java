package hw1_21000663_NguyenNgocAnh.assignment_04;

import java.util.Scanner;

public class assignment_04 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.println("Input sphere1 by input x, y, z, r:");
        Sphere sphere1 = new Sphere(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("sphere1: " + sphere1.toString());
        System.out.println(String.format("Surrounding Area: %.3f", sphere1.SurroundArea()));
        System.out.println(String.format("Volume: %.3f", sphere1.Volume()));

        System.out.println("Input sphere2 by input x, y, z, r:");
        Sphere sphere2 = new Sphere(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("sphere2: " + sphere2.toString());
        System.out.println("Status: " + sphere1.DetermineStatus(sphere2));

        sc.close();
    }
}