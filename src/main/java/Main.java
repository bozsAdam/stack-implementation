import stack.Stack;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(Arrays.toString(stack.getStorage()));


    }

}
