package main;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends JPanel{
    private ImageIcon menu     = new ImageIcon(this.getClass().getResource("menu.png"));
    private ImageIcon exit      = new ImageIcon(this.getClass().getResource("exit.png"));
    private ImageIcon start    = new ImageIcon(this.getClass().getResource("start.png"));

    public JButton BStart  = new JButton(start);
    public JButton BExit  = new JButton(exit);

    Home(){
        setLayout(null);
        BExit.setBounds(275,430,240,100);
        add(BExit);
        BStart.setBounds(275,300,240,100);
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
