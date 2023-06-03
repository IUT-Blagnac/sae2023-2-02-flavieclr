package exercice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {

    String[] liste = str.split(" "); //creer un tableau de string dans chaque case un mot de la phrase (car on coupe apres le vide)
        List<String> mots = new ArrayList<>();

        for (String mot : liste) {
            mots.add(mot);
        }

        Collections.sort(mots, new Comparator<String>() {
           

            public int compare(String mot1, String mot2) {
                char c1 = mot1.charAt(0); //on redivise l'indice 0 apres chaque caractere 
                char c2 = mot2.charAt(0);

                return Integer.compare(ordre.indexOf(c1), ordre.indexOf(c2));
            }
        });

        return mots;
    }
}


