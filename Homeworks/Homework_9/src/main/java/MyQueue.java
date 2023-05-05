import java.util.Arrays;

public class MyQueue <T>{
    private Object[] myQueue = new Object[0];

    public Object[] getMyQueue() {return myQueue;}

    public T firstElement;


    //      МЕТОД ADD
    public void add(T value){
        int size = myQueue.length;
        size++;
        Object [] addQueue = Arrays.copyOf(myQueue, size);
        addQueue [size-1] = value;
        myQueue = addQueue;
    }

    //      МЕТОД PEEK
    public T peek(){
        if(myQueue.length>0){ firstElement = (T) myQueue[0];}
        else{System.out.print("Array is empty, length is ");}
        return firstElement;
    }

    //      МЕТОД POLL

    public T poll() {
        if (myQueue.length > 0) {
            firstElement = (T) myQueue[0];
        } else {
            System.out.print("Array is empty, length is ");
        }

        Object[] newArray = new Object[myQueue.length-1];
        int size = 0;

        for (int i = 1; i < myQueue.length; i++) {
            newArray[size] = myQueue[i];
            size++;}

            myQueue = newArray;

        return firstElement;
    }

    //      МЕТОД SIZE
    public int size(){
        return myQueue.length;
    }

    //      МЕТОД CLEAR
    public void clear(){
        myQueue = new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(myQueue);
    }
}
