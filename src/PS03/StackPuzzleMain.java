package PS03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
    Input:
        madam
        adamm
    Output:
        [
        i i i i o o o i o o
        i i i i o o o o i o
        i i o i o i o i o o
        i i o i o i o o i o
        ]
 */

public class StackPuzzleMain {

    private List<String> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String src = bf.readLine();
        String target = bf.readLine();
        Stack<Character> stack = new Stack<>();
        StackPuzzleMain main = new StackPuzzleMain();
        main.solve(src, target, 0, 0,"", stack);
        System.out.print("[");
        Collections.sort(main.operations);
        for (String o: main.operations){
            for (int i=0; i<o.length(); i++){
                if (i==0){
                    System.out.print("\n");
                    System.out.print(o.charAt(i));
                }else{
                    System.out.print(" " + o.charAt(i));
                }

            }
        }
        System.out.println("\n]");

    }

    public void solve(String src, String target, int srcIndex, int targetIndex, String curOperations, Stack<Character> curStack){
        // base case
            // when finish matching process
        if (targetIndex >= target.length()) {
            operations.add(curOperations);
            return;
            // when the target string can never be matched
        }else if (srcIndex > targetIndex + curStack.size()){
            return;
        }
        // start recursion steps
            // two operations

//        for(int i=0; i<2; i++){
//            if (i==0){
//                // do pop
//                if (curStack.isEmpty() || curStack.peek() != target.charAt(targetIndex)) continue;
//                Character poped = curStack.pop();
//                solve(src,target,srcIndex,targetIndex+1,curOperations+"o",curStack);
//                curStack.push(poped);
//            }else{
//                // do push
//                if (srcIndex >= src.length()) return;
//                curStack.push(src.charAt(srcIndex));
//                solve(src, target, srcIndex+1, targetIndex, curOperations+"i", curStack);
//                curStack.pop();
//            }
//        }

        if (srcIndex<src.length()){
            curStack.push(src.charAt(srcIndex));
            solve(src,target,srcIndex+1,targetIndex,curOperations+"i",curStack);
            curStack.pop();
        }
        if (!curStack.isEmpty() && curStack.peek() == target.charAt(targetIndex)){
            Character popped = curStack.pop();
            solve(src,target,srcIndex,targetIndex+1,curOperations+"o",curStack);
            curStack.push(popped);
        }



/*
        [
        i i i i o o o i o o
        i i i i o o o o i o
        i i o i o i o i o o
        i i o i o i o o i o
        ]
 */
        }
    }

