package Bank;

import static Bank.Konto.count;
import static Bank.KontoOpprettelseGUI.kontoArray;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StatusGUI extends JFrame {

    public StatusGUI() {
        createUI();
        setTitle("Konto oversikt");
        setSize(210, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);

        JPanel formPanel = new JPanel();
        mainPanel.add(formPanel);

        JTextArea statusArea = new JTextArea();
        DecimalFormat df = new DecimalFormat("0.00");
        statusArea.setPreferredSize(new Dimension(200, 160));
        statusArea.setEditable(false);
        statusArea.setBorder(null);
        statusArea.setBackground(null);
        for (int i = 0; i < count; i++) {
            if (i < 9) {
                statusArea.setText(statusArea.getText() + "  " + (i + 1) + ": " + kontoArray[i].eier + ": " + df.format(kontoArray[i].saldo) + "kr\n");
            } else {
                statusArea.setText(statusArea.getText() + (i + 1) + ": " + kontoArray[i].eier + ": " + df.format(kontoArray[i].saldo) + "kr\n");
            }
        }
        statusArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_ESCAPE)) {
                    dispose();
                }
            }
        });

        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        formPanel.add(statusArea);
        mainPanel.add(closeButton);
    }
}
