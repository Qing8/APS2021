package PS02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AyusWallMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        int nWalls = Integer.parseInt(bf.readLine());
        String[] walls = bf.readLine().split(" ");
        int totalWalls = 0;
        for (int i=0; i<nWalls; i++){
            totalWalls += Integer.valueOf(walls[i]);
        }
        int avgWalls = totalWalls / nWalls;
        int numMoves = 0;
        for (int i=0; i<nWalls; i++){
            numMoves += Math.abs(avgWalls-Integer.valueOf(walls[i]));
        }
        System.out.println("The minimum number of moves is " + numMoves/2 + ".");
    }
}
