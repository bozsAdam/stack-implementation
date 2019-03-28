package stack;

public class Stack<T>{

    private T[] storage;

    public Stack(int size){
        storage = (T[])new Object[size];
    }


    public T[] getStorage() {
        return storage;
    }
}
