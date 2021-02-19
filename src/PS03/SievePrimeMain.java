package PS03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SievePrimeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int upperLimit = Integer.parseInt(bf.readLine());
        System.out.println(solve(upperLimit));
    }

    public static int solve(int upperLimit){
        int cnt=0;
        int[] sieve = new int[upperLimit+1];
        Arrays.fill(sieve,1);
        sieve(sieve, upperLimit);

        for (int i=11; i<=upperLimit; i=i+10){
            if (sieve[i]==1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void sieve(int[] sieve, int upperLimit){
        sieve[0] = 0;
        sieve[1] = 0;

        int i=2;
        while (i*i <= upperLimit){
            if (sieve[i] == 0){
                i++;
                continue;
            }
            int j = 2 * i;

            while (j<upperLimit){
                sieve[j] = 0;
                j += i;
            }
            i++;
        }
    }
}
