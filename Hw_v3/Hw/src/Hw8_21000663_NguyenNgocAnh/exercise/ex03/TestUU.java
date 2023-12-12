package Hw8_21000663_NguyenNgocAnh.exercise.ex03;

import Hw8_21000663_NguyenNgocAnh.exercise.ex01.GraphADTUUInterface;
import Hw8_21000663_NguyenNgocAnh.exercise.ex01.GraphUUA;

public class TestUU {
    public void testUU() {
        GraphADTUUInterface<String, String> g = new GraphUUA<String, String>();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        g.insertEdge("A", "B", "AB");
        g.insertEdge("A", "C", "AC");
        g.insertEdge("A", "D", "AD");
        g.insertEdge("C", "D", "CD");
        g.insertEdge("C", "E", "CE");
        g.insertEdge("D", "E", "DE");

        System.out.println("Number of vertices: " + g.numVertices());
        System.out.println("Number of edges: " + g.numEdges());
        System.out.println("Vertices: " + g.vertices());
        System.out.println("Edges: " + g.edges());
        System.out.println("Edge from B to A: " + g.getEdge("B", "A"));
        System.out.println("End vertices of AB: " + g.endVertices("AB"));
        System.out.println("Opposite of A to AB: " + g.opposite("A", "AB"));
        System.out.println("Out degree of A: " + g.outDegree("A"));
        System.out.println("In degree of A: " + g.inDegree("A"));
        System.out.println("Outgoing edges of A: " + g.outgoingEdges("A"));
        System.out.println("Incoming edges of A: " + g.incomingEdges("A"));
        System.out.println("Insert vertex F: " + g.insertVertex("F"));
        System.out.println("Insert edge AF: " + g.insertEdge("A", "F", "AF"));
        System.out.println("Remove vertex F: ");
        g.removeVertex("F");
        System.out.println("Vertices: " + g.vertices());
        System.out.println("Edges: " + g.edges());
    }
}
/*
Number of vertices: 5
Number of edges: 6
Vertices: [A, B, C, D, E]
Edges: [AB, AC, AD, CD, CE, DE]
Edge from B to A: BA
End vertices of AB: [Ljava.lang.String;@65b54208
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