import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    class boatInfo{
        public int index;
        public int time;
        public boatInfo(int index, int time){
            this.index =index;
            this.time = time;
        }

    }
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NTM = bf.readLine().split(" ");
        int N = Integer.valueOf(NTM[0]);
        int T = Integer.valueOf(NTM[1]);
        int M = Integer.valueOf(NTM[2]);

        String inputString;
        int curTime = 0;
        boolean atLeft = true;
        int totalOnboard = 0;

        Queue<boatInfo> leftBoats = new LinkedList<>();
        Queue<boatInfo> rightBoats = new LinkedList<>();
        int[] times = new int[M];
        int index = 0;
        while ((inputString = bf.readLine()) != null){
            String[] parsed = inputString.split(" ");
            if (parsed[1].equals("left")){
                leftBoats.add(m.new boatInfo(index, Integer.parseInt(parsed[0])));
            }else rightBoats.add( m.new boatInfo(index, Integer.parseInt(parsed[0])));
            index++;
        }

        int popped = 0;
        boatInfo bi = null;
//        String inputString;
//        int time=0;
//        while ((inputString = bf.readLine()) != null)
        while (totalOnboard < M)
        {
//            String[] parsedString = inputString.split(" ");
//            time = Integer.valueOf(parsedString[0]);

            if (atLeft == true){
                popped = 0;
                while (!leftBoats.isEmpty() && leftBoats.peek().time <= curTime && popped <= N){
                    bi = leftBoats.poll();
                    popped++;
                    times[bi.index] = curTime+T;
                    totalOnboard++;
                }

                if (popped != 0 || rightBoats.peek().time<=curTime){
                    atLeft = false;
                    curTime += T;
                }else{
                    if (leftBoats.peek().time <= rightBoats.peek().time){
                        curTime = leftBoats.peek().time;

                    }else {
                        curTime = Math.max(rightBoats.peek().time, curTime+T);

                    }
                }

            }else{
                popped = 0;
                while (!rightBoats.isEmpty() && rightBoats.peek().time <= curTime && popped <= N){
                    bi = rightBoats.poll();
                    popped++;
                    times[bi.index] = curTime+T;
                    totalOnboard++;
                }

                if (popped != 0 || leftBoats.peek().time<=curTime){
                    atLeft = true;
                    curTime += T;
                }else{
                    if (rightBoats.peek().time <= leftBoats.peek().time){
                        curTime = rightBoats.peek().time;

                    }else {
                        curTime = Math.max(leftBoats.peek().time, curTime+T);
                    }
                }
            }
        }
        for (int i:times){
            System.out.println(i);
        }
    }

}
