package mian;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class comment extends JFrame {


    /**
     * Create the frame.
     */
    public comment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("评论");
        setBounds(100, 100, 660, 470);
        JPanel contentPane = new JPanel();
        contentPane.setForeground(Color.CYAN);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField textField;
        textField = new JTextField("JDBC");
        textField.setBounds(10, 289, 625, 115);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("评论");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 250, 240, 70);
        contentPane.add(lblNewLabel);

        JTextArea textArea;
        textArea = new JTextArea("");
        textArea.setBounds(10, 10, 625, 250);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("输入");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
        btnNewButton.setBounds(539, 406, 95, 25);
        contentPane.add(btnNewButton);
    }
}
