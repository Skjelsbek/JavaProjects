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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KontoOpprettelseGUI extends JFrame {

    Konto konto = new Konto();          //Objekt av klassen Konto
    public static Konto[] kontoArray;   // Lager ett array av kontoer, og blir senere tildelt konto objekter

    // Initialiserer hele GUIen
    public KontoOpprettelseGUI() {
        createUI();
        setTitle("Velkommen!");
        setSize(220, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Oppretter GUIen
    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);

        // Create label
        JLabel lVelkommen = new JLabel("Velkommen til Skjelsbek Sparebank!");        
        lVelkommen.setPreferredSize(new Dimension(208 * InnholdSjekk.multiplier(), 16 * InnholdSjekk.multiplier()));
        lVelkommen.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel lOpprettKonto = new JLabel("Venligst opprett konto.");
        lOpprettKonto.setPreferredSize(new Dimension(128 * InnholdSjekk.multiplier(), 16 * InnholdSjekk.multiplier()));
        lOpprettKonto.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel lNavn = new JLabel("Ditt navn:");
        lNavn.setPreferredSize(new Dimension(52 * InnholdSjekk.multiplier(), 16 * InnholdSjekk.multiplier()));
        lNavn.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));
        
        JLabel lPin = new JLabel("Velg PIN:");
        lPin.setPreferredSize(new Dimension(50 * InnholdSjekk.multiplier(), 16 * InnholdSjekk.multiplier()));
        lPin.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));

        // Create textfield
        JTextField tfPin = new JTextField(4);
        tfPin.setPreferredSize(new Dimension(50 * InnholdSjekk.multiplier(), 25 * InnholdSjekk.multiplier()));
        tfPin.setFont(new Font("Dialog", Font.PLAIN, 12 * InnholdSjekk.multiplier()));
        tfPin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(((Character.isDigit(c)) && (tfPin.getText().toString().length() < 4)) || (e.isControlDown()) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c == KeyEvent.VK_ESCAPE) && (Konto.count > 0)) {
                    dispose();
                    BankGUI b = new BankGUI();
                    b.setVisible(true);
                } else if (c == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });

        // Create text field
        JTextField tfNavn = new JTextField("Ola Normann");
        tfNavn.setPreferredSize(new Dimension(150 * InnholdSjekk.multiplier(), 25 * InnholdSjekk.multiplier()));
        tfNavn.setFont(new Font("Dialog", Font.PLAIN, 12 * InnholdSjekk.multiplier()));
        tfNavn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((Character.isLetter(c)) || (e.isControlDown()) || (Character.isSpace(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c == KeyEvent.VK_ESCAPE) && (Konto.count > 0)) {
                    dispose();
                    BankGUI b = new BankGUI();
                    b.setVisible(true);
                } else if (c == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });
        tfNavn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!InnholdSjekk.pin(tfPin.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "PIN kan bare inneholde tall.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (!InnholdSjekk.bokstaver(tfNavn.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Navnet kan bare inneholde bokstaver og mellomrom mellom fornavn og etternavn.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if ((tfNavn.getText().length() > 0) && (tfPin.getText().length() == 4)) {
                    if (Konto.count == 0) {
                        kontoArray = konto.opprettKontoArray();
                        kontoArray[Konto.count].setNavn(tfNavn.getText());
                        kontoArray[Konto.count].setPin(tfPin.getText());
                        dispose();
                        Konto.count++;
                        BankGUI bank = new BankGUI();
                        bank.setVisible(true);
                    } else if (Konto.count < 10) {
                        boolean check = true;
                        for (int i = 0; i < Konto.count; i++) {
                            if (tfNavn.getText().equals(kontoArray[i].eier)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            kontoArray[Konto.count].setNavn(tfNavn.getText());
                            kontoArray[Konto.count].setPin(tfPin.getText());
                            dispose();
                            Konto.count++;
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        } else {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Det finnes allerede en bruker med dette navnet!", "Feil", JOptionPane.ERROR_MESSAGE);
                            dispose();
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        }
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn navn og pin?\n Pin skal ha 4 siffer.", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tfPin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!InnholdSjekk.pin(tfPin.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "PIN kan bare inneholde tall.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (!InnholdSjekk.bokstaver(tfNavn.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Navnet kan bare inneholde bokstaver og mellomrom mellom fornavn og etternavn.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if ((tfNavn.getText().length() > 0) && (tfPin.getText().length() == 4)) {
                    if (Konto.count == 0) {
                        kontoArray = konto.opprettKontoArray();
                        kontoArray[Konto.count].setNavn(tfNavn.getText());
                        kontoArray[Konto.count].setPin(tfPin.getText());
                        dispose();
                        Konto.count++;
                        BankGUI bank = new BankGUI();
                        bank.setVisible(true);
                    } else if (Konto.count < 10) {
                        boolean check = true;
                        for (int i = 0; i < Konto.count; i++) {
                            if (tfNavn.getText().equals(kontoArray[i].eier)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            kontoArray[Konto.count].setNavn(tfNavn.getText());
                            kontoArray[Konto.count].setPin(tfPin.getText());
                            dispose();
                            Konto.count++;
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        } else {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Det finnes allerede en bruker med dette navnet!", "Feil", JOptionPane.ERROR_MESSAGE);
                            dispose();
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        }
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn navn og pin?\n Pin skal ha 4 siffer.", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create button
        JButton bFullfør = new JButton("Fullfør");
        bFullfør.setPreferredSize(new Dimension(69 * InnholdSjekk.multiplier(), 26 * InnholdSjekk.multiplier()));
        bFullfør.setFont(new Font("Dialog", Font.BOLD, 12 * InnholdSjekk.multiplier()));       
        bFullfør.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!InnholdSjekk.pin(tfPin.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "PIN kan bare inneholde tall.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if (!InnholdSjekk.bokstaver(tfNavn.getText())) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Navnet kan bare inneholde bokstaver og mellomrom mellom fornavn og etternavn.", "Feil", JOptionPane.ERROR_MESSAGE);
                } else if ((tfNavn.getText().length() > 0) && (tfPin.getText().length() == 4)) {
                    if (Konto.count == 0) {
                        kontoArray = konto.opprettKontoArray();
                        kontoArray[Konto.count].setNavn(tfNavn.getText());
                        kontoArray[Konto.count].setPin(tfPin.getText());
                        dispose();
                        Konto.count++;
                        BankGUI bank = new BankGUI();
                        bank.setVisible(true);
                    } else if (Konto.count < 10) {
                        boolean check = true;
                        for (int i = 0; i < Konto.count; i++) {
                            if (tfNavn.getText().equals(kontoArray[i].eier)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            kontoArray[Konto.count].setNavn(tfNavn.getText());
                            kontoArray[Konto.count].setPin(tfPin.getText());
                            dispose();
                            Konto.count++;
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        } else {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Det finnes allerede en bruker med dette navnet!", "Feil", JOptionPane.ERROR_MESSAGE);
                            dispose();
                            BankGUI bank = new BankGUI();
                            bank.setVisible(true);
                        }
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Husket du å skrive inn navn og pin?\n Pin skal ha 4 siffer.", "Feil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            // Bruker denne til å åpne BankGUI hvis det er opprettet 1 eller fler kontoer fra før            
            @Override
            public void windowClosing(WindowEvent e) {
                if (Konto.count > 0) {
                    dispose();
                    BankGUI b = new BankGUI();
                    b.setVisible(true);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        // Fikser layout
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;

        // Legger til komponenter i panelene
        formPanel.add(lVelkommen, c);
        c.gridy++;
        formPanel.add(lOpprettKonto, c);
        c.gridy++;
        formPanel.add(lNavn, c);
        c.anchor = GridBagConstraints.LINE_END;
        formPanel.add(tfNavn, c);

        c.gridy++;
        c.anchor = GridBagConstraints.LINE_START;
        formPanel.add(lPin, c);
        c.anchor = GridBagConstraints.LINE_END;
        formPanel.add(tfPin, c);
        mainPanel.add(bFullfør);
    }
}
