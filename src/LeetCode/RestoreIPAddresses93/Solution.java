package LeetCode.RestoreIPAddresses93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        String s = "010010";
        Solution sol = new Solution();
        List<String> ans = sol.restoreIpAddresses(s);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, ans, 4, "", 0);
        System.out.println(Arrays.asList(ans));
        return ans;
    }

    public void helper(String string, List<String> ans, int addrLeft, String curString, int startIndex){
        if (string.length()-startIndex > 3*addrLeft){
            return;
        }
        if (addrLeft == 0){
            curString = curString.substring(0, curString.length()-1);
            ans.add(curString);
            return;
        }
        for (int length=1; length<=3; length++){
            if (startIndex+length > string.length()) continue;

            String smallAddr = string.substring(startIndex, startIndex+length);
            if (smallAddr.length() >= 2 && smallAddr.charAt(0)=='0') continue;
            if (Integer.valueOf(smallAddr) <= 255 && 0<= Integer.valueOf(smallAddr)){

                curString += smallAddr + ".";
                helper(string, ans, addrLeft-1, curString, startIndex+length);
                curString = curString.substring(0, curString.length()-smallAddr.length()-1);
            }


        }
    }
}
