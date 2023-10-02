public class Assignment02 {
    public static void main(String[] args) {
        Integer t1 = 35;
        Integer t2 = 12;
        Integer t3 = 46;
        Integer[] t = {t1, t2, t3};
        SortTAlgorithm.quickSort(t, 3);
        for (int i = 0; i < 3; ++i) {
            System.out.print(t[i] + " ");
        }
    }
}
