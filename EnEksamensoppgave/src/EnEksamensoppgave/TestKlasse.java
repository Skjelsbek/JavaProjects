package EnEksamensoppgave;

public class TestKlasse {
    int tall1;
    double tall2;
    String tekst;
    
    public TestKlasse(int j, double d, String tekst) {
        tall1 = j;
        tall2 = d;
        this.tekst = tekst;
    }
    
    public void skrivUtTall() {
        System.out.println("Tall1 er " + this.tall1 + ", tall2 er " + this.tall2);
        System.out.println("Summen av tall1 og tall2 er " + (this.tall1 + this.tall2));
    }
    
    public void stringBaklengs() {
        String tekstBaklengs = "";
        for (int i = this.tekst.length() - 1; i >= 0; i--) {
            tekstBaklengs += this.tekst.charAt(i);
        }
        System.out.println(tekstBaklengs);
    }
    
    public void sjekkHeltall() {
        if (this.tall1 < 0) {
            System.out.println("Heltallet er negativt, og verdien er " + tall1);
        } else {
            System.out.println("Heltallet er positivt");
        }
    }
    
    public double produkt() {
        double produkt = tall1 * tall2;
        return produkt;
    }  
}
