package stack;

import stack.exception.StackOverFlowException;
import stack.exception.StackUnderFlowException;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stack = new Stack<>(10);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        stack = null;
    }

    @org.junit.jupiter.api.Test
    void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3,stack.peek());

    }

    @org.junit.jupiter.api.Test
    void size() {
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);

        assertEquals(5,stack.size());

    }

    @org.junit.jupiter.api.Test
    void peek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertEquals(6,stack.peek());
        assertTrue(stack.contains(6));

    }

    @org.junit.jupiter.api.Test
    void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertEquals(6,stack.pop());
        assertFalse(stack.contains(6));
    }

    @org.junit.jupiter.api.Test
    void stackOverFlow(){
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }


        assertThrows(StackOverFlowException.class,() -> stack.push(1));
    }

    @org.junit.jupiter.api.Test
    void stackUnderFlow(){
        assertThrows(StackUnderFlowException.class,() -> stack.pop());
    }

}