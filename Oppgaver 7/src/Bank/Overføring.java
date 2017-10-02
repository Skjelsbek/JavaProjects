package Bank;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Overføring extends JFrame {

    public Overføring() {
        createUI();
        setTitle("Overføring");
        setSize(270, 160);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createUI() {
        // Creating panels
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);

        // Create labels
        JLabel ltilKonto = new JLabel("Overfør til:");
        JLabel lfraKonto = new JLabel("Overfør fra:");
        JLabel lBeløp = new JLabel("Beløp:");

        // Create comboboxes
        String[] velgKonto = new String[Konto.count];
        for (int i = 0; i < Konto.count; i++) {
            velgKonto[i] = KontoOpprettelseGUI.kontoArray[i].eier;
        }
        JComboBox cFraKonto = new JComboBox(velgKonto);
        cFraKonto.setSelectedIndex(0);
        JComboBox cTilKonto = new JComboBox(velgKonto);
        cTilKonto.setSelectedIndex(1);

        // Create textfield
        JTextField tfBeløp = new JTextField();
        tfBeløp.setPreferredSize(new Dimension(150, 25));
        tfBeløp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || (e.isControlDown()) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });
        tfBeløp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cFraKonto.getSelectedItem() == cTilKonto.getSelectedItem()) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Sjekk om sender og mottaker er forskjellig.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (!((InnholdSjekk.antallPunktum(tfBeløp.getText())) && (InnholdSjekk.tall(tfBeløp.getText())))) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Sjekk om du har skrevet et positivt tall.\nHusk at et tall bare kan ha ett kommategn (punktum i dette tilfellet).", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (tfBeløp.getText().length() > 0) {
                    double x = Double.parseDouble(tfBeløp.getText());
                    double saldo = 0;
                    String pin = "";
                    boolean sjekkPin = false;
                    for (int i = 0; i < Konto.count; i++) {
                        if (KontoOpprettelseGUI.kontoArray[i].eier == cFraKonto.getSelectedItem().toString()) {
                            saldo = KontoOpprettelseGUI.kontoArray[i].saldo;
                            pin = JOptionPane.showInputDialog(null, KontoOpprettelseGUI.kontoArray[i].eier + "s PIN :", "PIN", JOptionPane.QUESTION_MESSAGE);
                            if (KontoOpprettelseGUI.kontoArray[i].pin.equals(pin)) {
                                KontoOpprettelseGUI.kontoArray[i].taUtPenger(x);
                                sjekkPin = true;
                                break;
                            } else if (!(pin == null || (pin != null && ("".equals(pin))))) {
                                JOptionPane.showMessageDialog(null, "Feil pin!", "Feil", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    if ((x <= saldo) && (sjekkPin)) {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == cTilKonto.getSelectedItem().toString()) {
                                KontoOpprettelseGUI.kontoArray[i].settInnPenger(x);
                                break;
                            }

                        }
                        dispose();
                        StatusGUI status = new StatusGUI();
                        status.setVisible(true);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn beløp?", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create button
        JButton bOverfør = new JButton("Overfør");
        bOverfør.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cFraKonto.getSelectedItem() == cTilKonto.getSelectedItem()) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Sjekk om sender og mottaker er forskjellig.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (!((InnholdSjekk.antallPunktum(tfBeløp.getText())) && (InnholdSjekk.tall(tfBeløp.getText())))) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Sjekk om du har skrevet et positivt tall.\nHusk at et tall bare kan ha ett kommategn (punktum i dette tilfellet).", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (tfBeløp.getText().length() > 0) {
                    double x = Double.parseDouble(tfBeløp.getText());
                    double saldo = 0;
                    String pin = "";
                    boolean sjekkPin = false;
                    for (int i = 0; i < Konto.count; i++) {
                        if (KontoOpprettelseGUI.kontoArray[i].eier == cFraKonto.getSelectedItem().toString()) {
                            saldo = KontoOpprettelseGUI.kontoArray[i].saldo;
                            pin = JOptionPane.showInputDialog(null, KontoOpprettelseGUI.kontoArray[i].eier + "s PIN :", "PIN", JOptionPane.QUESTION_MESSAGE);
                            if (KontoOpprettelseGUI.kontoArray[i].pin.equals(pin)) {
                                KontoOpprettelseGUI.kontoArray[i].taUtPenger(x);
                                sjekkPin = true;
                                break;
                            } else if (!(pin == null || (pin != null && ("".equals(pin))))) {
                                JOptionPane.showMessageDialog(null, "Feil pin!", "Feil", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    if ((x <= saldo) && (sjekkPin)) {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == cTilKonto.getSelectedItem().toString()) {
                                KontoOpprettelseGUI.kontoArray[i].settInnPenger(x);
                                break;
                            }

                        }
                        dispose();
                        StatusGUI status = new StatusGUI();
                        status.setVisible(true);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn beløp?", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        formPanel.add(lfraKonto, c);
        c.gridx++;
        formPanel.add(cFraKonto, c);
        c.gridx--;
        c.gridy++;
        formPanel.add(ltilKonto, c);
        c.gridx++;
        formPanel.add(cTilKonto, c);
        c.gridx--;
        c.gridy++;
        formPanel.add(lBeløp, c);
        c.gridy++;
        formPanel.add(tfBeløp, c);
        c.gridy++;
        mainPanel.add(bOverfør);
    }

}
