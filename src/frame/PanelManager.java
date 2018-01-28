package frame;

import motion.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelManager implements ChangeListener, ActionListener{

    private String[] combobox_lave = {"ペン", "直線", "三角形", "消しゴム"};

    private JFrame frame;
    private JPanel panel;
    private JSlider slider = new JSlider();
    private JLabel label = new JLabel();
    private JComboBox comboBox = new JComboBox(combobox_lave);
    private JButton button = new JButton();
    private MousePaintListener mousePaintListener;

    private Graphics2D g2d;

    PanelManager(){
    }

    public void setPanelManager(JFrame frame, JPanel panel, int width, int height, MousePaintListener mousePaintListener, Graphics g){
        this.frame = frame;
        this.panel = panel;
        setFrame(width, height);
        this.mousePaintListener = mousePaintListener;
        this.g2d = (Graphics2D)g;

    }
    // Frame
    public void setFrame(int width, int height){
        // JComboBox
        setJComboBox(width);
        setSlider();
//        setBotton(width);
        this.frame.setVisible(true);
        this.frame.setBounds(1000,0, width, height);
        this.frame.setLayout(new FlowLayout());
        this.frame.setResizable(false);
    }

    // Slider
    public void setSlider(){
        slider.addChangeListener(this);
        JPanel panel = new JPanel();
        panel.add(slider);
        int lave_text = slider.getValue();
        setLavel(lave_text, panel);
        System.out.println("Masager");
        this.frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    // ComboBox
    public void setJComboBox(int width){
        comboBox.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width,50));
        panel.add(comboBox);
        this.frame.getContentPane().add(panel, BorderLayout.NORTH);
    }

    // setLavel(太さ)
    public void setLavel(int a, JPanel panel){
        label.setText(String.valueOf(a));
        panel.add(label);
        this.frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

//    // Clearボタン
//    public void setBotton(int width){
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(width, 50));
//        button.setText("Clear");
//        panel.add(button);
//        button.addActionListener(this);
//        this.frame.getContentPane().add(panel,BorderLayout.SOUTH);
//
//    }

    // changeリスナー
    // 線の太さ変更
    public void stateChanged(ChangeEvent e){
        label.setText(String.valueOf(slider.getValue()));
    }

    // mode選択
    @Override
    public void actionPerformed(ActionEvent e) {
//        JButton btn = (JButton)e.getSource();
//
//        if(btn.getText().compareTo("Clear") == 0){
//            mousePaintListener.Clear(this.panel);
//            this.frame.getContentPane().add(panel);
//        }
        // pen
        if(comboBox.getSelectedIndex() == 0) {
            g2d.setColor(g2d.getColor());
            this.mousePaintListener.countSet(0);
            mousePaintListener.setCash_color(false);
        }
        // 直線
        else if(comboBox.getSelectedIndex() == 1) {
            g2d.setColor(g2d.getColor());
            this.mousePaintListener.countSet(2);
            mousePaintListener.setCash_color(false);
        }
        // 三角形
        else if(comboBox.getSelectedIndex() == 2) {
            g2d.setColor(g2d.getColor());
            this.mousePaintListener.countSet(3);
            mousePaintListener.setCash_color(false);
        }

        // 消しゴム
        else if(comboBox.getSelectedIndex() == 3) {
            this.mousePaintListener.countSet(0);
            mousePaintListener.setCash_color(false);
            g2d.setColor(panel.getBackground());
        }

    }

    // setter
    public void setGraphics(Graphics2D g2d){
        this.g2d = g2d;
    }

    // getter
    // JSlider
    public JSlider getSlider() {
        return slider;
    }
//
//    // JComboBox
//    public JComboBox getComboBox() {
//        return comboBox;
//    }
//
//    // setContentPane
//    public void setPanel(JPanel panel, JFrame frame){
//        Container contentPane = frame.getContentPane();
//        contentPane.add(panel, BorderLayout.NORTH);
//    }


}
