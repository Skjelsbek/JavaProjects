package TeamBuilding;

import static TeamBuilding.ParticipantsGUI.multiplier;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TeamsGUI extends JFrame {
    private String[] strArr;
    private int teamSize;
    
    public TeamsGUI(String[] strArr, int teamSize) {
        this.strArr = strArr;
        rndArray(this.strArr);
        this.teamSize = teamSize;
        createUI();
        setTitle("Teams");
        setSize(1920 / multiplier(), 1080 / multiplier());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);
        
        JTextArea txt = new JTextArea();
        txt.setPreferredSize(new Dimension(900, 300));
        txt.setFont(new Font("Dialog", PLAIN , 20));
        txt.setBorder(null);
        txt.setBackground(null);
        txt.setEditable(false);        
        
        for (int i = 0; i < strArr.length/teamSize; i++) {
            txt.append("Team " + (i + 1) + "\t");
        }
        txt.append("\n");
        int counter = 0;
        for (int i = 0; i < teamSize; i++) {
            for (int j = 0; j < strArr.length/teamSize; j++) {
                txt.append(strArr[j+counter] + "\t");                              
            }
            txt.append("\n");
            counter += strArr.length/teamSize;
        }
        
        
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        formPanel.add(txt, c);
    }
        
    public void rndArray(String[] org_array){
        Random rnd = new Random();
        String[] new_array = new String[org_array.length];
        System.arraycopy(org_array, 0, new_array, 0, org_array.length);
        
        int rnd_index = 0;
        int array_length = org_array.length;
        int org_index = 0;
        
        while (array_length > 0){
            rnd_index = rnd.nextInt(array_length);
            org_array[org_index] = new_array[rnd_index];
            shortenArray(new_array,rnd_index);
            org_index++;
            array_length--;
        }
    }
    
    public void shortenArray(String[] array, int index){
        for (int i=index; i<array.length-1; i++){
            array[i] = array[i+1];
        }
    }
}
