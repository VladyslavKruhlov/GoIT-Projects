import java.util.Arrays;

public class MyArrayList<T> {
    private Object [] myArray = new Object[0];

    public Object[] getMyArray() {return myArray;}

    //      МЕТОД ADD
    public void add(T value) {
        int size = myArray.length;
        size++;
        Object [] workArray = Arrays.copyOf(myArray, size);
        workArray[size-1] = value;
        myArray = workArray;
    }

    //      МЕТОД REMOVE
    public void remove(int value){
        int size = myArray.length;
        Object [] newArray = new Object[myArray.length];
        Object [] workArray = new Object[newArray.length-1];
        int index=0;

        for(int i=0; i<myArray.length; i++){
            if(i != value){
                newArray[index] = myArray[i]; index++;}
        }
        workArray = Arrays.copyOf(newArray, workArray.length);

        myArray = workArray;
    }

    //      МЕТОД GET
    public T get(int value){
        if(myArray.length>value){
            return (T)myArray[value];}
        else {
            return (T)Exception.class;}
    }

    //      МЕТОД CLEAR
    public void clear(){
        myArray = new Object[0];}

    //      МЕТОД SIZE
    public int size(){
        int size = myArray.length;
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(myArray);
    }
}
