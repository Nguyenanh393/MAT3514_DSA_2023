package assignment_04;

import java.util.Scanner;

public class assignment_04 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.println("Input sphere1 by input x, y, z, r:");
        Sphere sphere1 = new Sphere(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Surrounding Area: " + sphere1.SurroundArea());
        System.out.println("Volume: " + sphere1.Volume());

        System.out.println("Input sphere2 by input x, y, z, r:");
        Sphere sphere2 = new Sphere(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Status: " + sphere1.DetermineStatus(sphere2));

        sc.close();
    }
}
//javac assignment_04/Sphere.java assignment_04/assignment_04.java