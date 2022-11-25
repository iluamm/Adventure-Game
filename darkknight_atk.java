package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class darkknight_atk extends atk{
    public int x = 550;
    public int y = 350;
    darkknight_atk() {
        String imageLocation = "darkknight_skill.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
        this.x=x;
        this.y=y;
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x -= 1;
                if (x <= 50) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(8);
                } catch (InterruptedException e) {
                }
            }
        }
    });

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
        return (new Rectangle2D.Double(x, y, 50, 100));
    }
}
