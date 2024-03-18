package dsa_end.hashcode;

public class HashcodeCyclesShifting {

    // triển khai mã băm chu kỳ với String
    static int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >>> 27); 
            h += (int) s.charAt(i);     
        }
        return h;
    }
    public static void main(String[] args) {
        String s1 = "IEllo! Whut's ap?";
        String s2 = "HeloedddddddeqP! Whut's ap?";

        System.out.println(hashCode(s1));
        System.out.println(hashCode(s2)); 
        System.out.println(hashCode(s1) == hashCode(s2));
        System.out.println(s1 == s2);
    }
}
// without >>> 27:
// "IEllo! Whut's ap?" = 1430360639
// "IEllP! Whut's ap?" = 1430360639
// "HeloeeqP! Whut's ap?" = 1430360639
/*
h = (h << 5);
1430360639
1430360639
true
false

h = (h << 5) | (h >>> 27); 
1452810723
314976204
false
false
 */