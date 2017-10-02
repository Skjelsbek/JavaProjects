package Bank;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Konto {

    public static int count = 0;
    public String eier = "";
    public String pin = "";
    public double saldo = 0;

    // Setter navnet til eieren
    public void setNavn(String tekst) {
        eier = tekst;
    }

    public void setPin(String tekst) {
        pin = tekst;
    }

    // Setter inn penger
    public void settInnPenger(double verdi) {
        saldo += verdi;
    }

    // Tar ut penger
    public void taUtPenger(double verdi) {
        // Trekker fra valgt sum penger fra konto, men ikke hvis du prøver å trekke fra mer enn det some er på kontoen
        if (dekning(verdi)) {
            saldo -= verdi;
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Du har ikke nok penger på konto :(", "Feil", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Sjekker om det er dekning for å ta ut valgt verdi
    public boolean dekning(double verdi) {
        if (saldo < verdi) {
            return false;
        } else {
            return true;
        }
    }

    // Oppretter konto arrayet
    public Konto[] opprettKontoArray() {
        Konto[] kontoArray = new Konto[10];
        for (int i = 0; i < 10; i++) {
            kontoArray[i] = new Konto();
        }
        return kontoArray;
    }
}
