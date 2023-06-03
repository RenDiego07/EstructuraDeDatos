package tdaP02;

// la clase NodeLDE abstrae el concepto de un nodo
// de una lista doblemente enlazada

public class NodeLDE<E> {
    private E content;
    private NodeLDE<E> next;
    private NodeLDE<E> previous;
}
