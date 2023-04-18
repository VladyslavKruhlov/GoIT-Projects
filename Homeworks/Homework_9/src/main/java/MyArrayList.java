import java.util.Arrays;

public class MyArrayList<T> {
    private Object [] myArray = new Object[0];

    public Object[] getMyArray() {return myArray;}

    //      МЕТОД ADD
    public Object  add(T value) {
        int size = myArray.length;
        size++;
        Object [] workArray = Arrays.copyOf(myArray, size);
        workArray[size-1] = value;
        return myArray = workArray;
    }

    //      МЕТОД REMOVE
    public Object remove(int value){
        int size = myArray.length;
        Object [] newArray = new Object[myArray.length];
        Object [] workArray = new Object[newArray.length-1];
        int index=0;

        for(int i=0; i<myArray.length; i++){
            if(i != value){
                newArray[index] = myArray[i]; index++;}
        }
        workArray = Arrays.copyOf(newArray, workArray.length);

        return myArray = workArray;
    }

    //      МЕТОД GET
    public Object get(int value){
        if(myArray.length>value){
            return myArray[value];}
        else {
            return Exception.class;}
    }

    //      МЕТОД CLEAR
    public void clear(){
        myArray = new Object[0];}

    //      МЕТОД SIZE
    public Object size(){
        int size = myArray.length;
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(myArray);
    }
}
