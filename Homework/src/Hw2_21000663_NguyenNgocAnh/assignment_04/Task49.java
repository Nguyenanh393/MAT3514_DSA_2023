//Bai tap 49 https://codelearn.io/learning/cau-truc-du-lieu-va-giai-thuat/859980

import java.util.*;

public class Task49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(a);

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] > k) {
                count++;
            }
        }
        count++;
        System.out.println(count);

        sc.close();
    }
}
