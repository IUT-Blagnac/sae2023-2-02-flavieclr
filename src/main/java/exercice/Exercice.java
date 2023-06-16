package exercice;

import java.util.Arrays;
import java.util.List;

public class Exercice {


    public static List<String> solution(String str, List<Character> ordre) {
        String[] mots = str.split("[^a-zA-Z0-9]+");
        int longueur = mots.length;

        for (int i = 0; i < longueur - 1; i++) {
            for (int j = 0; j < longueur - i - 1; j++) {
                if (compare(mots[j], mots[j + 1], ordre) > 0) {
                    String temporaire = mots[j];
                    mots[j] = mots[j + 1];
                    mots[j + 1] = temporaire;
                }
            }
        }

        return Arrays.asList(mots);
    }

    public static int compare (String chaine1, String chaine2, List<Character> ordre){
        int position1;
        int position2; 

        if (chaine1.equals(chaine2)){
            return 0;
        }
        if (chaine1.equals("")){
            return -1;
        }
        if (chaine2.equals("")){
            return 1;
        }
        if (chaine1.charAt(0)==(chaine2.charAt(0))){
            return compare(chaine1.substring(1),chaine2.substring(1), ordre);
        }

        position1 = getPosition(ordre, chaine1.charAt(0));
        position2 = getPosition(ordre, chaine2.charAt(0));
        
        if (position1 == -1 && position2 != -1){
            return 1;
        }
        if (position2 == -1){
            return -1;
        }
        if ( position1 > position2 ){
            return 1;
        }
        else {
            return -1;
        }
    }


    public static int getPosition(List<Character> ordre, char lettre) {
        return ordre.indexOf(lettre);
    }


}
