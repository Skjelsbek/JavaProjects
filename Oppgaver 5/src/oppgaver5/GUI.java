package oppgaver5;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    
    // Objects
    private JButton bFlip, bGetSeq, bReset;
    private JLabel lFace, lHeadCount, lTailCount, lHis, lSeq;
    private JTextField tfSeq;
    CoinStats coinstats = new CoinStats();    
    
    // Displays the GUI
    public GUI() {
        createUI();

        setTitle("Heads or tails?");
        setSize(330, 175);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    // main method
    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
    
    // Creating the GUI
    private void createUI() {
        JPanel mainPanel = new JPanel();    // Creates the main panel
        getContentPane().add(mainPanel);    // Adds the main panel

        JPanel formPanel = new JPanel(new GridBagLayout()); // Creating a form panel using GridBagLayout
        mainPanel.add(formPanel);                           // Adding the form panel to the main panel
        
        // Creating the object used to define the layout of the content
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;        
        
        // Creating buttons and adding action listeners
        bFlip = new JButton("Flip the coin!");
        bFlip.addActionListener(new ButtonFlipActionListener());
        bGetSeq = new JButton("Get sequence");
        bGetSeq.addActionListener(new ButtonGetSeqActionListener());
        bReset = new JButton("Reset");
        bReset.addActionListener(new ButtonResetActionListener());    
        
        // Creating labels
        lFace = new JLabel();
        lHeadCount = new JLabel();
        lTailCount = new JLabel();
        lHis = new JLabel();        
        lSeq = new JLabel();        
        
        // Creating text field
        tfSeq = new JTextField("Enter sequence");
        tfSeq.setPreferredSize(new Dimension(150, 25));        
        
        // Adding, positioning and anchoring all of the contents
        c.anchor = GridBagConstraints.LINE_START;
        formPanel.add(bFlip, c);
        c.gridy++;
        formPanel.add(lHeadCount, c);
        c.gridy++;
        formPanel.add(lHis, c);
        c.gridy++;    
        formPanel.add(tfSeq, c);
        c.gridy++;
        formPanel.add(lSeq, c);
        c.gridy++;
        formPanel.add(bReset, c);
        c.gridy++;
        
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        formPanel.add(lFace, c);
        c.gridy++;
        formPanel.add(lTailCount, c);
        c.gridy += 2;        
        c.anchor = GridBagConstraints.CENTER;
        formPanel.add(bGetSeq, c);
        
        lFace.setText("Face is: ");
        updateHeadCount();
        updateTailCount();
        updateHistory();
        lSeq.setText("Times the sequence is repeated: ");        
    } // End createUI method
    
    // Updates the face label
    private void updateFace() {
        String face;
        if (coinstats.getFace() == true) {
            face = "Heads";
        } else {
            face = "Tails";
        }
        lFace.setText("Face is: " + face);
    }
    
    // Updates the lHeadCount label
    private void updateHeadCount() {
        lHeadCount.setText("Heads: " + coinstats.countHeads);
    }
    
    // Updates the lTailCount label
    private void updateTailCount() {
        lTailCount.setText("Tails: " + coinstats.countTails);
    }
    
    // Updates the history label
    private void updateHistory() {
        lHis.setText("History: " + coinstats.getHistory());
    }
    
    // Updates the sequence label and clears the text field
    private void updateSequence() {
        lSeq.setText("Times the sequence is repeated: " + coinstats.getSequence(tfSeq.getText()));
        tfSeq.setText("");
    }
    
    
    // Flips the coin and update both the face and history label when the flip button is clicked
    private class ButtonFlipActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            coinstats.flipCoin();
            updateFace();
            updateHeadCount();
            updateTailCount();
            updateHistory();
        }
    }
    
    // Running updateSequence method when the getSeq button is clicked
    private class ButtonGetSeqActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateSequence();
        }
    }
    
    // Resetting everything to the starting point
    private class ButtonResetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lFace.setText("Face is:");
            coinstats.countHeads = 0;
            coinstats.countTails = 0;
            updateHeadCount();
            updateTailCount();            
            coinstats.history = "";
            updateHistory();
            lSeq.setText("Times the sequence is repeated: ");
            tfSeq.setText("Enter sequence");
        }
    }

}
