package LeetCode.IteratorforCombination1286;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    private List<String> combs = new ArrayList<>();
    private String string;
    private int targetLength;
    private int combindex=0;

    /*
    ["CombinationIterator","hasNext","next","next","hasNext","next","hasNext","next","hasNext","next","next"]
[["ahijp",2],[],[],[],[],[],[],[],[],[],[]]
     */
    public static void main(String[] args){
        CombinationIterator iter = new CombinationIterator("ahijp", 2);
        System.out.println(iter.next());
//        iter.generateCombs(iter.targetLength, iter.string, "", 0);
        System.out.println(iter.next());
    }
    public CombinationIterator(String characters, int combinationLength) {
        string = characters;
        targetLength = combinationLength;
        generateCombs(targetLength, string, "", 0);
    }

    public void generateCombs(int targetLength, String string, String curString, int startIndex){
        if (curString.length() == targetLength){
            combs.add(curString);
            return;
        }

        for (int i=startIndex; i<string.length(); i++){
            curString += string.charAt(i);
            generateCombs(targetLength, string, curString, i+1);
            curString = curString.substring(0, curString.length()-1);
        }
    }
    public String next() {
        if (combindex < combs.size()){
            String toRet = combs.get(combindex);
            combindex++;
            return toRet;
        }
        return "";
    }

    public boolean hasNext() {
        return combindex < combs.size();
    }
}
