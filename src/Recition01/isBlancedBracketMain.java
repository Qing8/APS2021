package Recition01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class isBlancedBracketMain {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++){
            String s = bf.readLine();
            isBalanced(s);
        }
    }

    public static void isBalanced(String s) throws IOException{
        Stack<Character> brackStack = new Stack<>();
        for (char c : s.toCharArray()){
            switch (c){
                case '{':
                    brackStack.push('}');
                    break;
                case '(':
                    brackStack.push(')');
                    break;
                case '[':
                    brackStack.push(']');
                    break;
                default:
                    if(brackStack.isEmpty() || brackStack.pop() != c){
                        System.out.println("NO");
                        return;
                    }
            }
        }
        if (brackStack.isEmpty()){
            System.out.println("YES");
            return;
        }else {
            System.out.println("NO");
            return;
        }
    }
}


