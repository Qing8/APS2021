package PS03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class TrainMain {
    public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int NTrains = Integer.parseInt(bf.readLine());
    int[] inputTrains = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    while (inputTrains.length != 1){

        System.out.println(solve(inputTrains, NTrains));

        inputTrains = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    }
    public static String solve(int[] inputTrains, int NTrains) {
        Stack<Integer> stack = new Stack<>();
        int trainNo = 1;
        for (int i=0; i<inputTrains.length; i++){
            while (stack.isEmpty() || stack.peek()<inputTrains[i]){
                stack.push(trainNo);
                trainNo++;
            }
            if (stack.peek() == inputTrains[i]){
                stack.pop();
            }else if (stack.peek() > inputTrains[i]){
                return "No";
            }
        }
        if (stack.isEmpty()){
            return "Yes";
        }return "No";
    }
}

