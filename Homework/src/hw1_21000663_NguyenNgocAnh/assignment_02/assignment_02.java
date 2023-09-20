package hw1_21000663_NguyenNgocAnh.assignment_02;

import java.util.ArrayList;
import java.util.Scanner;

public class assignment_02 {
        // check prime
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n < 4) 
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        
        int sqrt = (int) Math.sqrt(n);

        for (int i = 5; i <= sqrt; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
    
    // main
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        System.out.println("Input n: ");
        Integer n = sc.nextInt();
        System.out.println("Input array:");
        Integer[] array = new Integer[n];

        // input array
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // create new prime vector then put prime into it
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (Integer it : array) {
            if(isPrime(it)) {
                primes.add(it);
            }
        }

        // print prime 
        System.out.println("Output prime array: ");
        for (Integer it : primes) {
            System.out.print(it + " ");
        }

        // close Scanner
        sc.close();
    }
}
