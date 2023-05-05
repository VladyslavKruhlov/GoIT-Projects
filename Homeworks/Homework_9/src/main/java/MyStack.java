import java.util.Arrays;

public class MyStack<T> {

    private Object[] myStack = new Object[0];

    public Object[] getMyStack() {return myStack;}

    public T firstElement;

    //          МЕТОД PUSH
    public void push(T value){

        int size = myStack.length;
        size++;
        Object [] newStack = Arrays.copyOf(myStack, size);
        newStack[size-1] = value;
        myStack = newStack;
    }

    //          МЕТОД REMOVE

    public void remove (int value){
        int size = myStack.length;
        size--;
        Object[] newStack = new Object[size];
        int index=0;

        for(int i=0; i<myStack.length; i++){
            if(i!=value){
                newStack[index] = myStack[i];
                index++;
            }
        }
        myStack = newStack;
    }

    //          МЕТОД SIZE
    public int size(){
        return myStack.length;
    }

    //          МЕТОД CLEAR
    public void clear(){
        myStack = new Object[0];
    }

    //          МЕТОД PEEK
    public T peek(){
        if(myStack.length>0){ firstElement = (T)myStack[myStack.length-1];}
        else{System.out.print("Array is empty, length is ");}
        return firstElement;
    }

    //          МЕТОД POP
    public T pop() {
        if (myStack.length > 0) {
            firstElement = (T)myStack[myStack.length-1];
        } else {
            System.out.print("Array is empty, length is ");
        }

        Object[] newArray = new Object[myStack.length-1];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = myStack[i];}

        myStack = newArray;

        return firstElement;
    }


    @Override
    public String toString() {
        return Arrays.toString(myStack);
    }
}
