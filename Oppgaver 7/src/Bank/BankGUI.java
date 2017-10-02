package Bank;

import java.awt.Dimension;
import java.awt.Font;
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

public class BankGUI extends JFrame {

    public String[] valgmuligheter = new String[10];

    // Initialiserer BankGUIen
    public BankGUI() {
        createUI();

        setTitle("Skjelsbek Sparebank");
        setSize(310, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Oppretter GUIen
    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);

        //Create label
        JLabel valgLabel = new JLabel("Velg ønsket konto:");
        valgLabel.setPreferredSize(new Dimension(105 * InnholdSjekk.multiplier(), 16 * InnholdSjekk.multiplier()));
        valgLabel.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel enterLabel = new JLabel("Skriv inn ønsket beløp: ");
        enterLabel.setPreferredSize(new Dimension(131 * InnholdSjekk.multiplier(),16 * InnholdSjekk.multiplier()));
        enterLabel.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel kr = new JLabel("kr");
        kr.setPreferredSize(new Dimension(12 * InnholdSjekk.multiplier(),16 * InnholdSjekk.multiplier()));
        kr.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel lUtEllerInn = new JLabel("Ønsker du å ta ut eller sette inn?");
        lUtEllerInn.setPreferredSize(new Dimension(184 * InnholdSjekk.multiplier(),16 * InnholdSjekk.multiplier()));
        lUtEllerInn.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));

        //Create combo box                
        for (int i = 0; i < 10; i++) {
            valgmuligheter[i] = KontoOpprettelseGUI.kontoArray[i].eier;
        }
        JComboBox valgMeny = new JComboBox(valgmuligheter);
        valgMeny.setPreferredSize(new Dimension(102 * InnholdSjekk.multiplier(), 25 * InnholdSjekk.multiplier()));
        valgMeny.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        valgMeny.setSelectedIndex(Konto.count - 1);

        String[] sUtEllerInn = {"Inn", "Ut"};
        JComboBox cUtEllerInn = new JComboBox(sUtEllerInn);
        cUtEllerInn.setPreferredSize(new Dimension(45 * InnholdSjekk.multiplier(), 25 * InnholdSjekk.multiplier()));
        cUtEllerInn.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));

        // Create text field
        JTextField enterTf = new JTextField();
        enterTf.setPreferredSize(new Dimension(150 * InnholdSjekk.multiplier(), 25 * InnholdSjekk.multiplier()));
        enterTf.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        enterTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || (e.isControlDown()) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }
        });

        enterTf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = valgMeny.getSelectedItem().toString();
                if (!((InnholdSjekk.antallPunktum(enterTf.getText())) && (InnholdSjekk.tall(enterTf.getText())))) {
                    JOptionPane.showMessageDialog(null, "Sjekk om du har skrevet et positivt tall.\nHusk at et tall bare kan ha ett kommategn (punktum i dette tilfellet).", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (enterTf.getText().length() > 0) {
                    double x = Double.parseDouble(enterTf.getText());
                    String pin = "";
                    if ((cUtEllerInn.getSelectedItem().toString() == "Ut")) {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == s) {
                                pin = JOptionPane.showInputDialog(null, KontoOpprettelseGUI.kontoArray[i].eier + "s PIN :", "PIN", JOptionPane.QUESTION_MESSAGE);
                                if (KontoOpprettelseGUI.kontoArray[i].pin.equals(pin)) {
                                    KontoOpprettelseGUI.kontoArray[i].taUtPenger(x);
                                    StatusGUI status = new StatusGUI();
                                    status.setVisible(true);                                    
                                    break;
                                } else if (!(pin == null || (pin != null && ("".equals(pin))))) {
                                    JOptionPane.showMessageDialog(null, "Feil pin!", "Feil", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } else if (cUtEllerInn.getSelectedItem() == "Inn") {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == s) {
                                KontoOpprettelseGUI.kontoArray[i].settInnPenger(x);
                                StatusGUI status = new StatusGUI();
                                status.setVisible(true);
                                break;
                            }
                        }
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn beløp?", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create button
        JButton bUtfør = new JButton("Utfør");
        bUtfør.setPreferredSize(new Dimension(112 * InnholdSjekk.multiplier(), 26 * InnholdSjekk.multiplier()));
        bUtfør.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        bUtfør.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = valgMeny.getSelectedItem().toString();
                if (!((InnholdSjekk.antallPunktum(enterTf.getText())) && (InnholdSjekk.tall(enterTf.getText())))) {
                    JOptionPane.showMessageDialog(null, "Sjekk om du har skrevet et positivt tall.\nHusk at et tall bare kan ha ett kommategn (punktum i dette tilfellet).", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (enterTf.getText().length() > 0) {
                    double x = Double.parseDouble(enterTf.getText());
                    String pin = "";
                    if ((cUtEllerInn.getSelectedItem().toString() == "Ut")) {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == s) {
                                pin = JOptionPane.showInputDialog(null, KontoOpprettelseGUI.kontoArray[i].eier + "s PIN :", "PIN", JOptionPane.QUESTION_MESSAGE);
                                if (KontoOpprettelseGUI.kontoArray[i].pin.equals(pin)) {
                                    KontoOpprettelseGUI.kontoArray[i].taUtPenger(x);
                                    StatusGUI status = new StatusGUI();
                                    status.setVisible(true);                                    
                                    break;
                                } else if (!(pin == null || (pin != null && ("".equals(pin))))) {
                                    JOptionPane.showMessageDialog(null, "Feil pin!", "Feil", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } else if (cUtEllerInn.getSelectedItem() == "Inn") {
                        for (int i = 0; i < Konto.count; i++) {
                            if (KontoOpprettelseGUI.kontoArray[i].eier == s) {
                                KontoOpprettelseGUI.kontoArray[i].settInnPenger(x);
                                StatusGUI status = new StatusGUI();
                                status.setVisible(true);
                                break;
                            }
                        }
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn beløp?", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton bLagBruker = new JButton("Lag ny bruker");
        bLagBruker.setPreferredSize(new Dimension(112 * InnholdSjekk.multiplier(), 26 * InnholdSjekk.multiplier()));
        bLagBruker.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        bLagBruker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Konto.count < 10) {
                    dispose();
                    KontoOpprettelseGUI kontoOpprettelse = new KontoOpprettelseGUI();
                    kontoOpprettelse.setVisible(true);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Beklager! Vi ser ikke ut til å ha kapasitet til flere kontoer akkurat nå :(", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton bStatus = new JButton("Sjekk saldo");
        bStatus.setPreferredSize(new Dimension(112 * InnholdSjekk.multiplier(), 26 * InnholdSjekk.multiplier()));
        bStatus.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        bStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusGUI status = new StatusGUI();
                status.setVisible(true);
            }
        });

        JButton bOverføring = new JButton("Overfør");
        bOverføring.setPreferredSize(new Dimension(112 * InnholdSjekk.multiplier(), 26 * InnholdSjekk.multiplier())); 
        bOverføring.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        bOverføring.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Konto.count >= 2) {
                    Overføring overføring = new Overføring();
                    overføring.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Det finnes ingen kontoer å overføre til.", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        // Adding, positioning and anchoring all of the contents
        c.anchor = GridBagConstraints.LINE_START;
        formPanel.add(valgLabel, c);
        c.gridx++;
        formPanel.add(valgMeny, c);
        c.gridy++;
        c.gridx--;
        formPanel.add(lUtEllerInn, c);
        c.gridx++;
        formPanel.add(cUtEllerInn, c);
        c.gridy++;
        c.gridx--;
        formPanel.add(enterLabel, c);
        c.gridy++;
        formPanel.add(enterTf, c);
        c.anchor = GridBagConstraints.LINE_END;
        formPanel.add(kr, c);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy++;
        formPanel.add(bUtfør, c);
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx++;
        formPanel.add(bLagBruker, c);
        c.gridx--;
        c.gridy++;
        formPanel.add(bOverføring, c);
        c.gridx++;
        formPanel.add(bStatus, c);

    }
}
