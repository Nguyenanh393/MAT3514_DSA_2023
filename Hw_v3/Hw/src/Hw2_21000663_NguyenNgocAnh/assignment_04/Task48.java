package Hw2_21000663_NguyenNgocAnh.assignment_04;

// Bai tap 48 https://codelearn.io/learning/cau-truc-du-lieu-va-giai-thuat/989229

import java.util.*;

public class Task48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();

        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (Map.Entry<Long, Integer> element : map.entrySet()) {
            System.out.print(element.getKey() + " " + element.getValue() + "; ");
        }

        sc.close();
    }
}
