package PS03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.BitSet;

public class TaskPlanningMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int[] numbers = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int NOneTime = numbers[0];
        int NRepetitive = numbers[1];
        if (solve(NOneTime, NRepetitive, bf) == false){
            System.out.println("CONFLICT");
        }else System.out.println("NO CONFLICT");

    }

    public static boolean solve(int NOnetime, int NRepetitive, BufferedReader bf) throws IOException{
        int INTMAX = 1000001;
        BitSet bs = new BitSet(INTMAX);
        for (int i=0; i<NOnetime; i++){
            int[] intervals = Arrays.stream(bf.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            for (int cur=intervals[0]; cur<intervals[1]; cur++){
                if (bs.get(cur) == true){
                    return false;
                }else {
                    bs.set(cur);
                }

            }
        }

        for (int j=0; j<NRepetitive; j++){
            int[] repetitives = Arrays.stream(bf.readLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            int start = repetitives[0];
            int end = repetitives[1];
            int period = repetitives[2];
            while (start<INTMAX){
                for (int i=start; i<end; i++){
                    if (bs.get(i)==true) return false;
                    bs.set(i);
                }
                end += period;
                start += period;
            }
        }
        return true;
    }
}
