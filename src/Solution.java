import java.util.ArrayList;
import java.util.List;

class Solution {
    int cnt=0;
    int[] appears = new int[26];
    public static void main(String[] args){
        Solution s = new Solution();
        String tiles = "AAB";
        for (int i=0; i<tiles.length(); i++){
            s.appears[tiles.charAt(i)-'A']++;
        }
        s.cnt = s.numTilePossibilities();
        System.out.println(s.cnt);

    }
    public int numTilePossibilities() {
        int sum = 0;
        for (int i=0; i<26; i++){
            if (appears[i] == 0) continue;
            sum++;
            appears[i]--;
            sum += numTilePossibilities();
            appears[i]++;
        }
        return sum;

    }
}