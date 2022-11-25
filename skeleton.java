package main;

import javax.swing.*;

public class skeleton {
    public ImageIcon[] im = new ImageIcon[2];
    public int count = 0;
    skeleton(){
        for(int i=0;i<im.length;i++){
            String imageLocation = "skeleton0"+(i+1)+".png";
            im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
}
