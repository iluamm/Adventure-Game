package main;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author tanaw
 */
public class player {
    public ImageIcon[] im = new ImageIcon[2];
    public int count = 0;

    public int x=50;
    public int y=330;
    player(){
        for(int i=0;i<im.length;i++){
            String imageLocation = "player0"+(i+1)+".png";
            im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 100));
    }
}
