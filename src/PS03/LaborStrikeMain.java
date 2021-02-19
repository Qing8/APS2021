package PS03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.IntStream;

public class LaborStrikeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int NUnion = Integer.parseInt(bf.readLine());
        int[] strikePeriod = new int[NUnion];
        for (int i=0; i<NUnion; i++){
            strikePeriod[i] = Integer.parseInt(bf.readLine());
        }
        System.out.println(solve(strikePeriod, m));
    }

    public static int solve(int[] strickPeriod, int m){
        int[] totalDays = new int[m+1];
        for (int onePeriod : strickPeriod){
            int temp = onePeriod;
            while (temp <= m){
                if (temp % 7 == 6 || temp%7==0){

                }else{
                    totalDays[temp] = 1;
                }

                temp += onePeriod;
            }
        }
        return IntStream.of(totalDays).sum();
    }

//    public static int solve(int[] strikePeriod, int totalDays){
//        int noSubwaysDays = 0;
//        for (int oneUnionPeriod: strikePeriod){
//            noSubwaysDays += totalDays / oneUnionPeriod;
//            noSubwaysDays -= totalDays / LCM(oneUnionPeriod,6);
//            noSubwaysDays -= totalDays / LCM(oneUnionPeriod, 7);
//        }
//        return noSubwaysDays;
//    }

//    public static int LCM(int oneUnionPeriod, int fixDays){
//        int greater = Math.max(oneUnionPeriod, fixDays);
//        while (true){
//            if (greater%oneUnionPeriod==0 && greater%fixDays==0){
//                return greater;
//            }
//            greater++;
//        }
//    }
}
