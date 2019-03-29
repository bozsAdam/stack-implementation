package stack;

import stack.exception.StackOverFlowException;
import stack.exception.StackUnderFlowException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stack<T>{

    private T[] storage;

    public Stack(int size){
        storage = (T[])new Object[size];
    }

    public void push(T t){
        if(size() != storage.length){
            for (int i = storage.length-1; i >= 0 ; i--) {
                if(storage[i] == null){
                    storage[i] = t;
                    return;
                }
            }
        }

        throw new StackOverFlowException();
    }

    public int size(){
        return Stream.of(storage).filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new))
                .size();
    }

    public T peek() {
        return Stream.of(storage)
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(StackUnderFlowException::new);
    }
    
    private int getFirstIndex(){
        if(this.size() != 0){
            for (int i = 0; i < storage.length ; i++) {
                if(storage[i] != null){
                    return i;
                }
            }
        }
        return -1;
    }

    private void removeElementAt(int index){
        storage[index] = null;
    }

    public T pop(){
        T e = this.peek();
        removeElementAt(getFirstIndex());
        return e;
    }

    public boolean contains(T t){
        for (T element : storage){
            if(element != null){
                if(element.equals(t)){
                    return true;
                }
            }
        }

        return false;
    }


}
