package main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BGgame extends JPanel{
    private ImageIcon menu = new ImageIcon(this.getClass().getResource("menu.png"));
    private ImageIcon menu2 = new ImageIcon(this.getClass().getResource("menu2.png"));
    private ImageIcon graveyard = new ImageIcon(this.getClass().getResource("graveyard.png"));
    private ImageIcon castle = new ImageIcon(this.getClass().getResource("castle.png"));
    private ImageIcon cave = new ImageIcon(this.getClass().getResource("cave.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
    public JButton BStart = new JButton(starts);
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    public JButton BExit = new JButton(exit);
    BGgame(){
        setLayout(null);
        BExit.setBounds(275, 430, 250,100);
        add(BExit);
        BStart.setBounds(275,300,250,100);
        add(BStart);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(menu.getImage(),0,0,800,600,this);
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma",Font.CENTER_BASELINE,50));
        g.drawString("ADVENTURE GAME",150,200);
    }
}
