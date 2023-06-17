package exercice;

import java.util.*;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> words = extractWords(str);
        customSort(words, ordre);
        return words;
    }
    
    private static List<String> extractWords(String str) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                word.append(c);
            } else if (word.length() > 0) {
                words.add(word.toString());
                word.setLength(0);
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words;
    }
    
    private static void customSort(List<String> words, List<Character> ordre) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (compareWords(words.get(i), words.get(j), ordre) > 0) {
                    String temp = words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, temp);
                }
            }
        }
    }
    
    private static int compareWords(String a, String b, List<Character> ordre) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            char charA = Character.toLowerCase(a.charAt(i));
            char charB = Character.toLowerCase(b.charAt(i));
            int indexA = ordre.indexOf(charA);
            int indexB = ordre.indexOf(charB);
            if (indexA != indexB) {
                return Integer.compare(indexA, indexB);
            }
        }
        return Integer.compare(a.length(), b.length());
    }
    
}