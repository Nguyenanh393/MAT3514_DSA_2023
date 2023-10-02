import java.util.Arrays;
import java.util.Scanner;

// Bai tap 41: https://codelearn.io/learning/cau-truc-du-lieu-va-giai-thuat/848788
public class Task41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrA = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        Arrays.sort(arrA);

        for (int i = 0; i < n; i++) {
            System.out.print(arrA[i] + " ");
        }

        sc.close();
    }
}
