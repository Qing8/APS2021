package PS04.ReversePolishNotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// (1+1)*(4*5+1)-4

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String postfix = "";
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('*', 2);
        valueMap.put('/', 2);
        valueMap.put('+', 1);
        valueMap.put('-', 1);
        valueMap.put('(', 0);
        String tempStr = null;
        Character temp = Character.MIN_VALUE;
        while ((tempStr = bf.readLine()) != null )
        {

            temp = tempStr.charAt(0);
            if (temp == '('){
                stack.push(temp);
            }else if (temp == ')') {
                while (stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            }else if (Character.isDigit(temp)){
                postfix+=temp;
            }else if (stack.isEmpty()){
                stack.push(temp);
            }
            else if (valueMap.get(temp) > valueMap.get(stack.peek())){
                stack.push(temp);
            }else {
                postfix += stack.pop();
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()){
            postfix += stack.pop();
        }
        System.out.println(postfix);

    }
}
