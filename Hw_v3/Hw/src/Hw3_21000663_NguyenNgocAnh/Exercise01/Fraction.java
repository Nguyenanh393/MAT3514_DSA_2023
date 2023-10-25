package Hw3_21000663_NguyenNgocAnh.Exercise01;

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

    public Fraction add(Fraction other) {
        // add the given fraction to this fraction and return the result
        float num = this.numerator * other.denominator + other.numerator * this.denominator;
        float den = this.denominator * other.denominator;

        return irreducible(num, den);
    }
    public Fraction irreducible(float num, float den) {
        // irreducible fraction
        // count the number of digits after the decimal point
        float numCopy = num;
        float denCopy = den;

        // convert float to string
        String strNum = Float.toString(numCopy);
        String strDen = Float.toString(denCopy);

        // get the number of digits after the decimal point
        int numDec = strNum.length() - strNum.indexOf(".") - 1;
        int denDec = strDen.length() - strDen.indexOf(".") - 1;

        // get the maximum number of digits after the decimal point
        int dec = Math.max(numDec, denDec);

        // multiply the numerator and denominator by 10^dec
        numCopy = numCopy * (float) Math.pow(10, dec);
        denCopy = denCopy * (float) Math.pow(10, dec);

        // find the greatest common divisor
        // use long to avoid overflow
        long gcd = gcd((long) numCopy, (long) denCopy);

        // divide the numerator and denominator by the greatest common divisor
        long numLong = (long) numCopy / gcd;
        long denLong = (long) denCopy / gcd;

        // convert long to float
        float numNew = (float) numLong;
        float denNew = (float) denLong;

        if(numNew * denNew < 0) {
            numNew = -Math.abs(numNew);
            denNew = Math.abs(denNew);
        }
        // return the irreducible fraction
        return new Fraction(numNew, denNew);
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

