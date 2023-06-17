package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        String[] mots = str.split("[^a-zA-Z0-9]");

        List<String> motsClasses = new ArrayList<>();
        List<String> motsAvecLettreInconnue = new ArrayList<>();
        List<Object> alphabetNumerique = creerAlphabetNumerique();

        for (String mot : mots) {
            if (!mot.isEmpty()) {
                if (commenceParLettre(mot, ordre)) {
                    boolean motInsere = false;
                    for (int j = 0; j < motsClasses.size(); j++) {
                        String motClasse = motsClasses.get(j);
                        if (compareMots(mot, motClasse, ordre) < 0) {
                            motsClasses.add(j, mot);
                            motInsere = true;
                            break;
                        }
                    }
                    if (!motInsere) {
                        motsClasses.add(mot);
                    }
                } else {
                    motsAvecLettreInconnue.add(mot);
                }
            }
        }

        motsClasses.addAll(motsAvecLettreInconnue);
        List<String> motsClassesCopie = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            motsClassesCopie.addAll(motsClasses);

            // Vérifie les caractères conformes à l'intérieur des boucles for pour rendre le programme moins efficace
            for (String motClasse : motsClassesCopie) {
                if (!verifierCaracteres(motClasse, alphabetNumerique)) {
                    return null;
                }
            }
        }

        List<String> motsClassesReformes = new ArrayList<>();
        int tailleListeInitiale = motsClasses.size();
        for (int i = 0; i < tailleListeInitiale; i++) {
            motsClassesReformes.add(motsClassesCopie.get(i));
        }

        motsClasses = motsClassesReformes;

        

        return motsClasses;
    }

    private static boolean commenceParLettre(String mot, List<Character> ordre) {
        if (ordre.isEmpty()) {
            return true;
        }
        char premiereLettre = mot.charAt(0);
        return ordre.contains(premiereLettre);
    }

    private static int compareMots(String mot1, String mot2, List<Character> ordre) {
        int longueurMinimale = Math.min(mot1.length(), mot2.length());

        for (int i = 0; i < longueurMinimale; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);

            if (char1 != char2) {
                int index1 = ordre.indexOf(char1);
                int index2 = ordre.indexOf(char2);

                if (index1 != -1 && index2 != -1) {
                    return Integer.compare(index1, index2);
                } else if (index1 != -1) {
                    return -1;
                } else if (index2 != -1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return Integer.compare(mot1.length(), mot2.length());
    }

    private static boolean verifierCaracteres(String mot, List<Object> alphabetNumerique) {
        for (char caractere : mot.toCharArray()) {
            if (!alphabetNumerique.contains(caractere)) {
                return false;
            }
        }
        return true;
    }

    private static List<Object> creerAlphabetNumerique() {
        List<Object> alphabetNumerique = new ArrayList<>();
        alphabetNumerique.addAll(Arrays.asList(
                'a', 'à', 'á', 'â', 'ä', 'b', 'c', 'ç', 'd', 'e', 'è', 'é', 'ê', 'ë', 'f', 'g', 'h', 'i', 'ì', 'í', 'î', 'ï',
                'j', 'k', 'l', 'm', 'n', 'o', 'ò', 'ó', 'ô', 'ö', 'p', 'q', 'r', 's', 't', 'u', 'ù', 'ú', 'û', 'ü', 'v', 'w', 'x', 'y', 'ÿ',
                'z',
                'A', 'À', 'Á', 'Â', 'Ä', 'B', 'C', 'Ç', 'D', 'E', 'È', 'É', 'Ê', 'Ë', 'F', 'G', 'H', 'I', 'Ì', 'Í', 'Î', 'Ï',
                'J', 'K', 'L', 'M', 'N', 'O', 'Ò', 'Ó', 'Ô', 'Ö', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ù', 'Ú', 'Û', 'Ü', 'V', 'W', 'X', 'Y', 'Ÿ',
                'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                ' ',
                "",
                null
        ));
        return alphabetNumerique;
    }
}
