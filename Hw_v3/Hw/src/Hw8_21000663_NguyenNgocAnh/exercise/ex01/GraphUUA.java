package Hw8_21000663_NguyenNgocAnh.exercise.ex01;

import java.util.*;

public class GraphUUA<V, E> implements GraphADTUUInterface<V, E>{

    private int numVertices;
    private int[][] adjacencyMatrix;
    private ArrayList<V> vertices;

    public GraphUUA() {
        numVertices = 0;
        adjacencyMatrix = new int[10][10];
        vertices = new ArrayList<>();
    }

    public GraphUUA(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        vertices = new ArrayList<>();
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
        return vertices;
    }

    @Override
    public int numEdges() {
        int numEdges = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    numEdges++;
                }
            }
        }
        return numEdges;
    }

    @Override
    public Iterable<E> edges() {
        if (numVertices == 0) {
            return null;
        }
        ArrayList<E> edges = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    edges.add((E) (vertices.get(i).toString() + vertices.get(j).toString()));
                }
            }
        }
        return edges;
    }

    @Override
    public E getEdge(V u, V v) {
        if (numVertices == 0) {
            return null;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(u)) {
                i = k;
            }
            if (vertices.get(k).equals(v)) {
                j = k;
            }
        }
        if (adjacencyMatrix[i][j] != 0) {
            return (E) (u.toString() + v.toString());
        }
        return null;
    }

    @Override
    public V[] endVertices(E e) {
        if (numVertices == 0) {
            return null;
        }
        String[] endVertices = new String[2];
        endVertices[0] = e.toString().charAt(0) + "";
        endVertices[1] = e.toString().charAt(1) + "";
        return (V[]) endVertices;
    }

    @Override
    public V opposite(V v, E e) {
        if (numVertices == 0) {
            return null;
        }
        String[] endVertices = new String[2];
        endVertices[0] = e.toString().charAt(0) + "";
        endVertices[1] = e.toString().charAt(1) + "";
        if (endVertices[0].equals(v.toString())) {
            return (V) endVertices[1];
        }
        if (endVertices[1].equals(v.toString())) {
            return (V) endVertices[0];
        }
        return null;
    }

    @Override
    public int outDegree(V v) {
        if (numVertices == 0) {
            return 0;
        }
        int i = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(v)) {
                i = k;
            }
        }
        int outDegree = 0;
        for (int j = 0; j < numVertices; j++) {
            if (adjacencyMatrix[i][j] != 0) {
                outDegree++;
            }
        }
        return outDegree;
    }

    @Override
    public int inDegree(V v) {
        if (numVertices == 0) {
            return 0;
        }
        int i = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(v)) {
                i = k;
            }
        }
        int inDegree = 0;
        for (int j = 0; j < numVertices; j++) {
            if (adjacencyMatrix[j][i] != 0) {
                inDegree++;
            }
        }
        return inDegree;
    }

    @Override
    public Iterable<E> outgoingEdges(V v) {
        if (numVertices == 0) {
            return null;
        }
        ArrayList<E> outgoingEdges = new ArrayList<>();
        int i = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(v)) {
                i = k;
            }
        }
        for (int j = 0; j < numVertices; j++) {
            if (adjacencyMatrix[i][j] != 0) {
                outgoingEdges.add((E) (v.toString() + vertices.get(j).toString()));
            }
        }
        return outgoingEdges;
    }

    @Override
    public Iterable<E> incomingEdges(V v) {
        if (numVertices == 0) {
            return null;
        }
        ArrayList<E> incomingEdges = new ArrayList<>();
        int i = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(v)) {
                i = k;
            }
        }
        for (int j = 0; j < numVertices; j++) {
            if (adjacencyMatrix[j][i] != 0) {
                incomingEdges.add((E) (vertices.get(j).toString() + v.toString()));
            }
        }
        return incomingEdges;
    }

    @Override
    public V insertVertex(V x) {
        if (numVertices == adjacencyMatrix.length) {
            int[][] tempMatrix = new int[numVertices * 2][numVertices * 2];
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    tempMatrix[i][j] = adjacencyMatrix[i][j];
                }
            }
            adjacencyMatrix = tempMatrix;
        }
        vertices.add(x);
        numVertices++;
        return x;
    }

    @Override
    public E insertEdge(V u, V v, E x) {
        if (numVertices == 0) {
            return null;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(u)) {
                i = k;
            }
            if (vertices.get(k).equals(v)) {
                j = k;
            }
        }
        if (adjacencyMatrix[i][j] == 0) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1;
            return x;
        }
        return null;
    }

    @Override
    public void removeVertex(V v) {
        if (numVertices == 0) {
            return;
        }
        int i = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(v)) {
                i = k;
            }
        }
        for (int j = i; j < numVertices - 1; j++) {
            vertices.set(j, vertices.get(j + 1));
        }
        vertices.remove(numVertices - 1);
        numVertices--;
        for (int j = i; j < numVertices; j++) {
            for (int k = 0; k < numVertices; k++) {
                adjacencyMatrix[j][k] = adjacencyMatrix[j + 1][k];
            }
        }
        for (int j = i; j < numVertices; j++) {
            for (int k = 0; k < numVertices; k++) {
                adjacencyMatrix[k][j] = adjacencyMatrix[k][j + 1];
            }
        }
    }

    @Override
    public void removeEdge(E e) {
        if (numVertices == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < numVertices; k++) {
            if (vertices.get(k).equals(e.toString().charAt(0) + "")) {
                i = k;
            }
            if (vertices.get(k).equals(e.toString().charAt(1) + "")) {
                j = k;
            }
        }
        adjacencyMatrix[i][j] = 0;
        adjacencyMatrix[j][i] = 0;
    }

    class Iterator<T> {
        public boolean hasNext() {
            if (numVertices == 0) {
                return false;
            } else {
                return true;
            }
        }
        public T next() {
            if (numVertices == 0) {
                return null;
            } else {
                return (T) vertices.get(numVertices--);
            }
        }
    }
}
