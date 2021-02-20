import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

public class Main {
    private Stack<Character> stack = new Stack<>();
    private List<String> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String src = bf.readLine();
        String target = bf.readLine();

        Main main = new Main();
        main.solve(src, target, 0, 0,"");
        for (String o: main.operations){
            System.out.println("operantion: " + o);
        }
    }

    public void solve(String src, String target, int srcIndex, int targetIndex, String curOperations){
        if (srcIndex >= src.length()){
            return;
        }
        if (targetIndex == target.length()-1){
            operations.add(curOperations);
            return;
        }
        if (stack.isEmpty()){
            stack.push(src.charAt(srcIndex));
            solve(src, target, srcIndex+1, targetIndex, curOperations+"i");
        }else if (stack.peek() == target.charAt(targetIndex)){
            char popped = stack.pop();
            solve(src, target, srcIndex, targetIndex+1, curOperations+"o");
            stack.push(popped);
            stack.push(src.charAt(srcIndex));
            solve(src, target, srcIndex+1, targetIndex, curOperations+"i");
        }else{
            stack.push(src.charAt(srcIndex));
            solve(src, target, srcIndex+1, targetIndex, curOperations+"i");
        }
    }
}
