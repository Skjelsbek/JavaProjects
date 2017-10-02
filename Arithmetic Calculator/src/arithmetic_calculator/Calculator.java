package arithmetic_calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit;

public class Calculator extends JFrame {
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
    
    public Calculator() {
        createUI();
        setTitle("Arithmetic calculator");
        setSize(993 / DefaultOperations.uiSizeDivider(), 873 / DefaultOperations.uiSizeDivider());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createUI() {
        // Adding panels
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        JPanel formPanel = new JPanel(new GridBagLayout());
        mainPanel.add(formPanel);
        JPanel topPanel = new JPanel(new GridBagLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());

        // Adding text area
        JTextField display = new JTextField("0");
        display.setEditable(false);
        display.setBackground(Color.white);
        display.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(960 / DefaultOperations.uiSizeDivider(), 180 / DefaultOperations.uiSizeDivider()));
        Action beep = display.getActionMap().get(DefaultEditorKit.deletePrevCharAction);
        beep.setEnabled(false);
        display.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                StringBuilder sb = new StringBuilder();
                String sbString;

                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    sb.append(display.getText());
                    if (!Character.isDigit(sb.toString().charAt(sb.toString().length() - 1))) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    try {
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        display.setText(engine.eval(sb.toString()).toString());                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "WHAT IS GOING ON HERE?!?", "Feil!", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (!display.getText().isEmpty()) {
                        sb.append(display.getText());
                        sb.deleteCharAt(display.getText().length() - 1);
                        display.setText(sb.toString());
                    }
                } else {
                    switch (e.getKeyChar()) {
                        case '0':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sbString = sb.toString();
                            if (sbString.isEmpty() || sbString.charAt(sbString.length() - 1) != '0') {
                                display.setText(display.getText() + "0");
                            } else if (sbString.length() >= 2 && sbString.contains(".")) {
                                display.setText(display.getText() + "0");
                            }
                            break;
                        case '1':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "1");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "1");
                            } else {
                                display.setText(display.getText() + "1");
                            }
                            break;
                        case '2':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "2");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "2");
                            } else {
                                display.setText(display.getText() + "2");
                            }
                            break;
                        case '3':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "3");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "3");
                            } else {
                                display.setText(display.getText() + "3");
                            }
                            break;
                        case '4':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "4");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "4");
                            } else {
                                display.setText(display.getText() + "4");
                            }
                            break;
                        case '5':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "5");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "5");
                            } else {
                                display.setText(display.getText() + "5");
                            }
                            break;
                        case '6':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "6");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "6");
                            } else {
                                display.setText(display.getText() + "6");
                            }
                            break;
                        case '7':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "7");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "7");
                            } else {
                                display.setText(display.getText() + "7");
                            }
                            break;
                        case '8':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "8");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "8");
                            } else {
                                display.setText(display.getText() + "8");
                            }
                            break;
                        case '9':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sb.reverse();
                            sbString = sb.toString();
                            if (sbString.length() == 0) {
                                display.setText(display.getText() + "9");
                            } else if (sbString.length() == 1 && sbString.equals("0")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(display.getText());
                                sb2.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb2.toString() + "9");
                            } else {
                                display.setText(display.getText() + "9");
                            }
                            break;
                        case '.':
                            for (int i = display.getText().length() - 1; i >= 0; i--) {
                                if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                                    break;
                                } else {
                                    sb.append(display.getText().charAt(i));
                                }
                            }
                            sbString = sb.toString();
                            if (sbString.isEmpty()) {
                                display.setText(display.getText() + "0.");
                            } else if (!sbString.contains(".")) {
                                display.setText(display.getText() + ".");
                            }
                            break;
                        case '+':
                            if (display.getText().isEmpty()) {
                                display.setText(display.getText() + "0+");
                            } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                                StringBuilder sb1 = new StringBuilder();
                                sb1.append(display.getText());
                                sb1.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb1.toString() + "+");
                            } else {
                                display.setText(display.getText() + "+");
                            }
                            break;
                        case '-':
                            if (display.getText().isEmpty()) {
                                display.setText(display.getText() + "-");
                            } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                                StringBuilder sb1 = new StringBuilder();
                                sb1.append(display.getText());
                                sb1.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb1.toString() + "-");
                            } else {
                                display.setText(display.getText() + "-");
                            }
                            break;
                        case '*':
                            if (display.getText().isEmpty()) {
                                display.setText(display.getText() + "0*");
                            } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                                StringBuilder sb1 = new StringBuilder();
                                sb1.append(display.getText());
                                sb1.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb1.toString() + "*");
                            } else {
                                display.setText(display.getText() + "*");
                            }
                            break;
                        case '/':
                            if (display.getText().isEmpty()) {
                                display.setText(display.getText() + "0/");
                            } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                                StringBuilder sb1 = new StringBuilder();
                                sb1.append(display.getText());
                                sb1.deleteCharAt(display.getText().length() - 1);
                                display.setText(sb1.toString() + "/");
                            } else {
                                display.setText(display.getText() + "/");
                            }
                            break;
                    }
                }
            }
        });

        // Adding buttons
        JButton bBackSpace = new JButton("<--");
        bBackSpace.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bBackSpace.setPreferredSize(new Dimension(238 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bBackSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!display.getText().isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(display.getText());
                    sb.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb.toString());
                }
                display.requestFocus();
            }
        });

        JButton bClear = new JButton("C");
        bClear.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bClear.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!display.getText().isEmpty()) {
                    display.setText("");
                }
                display.requestFocus();
            }
        });

        JButton bClearEntry = new JButton("CE");
        bClearEntry.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bClearEntry.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bClearEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                sb.append(display.getText());
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.deleteCharAt(i);
                    }
                }
                display.setText(sb.toString());
                display.requestFocus();
            }
        });

        JButton b1 = new JButton("1");
        b1.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b1.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "1");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "1");
                } else {
                    display.setText(display.getText() + "1");
                }
                display.requestFocus();
            }
        });

        JButton b2 = new JButton("2");
        b2.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b2.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "2");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "2");
                } else {
                    display.setText(display.getText() + "2");
                }
                display.requestFocus();
            }
        });

        JButton b3 = new JButton("3");
        b3.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b3.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "3");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "3");
                } else {
                    display.setText(display.getText() + "3");
                }
                display.requestFocus();
            }
        });

        JButton b4 = new JButton("4");
        b4.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b4.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "4");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "4");
                } else {
                    display.setText(display.getText() + "4");
                }
                display.requestFocus();
            }
        });

        JButton b5 = new JButton("5");
        b5.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b5.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "5");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "5");
                } else {
                    display.setText(display.getText() + "5");
                }
                display.requestFocus();
            }
        });

        JButton b6 = new JButton("6");
        b6.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b6.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "6");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "6");
                } else {
                    display.setText(display.getText() + "6");
                }
                display.requestFocus();
            }
        });

        JButton b7 = new JButton("7");
        b7.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b7.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "7");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "7");
                } else {
                    display.setText(display.getText() + "7");
                }
                display.requestFocus();
            }
        });

        JButton b8 = new JButton("8");
        b8.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b8.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "8");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "8");
                } else {
                    display.setText(display.getText() + "8");
                }
                display.requestFocus();
            }
        });

        JButton b9 = new JButton("9");
        b9.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b9.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                sb.reverse();
                String sbString = sb.toString();
                if (sbString.length() == 0) {
                    display.setText(display.getText() + "9");
                } else if (sbString.length() == 1 && sbString.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(display.getText());
                    sb2.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb2.toString() + "9");
                } else {
                    display.setText(display.getText() + "9");
                }
                display.requestFocus();
            }
        });

        JButton b0 = new JButton("0");
        b0.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        b0.setPreferredSize(new Dimension(480 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                String sbString = sb.toString();
                if (sbString.isEmpty() || sbString.charAt(sbString.length() - 1) != '0') {
                    display.setText(display.getText() + "0");
                } else if (sbString.length() >= 2 && sbString.contains(".")) {
                    display.setText(display.getText() + "0");
                }
                display.requestFocus();
            }
        });

        JButton bPeriod = new JButton(".");
        bPeriod.setFont(new Font("Dialog", Font.BOLD, 64 / DefaultOperations.uiSizeDivider()));
        bPeriod.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bPeriod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                for (int i = display.getText().length() - 1; i >= 0; i--) {
                    if (display.getText().charAt(i) == '*' || display.getText().charAt(i) == '/' || display.getText().charAt(i) == '+' || display.getText().charAt(i) == '-') {
                        break;
                    } else {
                        sb.append(display.getText().charAt(i));
                    }
                }
                String sbString = sb.toString();
                if (sbString.isEmpty()) {
                    display.setText(display.getText() + "0.");
                } else if (!sbString.contains(".")) {
                    display.setText(display.getText() + ".");
                }
                display.requestFocus();
            }
        });

        JButton bPlus = new JButton("+");
        bPlus.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bPlus.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (display.getText().isEmpty()) {
                    display.setText(display.getText() + "0+");
                } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(display.getText());
                    sb1.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb1.toString() + "+");
                } else {
                    display.setText(display.getText() + "+");
                }
                display.requestFocus();
            }
        });

        JButton bMinus = new JButton("-");
        bMinus.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bMinus.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (display.getText().isEmpty()) {
                    display.setText(display.getText() + "-");
                } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(display.getText());
                    sb1.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb1.toString() + "-");
                } else {
                    display.setText(display.getText() + "-");
                }
                display.requestFocus();
            }
        });

        JButton bMultiply = new JButton("*");
        bMultiply.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bMultiply.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (display.getText().isEmpty()) {
                    display.setText(display.getText() + "0*");
                } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(display.getText());
                    sb1.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb1.toString() + "*");
                } else {
                    display.setText(display.getText() + "*");
                }
                display.requestFocus();
            }
        });

        JButton bDivide = new JButton("/");
        bDivide.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bDivide.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (display.getText().isEmpty()) {
                    display.setText(display.getText() + "0/");
                } else if (display.getText().charAt(display.getText().length() - 1) == '.' || display.getText().charAt(display.getText().length() - 1) == '*' || display.getText().charAt(display.getText().length() - 1) == '/' || display.getText().charAt(display.getText().length() - 1) == '+' || display.getText().charAt(display.getText().length() - 1) == '-') {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(display.getText());
                    sb1.deleteCharAt(display.getText().length() - 1);
                    display.setText(sb1.toString() + "/");
                } else {
                    display.setText(display.getText() + "/");
                }
                display.requestFocus();
            }
        });

        JButton bEquals = new JButton("=");
        bEquals.setFont(new Font("Dialog", Font.PLAIN, 64 / DefaultOperations.uiSizeDivider()));
        bEquals.setPreferredSize(new Dimension(240 / DefaultOperations.uiSizeDivider(), 120 / DefaultOperations.uiSizeDivider()));
        bEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringBuilder sb = new StringBuilder();
                sb.append(display.getText());
                if (!Character.isDigit(sb.toString().charAt(sb.toString().length() - 1))) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    display.setText(engine.eval(sb.toString()).toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "WHAT IS GOING ON HERE?!?", "Feil!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding components using GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        formPanel.add(display, c);
        c.gridy++;
        formPanel.add(topPanel, c);
        c.gridy++;
        formPanel.add(bottomPanel, c);
        c.gridx = 0;
        c.gridy = 0;
        topPanel.add(bClearEntry, c);
        c.gridx++;
        topPanel.add(bClear, c);
        c.gridx++;
        topPanel.add(bBackSpace, c);
        c.gridx++;
        topPanel.add(bDivide, c);
        c.gridx = 0;
        c.gridy++;
        topPanel.add(b7, c);
        c.gridx++;
        topPanel.add(b8, c);
        c.gridx++;
        topPanel.add(b9, c);
        c.gridx++;
        topPanel.add(bMultiply, c);
        c.gridx = 0;
        c.gridy++;
        topPanel.add(b4, c);
        c.gridx++;
        topPanel.add(b5, c);
        c.gridx++;
        topPanel.add(b6, c);
        c.gridx++;
        topPanel.add(bMinus, c);
        c.gridx = 0;
        c.gridy++;
        topPanel.add(b1, c);
        c.gridx++;
        topPanel.add(b2, c);
        c.gridx++;
        topPanel.add(b3, c);
        c.gridx++;
        topPanel.add(bPlus, c);
        c.gridx = 0;
        c.gridy++;
        bottomPanel.add(b0, c);
        c.gridx++;
        bottomPanel.add(bPeriod, c);
        c.gridx++;
        bottomPanel.add(bEquals, c);
    }
}
