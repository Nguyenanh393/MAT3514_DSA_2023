package assignment_03;

public class ComplexNumber {
    //create compkes number
    public Integer real;
    public Integer imaginary;

    public ComplexNumber(Integer real, Integer imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    //add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        Integer real = this.real + other.real;
        Integer imaginary = this.imaginary + other.imaginary;
        
        return new ComplexNumber(real, imaginary);
    }

    //multiply two complex numbers
    public ComplexNumber mul(ComplexNumber other) {
        Integer real = this.real * other.real - this.imaginary * other.imaginary;
        Integer imaginary = this.real * other.imaginary + this.imaginary * other.real;

        return new ComplexNumber(real, imaginary);
    }

    // add multiple numbers
    public static ComplexNumber adds(Integer n, ComplexNumber[] numArray) {
        ComplexNumber sum = new ComplexNumber(0, 0);
        for(int i = 0; i < n; i++) {
            sum = sum.add(numArray[i]);
        }
        return sum;
    }

    // multiply multible numbers
    public static ComplexNumber muls(Integer n, ComplexNumber[] numArray) {
        ComplexNumber res = new ComplexNumber(1, 1);
        for(int i = 0; i < n; i++) {
            res = res.add(numArray[i]);
        }
        return res;
    }

    // toString
    public String toString() {
        return String.format("%d + %di", this.real, this.imaginary);
    }
}
