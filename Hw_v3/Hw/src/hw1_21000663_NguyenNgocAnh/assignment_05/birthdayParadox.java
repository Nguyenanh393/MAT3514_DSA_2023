package hw1_21000663_NguyenNgocAnh.assignment_05;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class birthdayParadox extends JFrame {

    private JPanel MainPanel;
    private JTextField numberOfPeople;
    private JButton inputButton;
    private JLabel inputNumberOfPeople;
    private JLabel inputGuide;

    public birthdayParadox() {
        setContentPane(MainPanel);
        setTitle("Birthday Paradox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numOfPeople = numberOfPeople.getText();
                int num = Integer.parseInt(numOfPeople);
                JOptionPane.showMessageDialog(birthdayParadox.this, String.format("Probability: %.8f", birthdayProbalityCalc(num)));
            }
        });
    }
    Double birthdayProbalityCalc(int numOfPeople) {
        double pro = 1;
        for (int i = 0; i < numOfPeople; i++) {
            pro *= ((double) (365-i))/365;
        }
        return pro;
    }
}
