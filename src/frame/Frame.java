package frame;

import motion.*;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class Frame {

    // フレーム作成
    public Frame(String title, int width, int height){

        // おふざけ
        JFrame start = new JFrame(title);
        start.setSize(width, height);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLayout(new FlowLayout());
        JOptionPane.showMessageDialog(start, "ぷろ2課題","ぺいんとそふと2018-trompot", INFORMATION_MESSAGE);

        // 本体
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);


        // パネル
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.white);
////		panel.setSize(10,10);
//        panelManage.setPreferredSize(new Dimension(10,10));
//        panel.setLayout(new BorderLayout());
//        Container contentPane = frame.getContentPane();
//        panel.setVisible(true);
//        contentPane.add(panel, BorderLayout.CENTER);
//        frame.setVisible(true);

        Container container = frame.getContentPane();

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(10,10,500,500);
        container.add(panel);
        panel.setVisible(true);



        // PanelManager
        JPanel panelManage = new JPanel();
        panelManage.setLayout(new BorderLayout());
        panelManage.setBackground(new Color(176, 183, 187));
        panelManage.setBounds(width-200,0,200, height);

        PanelManager config_panel = new PanelManager();
        config_panel.setPaintPanel(panel);
        config_panel.setPanelManager(panelManage);

        container.add(panelManage);
        panelManage.setVisible(true);




        // メニューバーの設置
		JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu0 = new JMenu(title);
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Color");
        JMenuItem[] items;

		// Menuアイテムの追加
        // Software
        JMenuItem menu0_Item0 = new JMenuItem("About");
        JMenuItem menu0_Item1 = new JMenuItem("Quit");
        items = new JMenuItem[]{menu0_Item0, menu0_Item1};
        setMenuBar(menuBar, menu0, items);

		// File
		JMenuItem menu1_Item1 = new JMenuItem("Load");
		JMenuItem menu1_Item2 = new JMenuItem("Save");
        items = new JMenuItem[]{menu1_Item1, menu1_Item2};
        setMenuBar(menuBar, menu1, items);

		// Color palette
		JMenuItem menu2_Item1 = new JMenuItem("パレット");
		JMenuItem menu2_Item2 = new JMenuItem("Rainbow");
        items = new JMenuItem[]{menu2_Item1, menu2_Item2};
        setMenuBar(menuBar, menu2, items);


        frame.setVisible(true);


        // Manager Frame
        // JComboBoxリスナー
        JComboBox jComboBox = new JComboBox();
		JFrame config = new JFrame("Manager");

		// 現状触れるな
		Version_log_point log = new Version_log_point();
		Graphics g = panel.getGraphics();

		// マウスリスナー
		MousePaintListener MousePain = new MousePaintListener();
		MousePain.subMousePaintListener(g, log, config_panel);

        config_panel.setPanel(MousePain, g);
        config_panel.setGraphics((Graphics2D)(g));

		// メニューリスナー
		MenuListener MenuListen = new MenuListener(frame, g, MousePain);
		menu0_Item0.addActionListener(MenuListen);
		menu0_Item1.addActionListener(MenuListen);
		menu1_Item1.addActionListener(MenuListen);
		menu1_Item2.addActionListener(MenuListen);
		menu2_Item1.addActionListener(MenuListen);
		menu2_Item2.addActionListener(MenuListen);

        panel.addMouseListener(MousePain);
        panel.addMouseMotionListener(MousePain);
    }


    public void setMenuBar(JMenuBar menuBar, JMenu menu, JMenuItem[] items){
    	menuBar.add(menu);
    	for(JMenuItem item : items)
    	    menu.add(item);
	}
}
