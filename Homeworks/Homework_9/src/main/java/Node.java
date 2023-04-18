class Node<T> {

    private Node<T> prev;
    private T current;
    private Node<T> next;

    public Node<T> getPrev() {

        return prev;
    }

    public void setPrev(Node<T> prev) {

        this.prev = prev;
    }

    public T getCurrent() {

        return current;
    }

    public void setCurrent(T current) {

        this.current = current;
    }

    public Node<T> getNext() {

        return next;
    }

    public void setNext(Node<T> next) {

        this.next = next;
    }

    public Node(Node<T> prev, T current, Node<T> next) {
        this.prev = prev;
        this.current = current;
        this.next = next;
    }

}
