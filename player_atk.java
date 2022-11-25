package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class player_atk extends atk{

    player_atk(int x,int y) {
        String imageLocation = "player_skill.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();

        this.x=x;
        this.y=y;
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x += 2;
                if (x >= 550) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public void move(){
        this.x+=1;
    }
    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 100));
    }
}
