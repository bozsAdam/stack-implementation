package stack;

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
            for (int i = 0; i < storage.length ; i++) {
                if(storage[i] == null){
                    storage[i] = t;
                    return;
                }
            }
        }
    }

    public int size(){
        return Stream.of(storage).filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new))
                .size();
    }

}
