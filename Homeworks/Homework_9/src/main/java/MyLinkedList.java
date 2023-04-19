import java.util.*;

class MyLinkedList <T> {

    Node<T> firstNode;
    Node<T> lastNode;

    int size=0;

    //      МЕТОД ADD
    public void add(T value){
        if (firstNode==null){
            firstNode = new Node<>(null, value, null);
        } else if (lastNode==null){
            lastNode = new Node<>(firstNode, value, null);
            firstNode.setNext(lastNode);
        } else{
            Node<T> node = new Node<>(lastNode, value, null);
            lastNode.setNext(node);
            lastNode = node;
        }
        size++;
    }

    //      МЕТОД REMOVE
    public void remove(int index) {
        if (size == 1 && index == 0) {
            firstNode = null;
            size--;
        } else if (size == 2 && index == 0) {
            firstNode = lastNode;
            firstNode.setNext(null);
            lastNode = null;
            size--;
        } else if (size == 2 && index == 1) {
            firstNode.setNext(null);
            lastNode = null;
            size--;
        } else if (size > 2 && index == 0) {
            firstNode.getNext().setPrev(null);
            firstNode = firstNode.getNext();
            size--;
        } else if (index == size - 1) {
            lastNode.getPrev().setNext(null);
            lastNode = lastNode.getPrev();
            size--;
        } else if (size > 2 && index > 0 && index < size - 1) {
            Node<T> localNode = firstNode;

            for (int i = 0; i < size - 1; i++) {
                if (i == index) {
                    localNode.getPrev().setNext(localNode.getNext());
                    localNode.getNext().setPrev(localNode.getPrev());
                    size--;
                    break;
                }

                localNode = localNode.getNext();
            }
        }
//        Objects.checkIndex(index, size);
//        Node<T> current = firstNode;
//
//        for (int i = 0; i < size - 1; i++) {
//             if (index == size-1 && size>2) {
//                lastNode = lastNode.getPrev();
//                lastNode.getPrev().setNext(null);
//                size--;
//            } else if (index==0 && size<2){
//                firstNode = null;
//                size--;
//            } else if (index==1 && size==2){
//                firstNode.setNext(null);
//                lastNode = null;
//                size--;
//            } else if (i == index) {
//                current.getPrev().setNext(current.getNext());
//                current.getNext().setPrev(current.getPrev());
//                size--;
//                break;
//            }
//        }
    }

    //      МЕТОД GET

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = firstNode;
        for(int i=0; i<index;i++){
            current = current.getNext();
        }
        return current.getCurrent();
    }

    //      МЕТОД SIZE

    public int size() {
        return size;
    }

    //      МЕТОД CLEAR
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
}
