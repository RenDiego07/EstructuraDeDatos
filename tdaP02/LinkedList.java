package tdaP02;

public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int size() {
        int cont = 0;
        Node<E> viajero;
        for (viajero = first; viajero != null; viajero = viajero.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        String result = "{";
        Node<E> p;
        for (p = first; p != null; p = p.getNext()) {

            result += p.getContent() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        nuevo.setNext(this.first);
        if (this.isEmpty()) {
            this.last = nuevo;
        }
        this.first = nuevo;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        if (this.isEmpty()) {
            this.first = nuevo;
        } else {
            this.last.setNext(nuevo);
        }
        this.last = nuevo;
        return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public E remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeFirstNElements(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void rotate(int k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
