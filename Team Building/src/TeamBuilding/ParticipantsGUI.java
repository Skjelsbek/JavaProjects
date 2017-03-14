package TeamBuilding;

import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ParticipantsGUI extends JFrame {

    private static String[] strArr;

    public ParticipantsGUI() {
        createUI();
        setTitle("Participants");
        setSize(1920 / multiplier(), 1080 / multiplier());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        JPanel layoutPanel = new JPanel(new GridBagLayout());
        mainPanel.add(layoutPanel);
        JPanel layoutPanel2 = new JPanel(new GridBagLayout());
        mainPanel.add(layoutPanel2);
        mainPanel.setFocusable(true);
        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                mainPanel.requestFocus();                
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        
        JTextArea txt = new JTextArea("Enter names, separate with ','");
        txt.setPreferredSize(new Dimension(900, 300));
        txt.setFont(new Font("Dialog", PLAIN, 20));
        txt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (txt.getText().isEmpty()) txt.setText("Enter names, separate with ','");
            }

        });
        
        txt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {                
                if (txt.getText().equals("Enter names, separate with ','")) {
                    txt.setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

        String[] teamSizeArr = {"Choose team size", "2", "3", "4", "5"};
        JComboBox c1 = new JComboBox(teamSizeArr);
        c1.setPreferredSize(new Dimension(258, 50));
        c1.setFont(new Font("Dialog", BOLD, 24));

        JButton b1 = new JButton("Ranomize!");
        b1.setPreferredSize(new Dimension(186, 52));
        b1.setFont(new Font("Dialog", BOLD, 20));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (c1.getSelectedIndex() != 0 && !txt.getText().isEmpty() && !txt.getText().equals("Enter names, separate with ','")) {
                    strArr = txt.getText().split(",");
                    new TeamsGUI(strArr, Integer.parseInt(c1.getSelectedItem().toString())).setVisible(true);
                    dispose();
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        layoutPanel.add(txt, c);
        layoutPanel2.add(b1, c);
        c.gridx++;
        layoutPanel2.add(c1, c);

    }

    public static int multiplier() {
        String scrSize = Toolkit.getDefaultToolkit().getScreenSize().toString();
        String widthString = "";
        //String hightString = "";
        for (int i = 0; i < scrSize.length(); i++) {
            if ((Character.isDigit(scrSize.charAt(i))) && (i < 30)) {
                widthString += scrSize.charAt(i);
            } //else if (Character.isDigit(scrSize.charAt(i))) {
            //hightString += scrSize.charAt(i);
            //}
        }
        int widthInt = Integer.parseInt(widthString);
        //int hightInt = Integer.parseInt(hightString);        
        int refrenceWidth = 3840;
        int multiplier = refrenceWidth / widthInt;

        return multiplier;
    }
}
