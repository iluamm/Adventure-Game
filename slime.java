package main;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class slime {
    public ImageIcon[] im = new ImageIcon[2];

    private ImageIcon slime_atk    = new ImageIcon(this.getClass().getResource("slime_skill.png"));
    public int count = 0;
    public int x=550;
    public int y=350;
    slime(){
        for(int i=0;i<im.length;i++){
            String imageLocation = "Slime0"+(i+1)+".png";
            im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }

    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 100));
    }
}
