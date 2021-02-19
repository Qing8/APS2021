package Recitation03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackMain {
//3 8
//3 30
//4 50
//5 60
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NLimit = bf.readLine().split((" "));
        int N = Integer.valueOf(NLimit[0]);
        int weightLimit = Integer.valueOf(NLimit[1]);
        int[] weights = new int[N];
        int[] prices = new int[N];
        long[][] dp = new long[N+1][weightLimit+1];
        for (int i=0; i<N; i++){
            String[] inputs = bf.readLine().split((" "));
            weights[i] = Integer.valueOf(inputs[0]);
            prices[i] = Integer.valueOf(inputs[1]);
        }
        System.out.println(solve(N, dp, weightLimit, weights, prices));
    }

    public static long solve(int N, long[][] dp, int weightLimit, int[] weights, int[] prices){
        int indexItem;
        for (indexItem=0; indexItem<N; indexItem++){
            for (int curWeight=1; curWeight<=weightLimit; curWeight++){
                    dp[indexItem+1][curWeight] = dp[indexItem][curWeight];
                if (weights[indexItem]<=curWeight){
                    long one = dp[indexItem][curWeight];
                    long two = prices[indexItem] + dp[indexItem][curWeight-weights[indexItem]];
                    dp[indexItem+1][curWeight] = Math.max(one,two);
                }
            }
        }

        long max = dp[indexItem][0];
        for (int i=0; i<dp[indexItem].length; i++){
            max = Math.max(dp[indexItem][i], max);
        }
        return max;
    }
}
