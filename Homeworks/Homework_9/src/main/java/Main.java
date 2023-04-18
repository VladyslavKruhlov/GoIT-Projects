import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> nod = new MyHashMap<>();
        nod.put("S", 1);
        nod.put("R", 2);
        nod.remove("S");
        //nod.clear();
        System.out.println(nod.get("S"));
    }
//        MyLinkedList<Integer> my = new MyLinkedList<>();
//        my.add(1);
//        my.add(2);
//        my.add(3);
//        my.add(4);
//        my.add(5);
//        my.remove(0);
//        System.out.println(my);

//          ArrayList

//        MyArrayList<String> my = new MyArrayList<>();
//        my.add("S");
//        my.add("R");
//        my.add("T");
//        my.add("P");
//        System.out.println(my);
//        System.out.println(my.get(3));
//        my.remove(2);
//        System.out.println(my);
//        System.out.println(my.size());
//        System.out.println(my.clear());
//        my.add("o");
//        System.out.println(my);



//          Queue
//        MyQueue <Integer> myQueue = new MyQueue<>();
//        myQueue.add(5);
//        myQueue.add(1);
//        myQueue.add(2);
//        myQueue.add(2);
//
//        myQueue.clear();
//        System.out.println(myQueue);
//        System.out.println(myQueue.size());


//          Stack
//        MyStack <Integer> myStack = new MyStack<>();
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.push(4);
//        myStack.push(5);
//        System.out.println(myStack.pop());
//        System.out.println(myStack);
        //MyHashMap
//        MyHashMap<Integer, String> nod = new MyHashMap<>();
//        nod.put(1, "1");
//        nod.put(1, "2");
//        System.out.println(nod);
//    }
}