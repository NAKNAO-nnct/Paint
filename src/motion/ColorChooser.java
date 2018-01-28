package motion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    JColorChooser colorChooser;

    public ColorChooser(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        JColorChooser colorchooser = new JColorChooser();

        Color color = colorchooser.showDialog(this.frame, "色の選択", Color.white);

        if(color != null){
            panel.setBackground(color);
        }
    }


}
