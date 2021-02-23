package LeetCode.ThekthLexicographicalStringofAllHappyStringsofLengthn1415;

import java.util.List;

class Solution {

    private List<String> strings;
    private int targetLength;
    private String ans;
    public static void main(String[] args){
        Solution s = new Solution();
        s.getHappyString(1,3);
    }

    public String getHappyString(int n, int k) {
        int[] left = {k};
        helper(left, -1, "", "abc", n);
        System.out.println(ans);
        return ans;
    }

    public String helper(int[] left, int lastindex, String curString, String string, int targetlength){
        if (curString.length() == targetlength){
            left[0]--;
            if (left[0] == 0){
                ans = curString;
                return curString;
            }
            return "";
        }

        for (int i=0; i<string.length(); i++){
            if (i==lastindex){
                continue;
            }
            curString += string.charAt(i);
            if (helper(left, i, curString, string, targetlength) != ""){
                return curString;
            }
            curString = curString.substring(0, curString.length()-1);
        }
        return "";
    }
}
