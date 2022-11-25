package main;

import javax.swing.*;

public class darkknight {
    public ImageIcon[] im = new ImageIcon[2];
    public int count = 0;
    darkknight(){
        for(int i=0;i<im.length;i++){
            String imageLocation = "darkknight0"+(i+1)+".png";
            im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
}
