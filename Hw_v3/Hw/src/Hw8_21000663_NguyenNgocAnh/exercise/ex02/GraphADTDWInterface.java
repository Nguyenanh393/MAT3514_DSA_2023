package Hw8_21000663_NguyenNgocAnh.exercise.ex02;

public interface GraphADTDWInterface<V, E> {
    int numVertices();
    Iterable<V> vertices();
    int numEdges();
    Iterable<E> edges();
    E getEdge(V u, V v);
    V[] endVertices(E e);
    V opposite(V v, E e);
    int outDegree(V v);
    int inDegree(V v);
    Iterable<E> outgoingEdges(V v);
    Iterable<E> incomingEdges(V v);
    V insertVertex(V x);
    E insertEdge(V u, V v, E x);
    void removeVertex(V v);
    void removeEdge(E e);
}
