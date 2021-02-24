package PS04.Ferry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NTM = bf.readLine().split(" ");
        int N = Integer.valueOf(NTM[0]);
        int T = Integer.valueOf(NTM[1]);
        int M = Integer.valueOf(NTM[2]);

        String inputString;
        int curTime = 0;
        boolean atLeft = true;
        int totalOnboard = 0;

        List<Integer> leftBoats = new ArrayList<>();
        List<Integer> rightBoats = new ArrayList<>();

        while ((inputString = bf.readLine()) != null){
            String[] parsed = inputString.split(" ");
            if (parsed[1].equals("left")){
                leftBoats.add(Integer.parseInt(parsed[0]));
            }else rightBoats.add(Integer.parseInt(parsed[0]));
        }

        while (totalOnboard )
    }

}
