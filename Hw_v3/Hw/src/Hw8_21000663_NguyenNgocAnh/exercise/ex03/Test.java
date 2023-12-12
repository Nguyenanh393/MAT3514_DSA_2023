package Hw8_21000663_NguyenNgocAnh.exercise.ex03;
// sử dụng test đã có trong ex02 và ex01
public class Test {
    public static void main(String[] args) {
        System.out.println("Co huong: ");
        TestDW testDW = new TestDW();
        testDW.testDW();

        System.out.println("--------------------------------------------------");

        System.out.println("Vo huong: ");
        TestUU testUU = new TestUU();
        testUU.testUU();
    }
}
/*
Co huong: 
Number of vertices: 5
Number of edges: 6
Vertices: [A, B, C, D, E]
Edges: [AB, BA, AC, CA, AD, DA, CD, DC, CE, EC, DE, ED]
Edge from A to B: AB
End vertices of AB: [Ljava.lang.String;@1be6f5c3
Opposite of A to AB: B
Out degree of A: 3
In degree of A: 3
Outgoing edges of A: [AB, AC, AD]
Incoming edges of A: [BA, CA, DA]
Insert vertex F: F
Insert edge AF: AF
Remove vertex F:
Remove edge AF:
Vertices: [A, B, C, D, E]
Edges: [AB, BA, AC, CA, AD, DA, CD, DC, CE, EC, DE, ED]
--------------------------------------------------
Vo huong:
Number of vertices: 5
Number of edges: 6
Vertices: [A, B, C, D, E]
Edges: [AB, AC, AD, CD, CE, DE]
Edge from B to A: BA
End vertices of AB: [Ljava.lang.String;@5b2133b1
Opposite of A to AB: B
Out degree of A: 3
In degree of A: 3
Outgoing edges of A: [AB, AC, AD]
Incoming edges of A: [BA, CA, DA]
Insert vertex F: F
Insert edge AF: AF
Remove vertex F:
Vertices: [A, B, C, D, E]
Edges: [AB, AC, AD, CD, CE, DE]
*/