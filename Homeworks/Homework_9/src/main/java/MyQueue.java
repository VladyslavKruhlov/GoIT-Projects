import java.util.Arrays;

public class MyQueue <T>{
    private Object[] myQueue = new Object[0];

    public Object[] getMyQueue() {return myQueue;}

    public Object firstElement;


    //      МЕТОД ADD
    public Object[] add(T value){
        int size = myQueue.length;
        size++;
        Object [] addQueue = Arrays.copyOf(myQueue, size);
        addQueue [size-1] = value;
        myQueue = addQueue;
        return myQueue;
    }

    //      МЕТОД PEEK
    public Object peek(){
        if(myQueue.length>0){ firstElement = myQueue[0];}
        else{System.out.print("Array is empty, length is ");}
        return firstElement;
    }

    //      МЕТОД POLL

    public Object poll() {
        if (myQueue.length > 0) {
            firstElement = myQueue[0];
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
