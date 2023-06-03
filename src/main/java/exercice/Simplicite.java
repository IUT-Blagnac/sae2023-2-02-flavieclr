package exercice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Simplicite {
    public static List<String> solution(String str, List<Character> ordre) {

    String[] liste = str.split(" "); //creer un tableau de string dans chaque case un mot de la phrase (car on coupe apres le vide)
        List<String> mots = new ArrayList<>();

        for (String mot : liste) {
            mots.add(mot);
        }

        mots.sort(Comparator.comparingInt(a -> ordre.indexOf(a.charAt(0))));//on trie les mots en fonction de l'indice 0 de chaque mot

        return mots;
    }
}


