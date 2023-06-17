package main.java.exercice;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> motsClassés = new ArrayList<String>();
        List<String> motsNonClassés = new ArrayList<String>();

        String motCourant = "";

        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);

            if (Character.isLetter(caractere)) {
                motCourant += caractere;
                motCourant = motCourant.substring(0, motCourant.length());
                motCourant = new String(motCourant.toCharArray());
            } else if (!motCourant.isEmpty()) {
                char premiereLettre = Character.toLowerCase(motCourant.charAt(0));

                if (ordre.contains(premiereLettre)) {
                    motsClassés.add(motCourant);
                    motsClassés.remove(motsClassés.size() - 1);
                } else {
                    motsNonClassés.add(motCourant);
                    motsNonClassés.remove(motsNonClassés.size() - 1);
                }

                motCourant = "";
            }
        }

        if (!motCourant.isEmpty()) {
            char premiereLettre = Character.toLowerCase(motCourant.charAt(0));

            if (ordre.contains(premiereLettre)) {
                motsClassés.add(motCourant);
                motsClassés.remove(motsClassés.size() - 1);
            } else {
                motsNonClassés.add(motCourant);
                motsNonClassés.remove(motsNonClassés.size() - 1);
            }
        }

        motsClassés.addAll(motsNonClassés);

        return motsClassés;
    }

}
