package LeetCode.ThekthLexicographicalStringofAllHappyStringsofLengthn1415;

import java.util.List;

class Solution {

    private List<String> strings;
    private int targetLength;
    private String ans;
    public static void main(String[] args){
        Solution s = new Solution();
        s.getHappyString(3,1);
    }

    public String getHappyString(int n, int k) {
        helper(k, -1, "", "abc", n);
        System.out.println(ans);
        return ans;
    }

    public String helper(int left, int lastindex, String curString, String string, int targetlength){
        if (curString.length() == targetlength){
            left--;
        }

        if (left == 0){
            ans = curString;
            return curString;
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
