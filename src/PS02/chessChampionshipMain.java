package PS02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chessChampionshipMain {
    public static void main(String[] args) throws
            IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = bf.readLine().split(" ");
        int N = Integer.valueOf(input1[0]);
        int totalPlayers = (int) Math.pow(2, N);
        int nMissing = Integer.valueOf(input1[1]);
        int[] players = new int[totalPlayers];
        if (nMissing>0){
            String[] input2 = bf.readLine().split(" ");
            for (int i=0; i< input2.length;i++){
                players[Integer.valueOf(input2[i])-1] = -1;
            }
        }


        int walkOver = 0;
        N -= 1;
        while (N>=0){
            int[] nextPlayers = new int[(int) Math.pow(2, N)];
            for (int i=0; i<players.length; i+=2){
                if (players[i] == -1 && players[i+1] == -1){
                    nextPlayers[i/2] = -1;
                }else if (players[i] == -1 || players[i+1] == -1){
                    walkOver++;
                    nextPlayers[i/2] = 0;
                }else{
                    nextPlayers[i/2] = 0;
                }

            }
            N--;
            players = nextPlayers;
        }
        System.out.print(walkOver);


    }
}
