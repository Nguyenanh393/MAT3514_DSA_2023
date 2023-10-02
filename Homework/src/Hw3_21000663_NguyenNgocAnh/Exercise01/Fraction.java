public class Fraction {
    private float numerator;
    private float denominator;
    
    public Fraction(float numerator, float denominator) {
        // create a new fraction with the given numerator and denominator
        if (denominator == 0) { // check if the denominator = 0
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        // add the given fraction to this fraction and return the result
        float num = this.numerator * c.denominator + c.numerator * this.denominator;
        float den = this.denominator * c.denominator;

        return irreducible(num, den);
    }
    public Fraction irreducible(float num, float den) {
        // irreducible fraction
        // count the number of digits after the decimal point
        float num_copy = num;
        float den_copy = den;

        // convert float to string
        String str_num = Float.toString(num_copy);
        String str_den = Float.toString(den_copy);

        // get the number of digits after the decimal point
        int num_dec = str_num.length() - str_num.indexOf(".") - 1;
        int den_dec = str_den.length() - str_den.indexOf(".") - 1;

        // get the maximum number of digits after the decimal point
        int dec = Math.max(num_dec, den_dec);

        // multiply the numerator and denominator by 10^dec
        num_copy = num_copy * (float) Math.pow(10, dec);
        den_copy = den_copy * (float) Math.pow(10, dec);

        // find the greatest common divisor
        // use long to avoid overflow
        long gcd = (long) gcd((long) num_copy, (long) den_copy);

        // divide the numerator and denominator by the greatest common divisor
        long num_long = (long) num_copy / gcd;
        long den_long = (long) den_copy / gcd;

        // convert long to float
        float num_new = (float) num_long;
        float den_new = (float) den_long;

        if(num_new * den_new < 0) {
            num_new = -Math.abs(num_new);
            den_new = Math.abs(den_new);
        }
        // return the irreducible fraction
        return new Fraction(num_new, den_new);
    }

    private long gcd(long num, long den) {
        if (den == 0) { // check if the denominator = 0
            return num;
        }
        // find the greatest common divisor
        return gcd(den, num % den);
    }

    public Fraction minus(Fraction c) {
        // subtract the given fraction from this fraction and return the result
        float num = this.numerator * c.denominator - c.numerator * this.denominator;
        float den = this.denominator * c.denominator;
        return irreducible(num, den);
    }

    public Fraction multi(Fraction c) {
        // multiply the given fraction by this fraction and return the result
        float num = this.numerator * c.numerator;
        float den = this.denominator * c.denominator;
        return irreducible(num, den);
    }

    public Fraction divi(Fraction c) {
        // divide this fraction by the given fraction and return the result
        float num = this.numerator * c.denominator;
        float den = this.denominator * c.numerator;
        return irreducible(num, den);
    }

    public float getNumerator() {
        // return the numerator
        return this.numerator;
    }

    public float getDenominator() {
        // return the denominator
        return this.denominator;
    }

    public String toString() {
        // return a string 
        if (this.denominator == 1) {
            return Float.toString(this.numerator);
        }
        return this.numerator + "/" + this.denominator;
    }
}

