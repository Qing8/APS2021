package PS04.AlbertsDream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string;
        List<String> stringBag = new ArrayList<>();
        while((string=bf.readLine()) != null){
            string = string.replaceAll("[^a-zA-Z ]", " ").trim().replaceAll(" +", " ").toLowerCase();
            String[] words = string.split(" ");
            for (String w:words){
                if (!stringBag.contains(w)){
                    stringBag.add(w);
                }
            }
        }
        Collections.sort(stringBag);
        for (int i=0; i<stringBag.size(); i++){
            System.out.println(stringBag.get(i));
        }
    }
}
