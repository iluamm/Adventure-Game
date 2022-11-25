/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 *
 * @author tanaw
 */
public class Main extends JFrame implements ActionListener {
    Home hg = new Home();
    playstate state = new playstate();
    public Main(){
        this.setSize(800, 600);
        this.add(hg);
        hg.BExit.addActionListener(this);
        hg.BStart.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hg.BStart){
            this.setLocationRelativeTo(null);
            this.remove(hg);
            this.setSize(800,600);
            this.add(state);
            state.requestFocusInWindow();
            state.startball = false;
        } else if (e.getSource() == hg.BExit) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args) {
        JFrame frame= new Main();
        frame.setTitle("GAME");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
