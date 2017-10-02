package EnEksamensoppgave;

public class SkrivUt {
    public static void main(String[] args) {
        utskrift("Jon", "Ola");
    }
    private static void utskrift(String mittNavn, String naboNavn) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Jeg heter " + mittNavn + " og naboen min heter " + naboNavn + "!");            
        }
    }
}
