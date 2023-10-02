import java.util.*;

public class Assignment06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        
        System.out.print(a[k-1] + " ");
        
        sc.close();
    }
}