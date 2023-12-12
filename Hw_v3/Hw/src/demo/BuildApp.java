package dsa_end.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildApp {
    private JButton button1;
    private JPanel panel1;

    public BuildApp() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BuildApp");
        frame.setContentPane(new BuildApp().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
