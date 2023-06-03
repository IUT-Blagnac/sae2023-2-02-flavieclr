package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Efficacite {
    public static List<String> solution(String str, List<Character> ordre) {
        String[] split = str.split(" ");
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < ordre.size(); i++) {
            charIndexMap.put(ordre.get(i), i);
        }

        List<String> mots = new ArrayList<>();
        for (String mot : split) {
            mots.add(mot);
        }

        mots.sort((mot1, mot2) -> {
            int minLen = Math.min(mot1.length(), mot2.length());
            for (int i = 0; i < minLen; i++) {
                char c1 = mot1.charAt(i);
                char c2 = mot2.charAt(i);
                if (c1 != c2) {
                    return Integer.compare(charIndexMap.get(c1), charIndexMap.get(c2));
                }
            }
            return Integer.compare(mot1.length(), mot2.length());
        });

        return mots;
    }
}

