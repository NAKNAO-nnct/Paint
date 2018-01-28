package motion;


import frame.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;


public class MousePaintListener implements MouseInputListener{
    private Version_log_point log;
    private Graphics2D g2d;

    // カウンタ変数
    private int count = 0;
    private int final_counter = 0;

    private int xa, ya;

    // カラー
    private boolean cash_color;
    private float Rainbow;
    private Color cashColor;

    private PanelManager panelManager;

    // コンストラクタ
    public MousePaintListener(){
    }

    // subコンストラクタ
    public void subMousePaintListener(Graphics g, Version_log_point log, PanelManager panelManager){
        this.log = log;
        this.g2d = (Graphics2D)(g);
        this.g2d.setColor(new Color(0, 0, 0));
        this.panelManager = panelManager;
        this.cash_color = false;
        this.Rainbow = 0f;

        panelManager.getSlider().getValue();
        BasicStroke wideStroke = new BasicStroke((float)(panelManager.getSlider().getValue())/10);
        g2d.setStroke(wideStroke);

    }

    // カウンタ
    // n角形の時,n+1をカウンタに代入しカウンタが1になればdrawLineする
    public void countSet(int n){
        this.final_counter = n;
        this.count = n+1;
    }
    public void countStart(){
        if(this.final_counter <= 0)
            return;
        else {
            this.count -= 1;
            if (this.count <= 1) {
                Line_draw(this.final_counter);
                this.count = this.final_counter + 1;
            }
        }
    }

    // 直線引く
    public void Line_draw(int a){
        g2d.drawPolygon(log.getX(a), log.getY(a), a);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        log.version_log_point(e.getX(), e.getY());
        countStart();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 線を引く
        xa = e.getX();
        ya = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        // Rainbow実装
        if(this.cash_color){
            Color color = Color.getHSBColor(this.Rainbow, 1.0f, 1.0f);
            g2d.setColor(color);
            this.Rainbow += 0.01f;
        }

        panelManager.getSlider().getValue();
        BasicStroke wideStroke = new BasicStroke((float)(panelManager.getSlider().getValue())/10);
        g2d.setStroke(wideStroke);
        this.g2d.drawLine(e.getX(), e.getY(), xa, ya);
        // 座標保持
        xa = e.getX();
        ya = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }


//    // Clear
//    public void Clear(JPanel panel){
//        g2d.clearRect(0,0, panel.getWidth(), panel.getHeight());
//        panel.setBackground(Color.white);
//    }

    // setter
    // 虹色
    public void setCash_color(boolean cash_color) {
        this.cash_color = cash_color;
        if(cash_color != true){
            this.g2d.setColor(this.cashColor);
        }else{
            this.Rainbow = 0f;
        }
    }

    // 色を保持
    public void setCashColor(Color color){
        this.cashColor = color;
    }

    // getter
    public Color getColor() {
        return g2d.getColor();
    }


}
