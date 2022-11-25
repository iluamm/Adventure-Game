package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
public class GameStart extends JFrame implements ActionListener{
    BGgame bg = new BGgame();
    playstate state = new playstate();
    public GameStart(){
        this.setSize(800,600);
        this.add(bg);
        bg.BStart.addActionListener(this);
        bg.BExit.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bg.BStart){
            this.setLocationRelativeTo(null);
            this.remove(bg);
            this.setSize(800,600);
            this.add(state);
            state.requestFocusInWindow();
        } else if (e.getSource() == bg.BExit) {
            System.exit(0);
        }
    }


}
