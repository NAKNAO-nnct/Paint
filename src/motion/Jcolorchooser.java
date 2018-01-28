package motion;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Jcolorchooser extends JFrame implements ActionListener{

    JPanel panel;

    public static void main(String[] args){
        Jcolorchooser frame = new Jcolorchooser();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 300, 200);
        frame.setTitle("タイトル");
        frame.setVisible(true);
    }

    Jcolorchooser(){
        JButton button = new JButton("color");
        button.addActionListener(this);

        panel = new JPanel();
        panel.add(button);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        JColorChooser colorchooser = new JColorChooser();

        Color color = colorchooser.showDialog(this, "色の選択", Color.white);

        if(color != null){
            panel.setBackground(color);
        }
    }
}