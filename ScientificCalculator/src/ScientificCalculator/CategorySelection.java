package ScientificCalculator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CategorySelection extends JFrame{
    private String test = "Jon tester github!";
    public CategorySelection() {
        createUI();
        setTitle("Scientific Calculator");
        setSize(670 / DefaultOperations.uiSizeDivider(), 250 / DefaultOperations.uiSizeDivider());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
    }
    
    public static void main(String[] args) {
        CategorySelection cat = new CategorySelection();
        cat.setVisible(true);
    }

    private void createUI() {
        // Adding panels
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);        
        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);
        
        // Add label
        JLabel lValg = new JLabel("Velg ønsket kategori:");
        lValg.setFont(new Font("Dialog", Font.BOLD, 36  / DefaultOperations.uiSizeDivider()));                
        
        // Add comboBox
        String[] sValg = {"Arithmetic", "Trigonometry", "Geometry", "Equations"};
        JComboBox cValg = new JComboBox(sValg);        
        cValg.setFont(new Font("Dialog", Font.BOLD, 36  / DefaultOperations.uiSizeDivider()));
        
        // Adding button and action listener
        JButton bGo = new JButton("Go");
        bGo.setFont(new Font("Dialog", Font.BOLD, 36  / DefaultOperations.uiSizeDivider()));
        bGo.setPreferredSize(new Dimension(204  / DefaultOperations.uiSizeDivider(), 84  / DefaultOperations.uiSizeDivider()));
        bGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch(cValg.getSelectedIndex()){
                    case 0: new Arithmetic().setVisible(true);                            
                            dispose();
                            break;
                    case 1: new Trigonometry();
                            dispose();
                            break;
                    case 2: new Geometry();
                            dispose();
                            break;
                    case 3: new Equation();
                            dispose();
                            break;
                    default: System.out.println("WHAT IS GOING ON HERE?!?");
                             break;
                }
            }
        });
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        formPanel.add(lValg, c);
        c.gridx++;
        formPanel.add(cValg, c);
        mainPanel.add(bGo);                
    }
}
