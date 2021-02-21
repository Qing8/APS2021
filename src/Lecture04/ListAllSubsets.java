package Lecture04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListAllSubsets {
    public static void main(String[] args){
        List<List<Integer>> superset = new ArrayList<>();
        int[] allNumbers = IntStream.rangeClosed(1,6).toArray();
        for (int length=1; length<=allNumbers.length; length++){
            generate(superset, length, new ArrayList<Integer>(), 0, allNumbers);
        }
    }

    public static void generate(List<List<Integer>> superset, int length, List<Integer> curSet, int startIndex, int[] allNumbers){
        if (curSet.size() == length){
            superset.add(new ArrayList<>(curSet));
            System.out.println("current set is: " + curSet.toString());

            return;
        }
        for (int i=startIndex; i<allNumbers.length; i++){
            curSet.add(allNumbers[i]);
            generate(superset, length, curSet, i+1, allNumbers);
            curSet.remove(curSet.size()-1);
        }
    }
}
