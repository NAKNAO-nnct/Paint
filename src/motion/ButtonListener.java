package motion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonListener implements ActionListener{
    private JFrame frame;
    private Graphics g;
    private Version_log_point log;
    private MousePaintListener MousePain;

    // コンストラクタ
    public ButtonListener(JFrame frame, Graphics g, Version_log_point log, MousePaintListener MousePain) {
        this.frame = frame;
        this.g = g;
        this.log = log;
        this.MousePain = MousePain;
    }

    // ボタン判定
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
    }


}