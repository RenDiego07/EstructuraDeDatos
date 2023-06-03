package tdaP02;


import java.util.Random;

public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayList() {
        // elements = new E[100]; // NO vale
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            //throw new NullPointerException("Null elements are not accepted");
            return false;
        } else if (isEmpty()) {

            // si se quiere hacer el bacán
            // elements[effectiveSize++] = element;
            // con humildad
            elements[effectiveSize] = element;
            effectiveSize++;

            return true;
        }
        if (isFull()) {
            addCapacity();
        }
        // empujar para hacer espacio. Bit shifting
        for (int i = effectiveSize; i > 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        //con humildad
        //elements[effectiveSize] = element;
        //effectiveSize++;
        // con orgullo
        elements[effectiveSize++] = element;
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
        if (index < 0 || index > effectiveSize) {
            // throw new IndexOutOfBoundsException("Invalid index: " + index);
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
            // elements[i+1] = elements[i]; MAL
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        // copiando los elementos del arreglo viejo al nuevo
//        for (int i= 0; i<effectiveSize; i++) {
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    @Override
    public void reverse() {
        int start = 0;
        int end = effectiveSize - 1;
        while (start < end) {
            E temp = elements[start];
            elements[start] = elements[end];
            elements[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public List<E> subList(int from, int to) {
        if (from < 0 || from >= effectiveSize || to < 0 || to > effectiveSize || from > to) {
            throw new IndexOutOfBoundsException("Invalid index range");
        }

        ArrayList<E> sublist = new ArrayList<>();
        for (int i = from; i < to; i++) {
            sublist.addLast(elements[i]);
        }
        return sublist;
    }

    @Override
    public boolean removeFirstNElements(int n) {
        if (n <= 0 || n > effectiveSize) {
            return false;
        }
        for (int i = n; i < effectiveSize; i++) {
            elements[i - n] = elements[i];
        }
        effectiveSize -= n;
        return true;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = effectiveSize - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            E temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }

    @Override
    public void rotate(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Invalid rotation amount");
        }

        int rotation = k % effectiveSize;
        if (rotation == 0) {
            return;  // No rotation needed
        }

        E[] temp = (E[]) new Object[effectiveSize];
        for (int i = 0; i < effectiveSize; i++) {
            temp[i] = elements[i];
        }

        for (int i = 0; i < effectiveSize; i++) {
            elements[(i + rotation) % effectiveSize] = temp[i];
        }
    }

}
