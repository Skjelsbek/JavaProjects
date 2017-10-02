package Kont2013Oppgave4;

import java.util.Scanner;

public class TestProgram {

    static Kontoer kontoer = new Kontoer();

    public static void main(String[] args) throws Exception {
        int counter = 1;
        Scanner scanner = new Scanner(System.in);
        String fortsettEllerLukk = "";
        while (true) {
            if (counter == 1) {
                kontoer.skrivUt();
                System.out.println("");
                innUtValgtKonto();
                System.out.println("");
                kontoer.skrivUt();
                System.out.println("");
                Thread.sleep(3000);
                counter--;
            } else {
                System.out.println("ønsker du å fortsette eller vil du lukke applikasjonen? ('fortsett' eller 'lukk')");
                fortsettEllerLukk = scanner.nextLine();
                while (!(fortsettEllerLukk.toLowerCase().equals("fortsett") || fortsettEllerLukk.toLowerCase().equals("lukk"))) {
                    System.out.println("ønsker du å fortsette eller vil du lukke applikasjonen? ('fortsett' eller 'lukk')");
                    fortsettEllerLukk = scanner.nextLine();
                }
                if (fortsettEllerLukk.toLowerCase().equals("lukk")) {
                    break;
                } else {
                    innUtValgtKonto();
                    System.out.println("");  
                    kontoer.skrivUt();
                    System.out.println("");                    
                    Thread.sleep(3000);
                }
            }
        }
    }

    public static void innUtValgtKonto() {
        Scanner scanner = new Scanner(System.in);
        boolean innEllerUt = innEllerUt();
        int index = velgKonto(innEllerUt);

        if (innEllerUt) {
            System.out.println("Hvor mye ønsker du å sette inn?");
            kontoer.kontoArray[index].settInn(scanner.nextDouble());
        } else {
            System.out.println("Hvor mye ønsker du å ta ut?");
            kontoer.kontoArray[index].taUt(scanner.nextDouble());
        }
    }

    public static boolean innEllerUt() {
        String innEllerUt;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Ønsker du å sette inn eller ta ut? (Skriv 'inn' for å sette inn, og 'ut' for å ta ut).");
        innEllerUt = scanner1.nextLine().toLowerCase();
        while (!(innEllerUt.equals("inn") || innEllerUt.equals("ut"))) {
            System.out.println("Ønsker du å sette inn eller ta ut? (Skriv 'inn' for å sette inn, og 'ut' for å ta ut).");
            innEllerUt = scanner1.nextLine().toLowerCase();
        }
        if (innEllerUt.equals("inn")) {
            return true;
        } else {
            return false;
        }
    }

    private static int velgKonto(boolean innEllerUt) {
        String navn;
        int index = 0;
        int i = 1;
        Scanner scanner2 = new Scanner(System.in);
        if (innEllerUt) {
            while (i != index) {
                System.out.println("Skriv navnet på eieren av kontoen du ønsker å sett inn på:");
                navn = scanner2.nextLine();

                for (int j = 0; j < kontoer.navnArray.length; j++) {
                    if (kontoer.navnArray[j].toLowerCase().equals(navn.toLowerCase())) {
                        index = j;
                        i = j;
                    }
                }
            }
        } else {
            while (i != index) {
                System.out.println("Skriv navnet på eieren av kontoen du ønsker å ta ut fra:");
                navn = scanner2.nextLine();

                for (int j = 0; j < kontoer.navnArray.length; j++) {
                    if (kontoer.navnArray[j].toLowerCase().equals(navn.toLowerCase())) {
                        index = j;
                        i = j;
                    }
                }
            }
        }
        return index;
    }
}
