package motion;

import frame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.*;

public class MenuListener implements ActionListener {

    private JFrame frame;
    private Graphics g;
    private MousePaintListener mousePaintListener;

    // Constructor
    public MenuListener(JFrame frame,  Graphics g, MousePaintListener mousePaintListener){
        this.frame = frame;
        this.g = g;
        this.mousePaintListener = mousePaintListener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JMenuItem a = (JMenuItem)e.getSource();

        // パレットの選択
        if(a.getText().compareTo("パレット") == 0){
            mousePaintListener.setCash_color(false);
            ColorPalette();
        }

        // Rainbowの選択
        else if(a.getText().compareTo("Rainbow") == 0){
            mousePaintListener.setCashColor(g.getColor());
            mousePaintListener.setCash_color(true);
        }

        // 実装追いつかなかった
        else if(a.getText().compareTo("Load") == 0){
            JOptionPane.showMessageDialog(this.frame, "そんな機能ないよ!", "エラーコード：x04i1", ERROR_MESSAGE);
        }
        else if(a.getText().compareTo("Save") == 0){
            JOptionPane.showMessageDialog(this.frame, "Saveはスクリーンショットで!","Warning", WARNING_MESSAGE);
        }

        // システム
        // About
        else if(a.getText().compareTo("About") == 0){
            JOptionPane.showMessageDialog(this.frame, "これは実装が追いつかなさすぎたソフトです．\n特にこれと言った機能はありません．\n\n\n\n\n (c) 2017 trompot","About", PLAIN_MESSAGE);
        }
        // 終了
        else if(a.getText().compareTo("Quit") == 0){
            JOptionPane.showMessageDialog(this.frame, "Applicationの終了","Quit", INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    // パレット
    public void ColorPalette(){
        JColorChooser colorchooser = new JColorChooser();

        Color color = colorchooser.showDialog(this.frame, "パレッド", Color.black);

        if(color != null){
            this.g.setColor(color);
        }
    }

}
