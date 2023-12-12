package Hw8_21000663_NguyenNgocAnh.exercise.ex02;
// cách khác không liên quan đến bài tập
import java.util.*;

public class GraphADTDW<V, E> implements GraphADTDWInterface<V, E>{

    // đồ thị có hướng có trọng số (D/W) sử dụng ma trận kề.
    
    private class Vertex<V> {
        private V element;
        public Vertex(V element) {
            this.element = element;
        }
        public V getElement() {
            return element;
        }
        public String toString() {
            return element.toString();
        }
    }

    private class Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;
        public Edge(E element, Vertex<V>[] endpoints) {
            this.element = element;
            this.endpoints = endpoints;
        }
        public E getElement() {
            return element;
        }
        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }
        public String toString() {
            return element.toString();
        }
    }


    private Vertex<V>[] vertices;
    private Edge<E>[] edges;
    private int numVertices;
    private int numEdges;

    public GraphADTDW() {
        vertices = new Vertex[10];
        edges = new Edge[10];
        numVertices = 0;
        numEdges = 0;
    }

    public GraphADTDW(int numVertices, int numEdges) {
        vertices = new Vertex[numVertices];
        edges = new Edge[numEdges];
        this.numVertices = numVertices;
        this.numEdges = numEdges;
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public Iterable<V> vertices() {
        if (numVertices == 0) {
            return null;
        }
        Vertex<V>[] temp = new Vertex[numVertices];
        for (int i = 0; i < numVertices; i++) {
            temp[i] = vertices[i];
        }
        return (Iterable<V>) Arrays.asList(temp);
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Iterable<E> edges() {
        if (numEdges == 0) {
            return null;
        }
        Edge<E>[] temp = new Edge[numEdges];
        for (int i = 0; i < numEdges; i++) {
            temp[i] = edges[i];
        }
        return (Iterable<E>) Arrays.asList(temp);
    }

    @Override
    public E getEdge(V u, V v) {
        if (u == null || v == null) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement().equals(u) && edges[i].getEndpoints()[1].getElement().equals(v)) {
                return edges[i].getElement();
            }
        }
        return null;
    }

    @Override
    public V[] endVertices(E e) {
        Edge<E> temp = new Edge<E>(e, null);
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getElement().equals(temp.getElement())) {
                return (V[]) edges[i].getEndpoints();
            }
        }
        return null;
    }

    @Override
    public V opposite(V v, E e) {
        if (v == null || e == null) {
            throw new IllegalArgumentException("Invalid vertex or edge");
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getElement().equals(e)) {
                if (edges[i].getEndpoints()[0].getElement().equals(v)) {
                    return edges[i].getEndpoints()[1].getElement();
                }
                if (edges[i].getEndpoints()[1].getElement().equals(v)) {
                    return edges[i].getEndpoints()[0].getElement();
                }
            }
        }
        return null;
    }

    @Override
    public int outDegree(V v) {
        if (v == null) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement().equals(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(V v) {
        if (v == null) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[1].getElement().equals(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterable<E> outgoingEdges(V v) {
        Vertex<V> temp = new Vertex<V>(v);
        Edge<E>[] outgoingEdges = new Edge[outDegree(v)];
        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement().equals(temp.getElement())) {
                outgoingEdges[count] = edges[i];
                count++;
            }
        }
        return (Iterable<E>) Arrays.asList(outgoingEdges);
    }

    @Override
    public Iterable<E> incomingEdges(V v) {
        Vertex<V> temp = new Vertex<V>(v);
        Edge<E>[] incomingEdges = new Edge[inDegree(v)];
        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[1].getElement().equals(temp.getElement())) {
                incomingEdges[count] = edges[i];
                count++;
            }
        }
        return (Iterable<E>) Arrays.asList(incomingEdges);
    }

    @Override
    public V insertVertex(V x) {
        if (x == null) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        Vertex<V> vertex = new Vertex<V>(x);
        vertices[numVertices] = vertex;
        numVertices++;
        return vertex.getElement();
    }

    @Override
    public E insertEdge(V u, V v, E x) {
        if (u == null || v == null || x == null) {
            throw new IllegalArgumentException("Invalid vertex or edge");
        }
        Vertex<V>[] temp = new Vertex[2];
        temp[0] = new Vertex<V>(u);
        temp[1] = new Vertex<V>(v);
        Edge<E> edge = new Edge<E>(x, temp);
        edges[numEdges] = edge;
        numEdges++;
        return edge.getElement();
    }

    @Override
    public void removeVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("Invalid vertex");
        }
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getElement().equals(v)) {
                for (int j = i; j < numVertices - 1; j++) {
                    vertices[j] = vertices[j + 1];
                }
                numVertices--;
                break;
            }
        }
    }

    @Override
    public void removeEdge(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Invalid edge");
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getElement().equals(e)) {
                for (int j = i; j < numEdges - 1; j++) {
                    edges[j] = edges[j + 1];
                }
                numEdges--;
                break;
            }
        }
    }
    
    class Iterator<E> {
        private int current = 0;
        public boolean hasNext() {
            return current < numEdges;
        }
        public E next() {
            return (E) edges[current++];
        }
    }
}
