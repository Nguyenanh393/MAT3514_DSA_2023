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
        String s = "Hello";
        System.out.println(hashCode(s)); // 78921199
    }
}
