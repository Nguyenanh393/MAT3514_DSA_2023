package Hw3_21000663_NguyenNgocAnh.Exercise01;


public class Test {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(0.1f, 0.2f);
        Fraction f2 = new Fraction(0.2f, 0.3f);
        Fraction f3 = new Fraction(0.3f, 0.4f);
        Fraction f4 = new Fraction(0.4f, 0.5f);
        Fraction f5 = new Fraction(0.5f, 0.6f);
        
        Fraction[] fractions = {f1, f2, f3, f4, f5};
        
        // sum all fractions
        Fraction sum = new Fraction(0, 1);
        for (int i = 0; i < fractions.length; i++) {
            sum = sum.add(fractions[i]);
        }
        System.out.println("Sum = " + sum);

        // subtract all the fractions from the first fraction
        Fraction minus = f1;
        for (int i = 1; i < fractions.length; i++) {
            minus = minus.minus(fractions[i]);
        }
        System.out.println("Minus = " + minus);
        
        // multiply all fractions
        Fraction multiply = new Fraction(1, 1);
        for (int i = 0; i < fractions.length; i++) {
            multiply = multiply.multi(fractions[i]);
        }
        System.out.println("Multiply = " + multiply);

        // (*) Tự đề xuất ít nhất một yêu cầu sử dụng kiểu phân số đã tạo ở 
        // trên, viết hàm thực hiện yêu cầu đó.
        // irreducible fraction
        Fraction irre = new Fraction(0.145f, 0.25f);
        Fraction irr = irre.irreducible(irre.getNumerator(), irre.getDenominator());
        System.out.println("Irreducible fraction = " + irr);

        // result:
        // Sum = 1859735.0/523869.0
        // Minus = -1.3358659E7/5238690.0
        // Multiply = 1.0/6.0
        // Irreducible fraction = 29.0/50.0
    }
}
