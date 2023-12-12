package Hw8_21000663_NguyenNgocAnh.exercise.ex01;
// cách khác không liên quan đến bài tập
import java.util.*;

public class GraphADTUU<V, E> implements GraphADTUUInterface<V, E> {

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

    public GraphADTUU() {
        vertices = new Vertex[10];
        edges = new Edge[10];
        numVertices = 0;
        numEdges = 0;
    }

    public GraphADTUU(int numVertices, int numEdges) {
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
            return Collections.emptyList();
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
        Edge<E>[] temp = new Edge[numEdges*2];
        for (int i = 0; i < numEdges; i++) {
            temp[i] = edges[i];
            Vertex<V>[] endpoints = new Vertex[2];
            endpoints[0] = edges[i].getEndpoints()[1];
            endpoints[1] = edges[i].getEndpoints()[0];
            Edge<E> e = new Edge<E>(edges[i].getElement(), endpoints);
            temp[i + numEdges] = e;
        }
        return (Iterable<E>) Arrays.asList(temp);
    }

    @Override
    public E getEdge(V u, V v) {
        if (numEdges == 0) {
            return null;
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement() == u && edges[i].getEndpoints()[1].getElement() == v) {
                return edges[i].getElement();
            } 

            if (edges[i].getEndpoints()[0].getElement() == v && edges[i].getEndpoints()[1].getElement() == u) {
                return edges[i].getElement();
            }
        } 
        return null;
    }

    @Override
    public V[] endVertices(E e) {
        Edge<E> temp = new Edge<E>(e, null);
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getElement() == temp.getElement()) {
                return (V[]) edges[i].getEndpoints();
            }
        }
        return null;
    }



    @Override
    public V opposite(V v, E e) {
        if (numEdges == 0) {
            return null;
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getElement() == e) {
                if (edges[i].getEndpoints()[0].getElement() == v) {
                    return edges[i].getEndpoints()[1].getElement();
                } else {
                    return edges[i].getEndpoints()[0].getElement();
                }
            }
        }
        return null;
    }

    @Override
    public int outDegree(V v) {
        if (numEdges == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement() == v) {
                count++;
            }
            if (edges[i].getEndpoints()[1].getElement() == v) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(V v) {
        if (numEdges == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[1].getElement() == v) {
                count++;
            }

            if (edges[i].getEndpoints()[0].getElement() == v) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterable<E> outgoingEdges(V v) {
        Vertex<V> temp = new Vertex<V>(v);
        if (numEdges == 0) {
            return null;
        }
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[0].getElement() == temp.getElement()) {
                return (Iterable<E>) Arrays.asList(edges[i]);
            }

            if (edges[i].getEndpoints()[1].getElement() == temp.getElement()) {
                return (Iterable<E>) Arrays.asList(edges[i]);
            }
        }
        return null;

    }

    @Override
    public Iterable<E> incomingEdges(V v) {
        if (numEdges == 0) {
            return null;
        }
        Vertex<V> temp = new Vertex<V>(v);
        for (int i = 0; i < numEdges; i++) {
            if (edges[i].getEndpoints()[1].getElement() == temp.getElement()) {
                return (Iterable<E>) Arrays.asList(edges[i]);
            }

            if (edges[i].getEndpoints()[0].getElement() == temp.getElement()) {
                return (Iterable<E>) Arrays.asList(edges[i]);
            }
        }
        return null;
    }

    @Override
    public V insertVertex(V x) {
        if (numVertices == vertices.length) {
            Vertex<V>[] temp = new Vertex[vertices.length * 2];
            for (int i = 0; i < vertices.length; i++) {
                temp[i] = vertices[i];
            }
            vertices = temp;
        }
        vertices[numVertices++] = new Vertex<V>(x);
        return x;
    }

    @Override
    public E insertEdge(V u, V v, E x) {
        if (numEdges == edges.length) {
            Edge<E>[] temp = new Edge[edges.length * 2];
            for (int i = 0; i < edges.length; i++) {
                temp[i] = edges[i];
            }
            edges = temp;
        }
        Vertex<V>[] endpoints = new Vertex[2];
        endpoints[0] = new Vertex<V>(u);
        endpoints[1] = new Vertex<V>(v);
        edges[numEdges++] = new Edge<E>(x, endpoints);
        return x;
    }

    @Override
    public void removeVertex(V v) {
        if (numVertices == 0) {
            return;
        }
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getElement() == v) {
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
        if (numEdges == 0) {
            return;
        }
        for (int i = 0; i < numEdges; i++) {
            E e1 = (E) (e.toString().charAt(1) + "" + e.toString().charAt(0));
            if (edges[i].getElement() == e || edges[i].getElement() == e1) {
                for (int j = i; j < numEdges - 1; j++) {
                    edges[j] = edges[j + 1];
                }
                numEdges--;
                break;
            }
        }
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
                return (T) vertices[numVertices--];
            }
        }
    
    }
}
