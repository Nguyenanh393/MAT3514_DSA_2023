package Hw4_21000663_NguyenNgocAnh.exercise05;

public class Test {
    public static void main(String[] args) {
        System.out.println(CheckPalindrome.isPalindrome("Able was I ere I saw Elba"));
        System.out.println(CheckPalindrome.isPalindrome("qabba"));
        System.out.println(CheckPalindrome.isPalindrome("abccba"));
        System.out.println(CheckPalindrome.isPalindrome("abcEcba"));
        System.out.println(CheckPalindrome.isPalindrome("abcecbA"));
        System.out.println(CheckPalindrome.isPalindrome("abcBa"));
        System.out.println(CheckPalindrome.isPalindrome("eabcddcba e"));
        System.out.println(CheckPalindrome.isPalindrome("aBcDedc ba"));
    }
}

// true
// false
// true
// true
// true
// true
// true
// true