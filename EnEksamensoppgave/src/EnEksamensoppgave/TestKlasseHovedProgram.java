package EnEksamensoppgave;

public class TestKlasseHovedProgram {
    public static void main(String[] args) {
        TestKlasse testKlasse = new TestKlasse(-10, 22.2, "TEST");
        testKlasse.skrivUtTall();
        testKlasse.stringBaklengs();
        testKlasse.sjekkHeltall();
        System.out.println(testKlasse.produkt());
    }
}
