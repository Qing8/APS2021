package Lecture0218;

import java.util.Arrays;
import java.util.Stack;

public class SmallestThanCurrent {
    public static void main(String[] args){
        int[] numbers = {1, 4, 6, 13, 6, 19, 10};
        solve(numbers);

    }

    public static void solve(int[] numbers){
        int finishedIndex = numbers.length-1;
        int[] smaller = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<numbers.length; i++){
            while (!stack.isEmpty() && stack.peek()>=numbers[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                smaller[i] = -1;
            }else{
                smaller[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }
        System.out.println(Arrays.toString(smaller));
    }
}
