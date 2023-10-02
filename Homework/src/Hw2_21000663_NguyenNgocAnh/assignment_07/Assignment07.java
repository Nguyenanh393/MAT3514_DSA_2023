import java.util.*;

public class Assignment07 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            
            if (map.containsKey(x-num)) {
                count += map.get(x-num);
            }
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        System.out.println(count);
    }
}
