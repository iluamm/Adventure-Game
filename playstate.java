package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class playstate extends JPanel implements ActionListener {
    private final ImageIcon imglv1 = new ImageIcon(this.getClass().getResource("cave.png"));
    private final ImageIcon imglv2 = new ImageIcon(this.getClass().getResource("graveyard.png"));
    private final ImageIcon imglv3 = new ImageIcon(this.getClass().getResource("castle.png"));
    private final ImageIcon gameover = new ImageIcon(this.getClass().getResource("menu2.png"));
    private ImageIcon back = new ImageIcon(this.getClass().getResource("exit.png"));
    private final ImageIcon path = new ImageIcon(this.getClass().getResource("path.png"));
    Home h = new Home();
    slime mon1 = new slime();
    goblin mon2 = new goblin();
    skeleton mon3 = new skeleton();
    darkknight mon4 = new darkknight();
    player py = new player();

    JButton JBack = new JButton(back);

    boolean startball = false;
    public ArrayList<player_atk> player1 = new ArrayList<player_atk>();
    public ArrayList<shield> player_shield = new ArrayList<shield>();
    public ArrayList<slime_atk> slime1 = new ArrayList<slime_atk>();
    public ArrayList<goblin_atk> goblin1 = new ArrayList<goblin_atk>();
    public ArrayList<skeleton_atk> skeleton1 = new ArrayList<skeleton_atk>();
    public ArrayList<darkknight_atk> darkknight1 = new ArrayList<darkknight_atk>();

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(150);
                } catch (Exception e) {
                }
                if (mon1.count == 2 || mon2.count == 2 || mon3.count == 2 || mon4.count == 2 || py.count == 2) {
                    mon1.count = 0;
                    mon2.count = 0;
                    mon3.count = 0;
                    mon4.count = 0;
                    py.count = 0;
                }
                repaint();
            }
        }
    });
    Thread slime = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 5000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    slime1.add(new slime_atk());
                }
            }
        }
    });
    Thread goblin = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 4000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    goblin1.add(new goblin_atk());
                }
            }
        }
    });
    Thread skeleton = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 3000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    skeleton1.add(new skeleton_atk());
                }
            }
        }
    });
    Thread darkknight = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 2000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    darkknight1.add(new darkknight_atk());
                }
            }
        }
    });

    int lvstate = 1;
    int player_hp = 10;
    int mons_hp = 5;

    playstate() {
        this.setFocusable(true);
        this.setLayout(null);
        this.JBack.addActionListener(this);
        actor.start();
        slime.start();
        goblin.start();
        skeleton.start();
        darkknight.start();

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (a == KeyEvent.VK_DOWN) {
                    player_shield.add(new shield(180, 400));
                } else if (a == KeyEvent.VK_RIGHT) {
                    player1.add(new player_atk(180, 400));
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (player_hp <= 0) {
            g.drawImage(gameover.getImage(), 0, 0, 800, 600, this);
            g.setColor(Color.white);
            g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 50));
            g.drawString("GAME OVER", 250, 200);
            JBack.setBounds(275, 430, 240, 100);
            add(JBack);
        }
        else if(lvstate==5){
            g.drawImage(gameover.getImage(), 0, 0, 800, 600, this);
            g.setColor(Color.white);
            g.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 50));
            g.drawString("VICTORY", 250, 200);
            JBack.setBounds(275, 430, 240, 100);
            add(JBack);
        }else {
            if (lvstate == 1) {
                g.drawImage(imglv1.getImage(), 0, 0, 800, 600, this);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Player HP = " + player_hp, 20, 50);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Slime HP = " + mons_hp, 500, 50);
                g.drawImage(path.getImage(), 0, 0, 800, 600, this);
                g.drawImage(mon1.im[mon1.count].getImage(), 550, 400, 110, 160, this);
                mon1.count++;
                for (int i = 0; i < slime1.size(); i++) {
                    g.drawImage(slime1.get(i).getImage(), slime1.get(i).getX(), slime1.get(i).getY(), 100, 100, this);
                    if (Intersect(py.getbound(), slime1.get(i).getbound())) {
                        player_hp--;
                        slime1.remove(i);
                    }
                }
                if (mons_hp == 0) {
                    lvstate++;
                    mons_hp = 10;
                }

            } else if (lvstate == 2) {

                g.drawImage(imglv1.getImage(), 0, 0, 800, 600, this);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Player HP : " + player_hp, 20, 50);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Goblin HP : " + mons_hp, 500, 50);
                g.drawImage(path.getImage(), 0, 0, 800, 600, this);
                g.drawImage(mon2.im[mon2.count].getImage(), 550, 380, 150, 150, this);
                mon2.count++;
                for (int i = 0; i < goblin1.size(); i++) {
                    g.drawImage(goblin1.get(i).getImage(), goblin1.get(i).getX(), goblin1.get(i).getY(), 100, 100, this);
                    if (Intersect(py.getbound(), goblin1.get(i).getbound())) {
                        player_hp--;
                        goblin1.remove(i);
                    }
                }
                if (mons_hp == 0) {
                    lvstate++;
                    mons_hp = 15;
                }
            } else if (lvstate == 3) {
                g.drawImage(imglv2.getImage(), 0, 0, 800, 600, this);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Player HP : " + player_hp, 20, 50);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Skeleton HP : " + mons_hp, 500, 50);
                g.drawImage(path.getImage(), 0, 0, 800, 600, this);
                g.drawImage(mon3.im[mon3.count].getImage(), 550, 380, 150, 150, this);
                mon3.count++;
                for (int i = 0; i < skeleton1.size(); i++) {
                    g.drawImage(skeleton1.get(i).getImage(), skeleton1.get(i).getX(), skeleton1.get(i).getY(), 100, 100, this);
                    if (Intersect(py.getbound(), skeleton1.get(i).getbound())) {
                        player_hp--;
                        skeleton1.remove(i);
                    }
                }
                if (mons_hp == 0) {
                    lvstate++;
                    mons_hp = 20;
                }
            } else if (lvstate == 4) {
                g.drawImage(imglv3.getImage(), 0, 0, 800, 600, this);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Player HP : " + player_hp, 20, 50);
                g.setFont(new Font("Tahoma", Font.BOLD, 25));
                g.setColor(Color.white);
                g.drawString("Dark Knight HP : " + mons_hp, 500, 50);
                g.drawImage(path.getImage(), 0, 0, 800, 600, this);
                g.drawImage(mon4.im[mon4.count].getImage(), 550, 330, 200, 200, this);
                mon4.count++;
                for (int i = 0; i < darkknight1.size(); i++) {
                    g.drawImage(darkknight1.get(i).getImage(), darkknight1.get(i).getX(), darkknight1.get(i).getY(), 100, 100, this);
                    if (Intersect(py.getbound(), darkknight1.get(i).getbound())) {
                        player_hp--;
                        darkknight1.remove(i);
                    }
                }
                if (mons_hp == 0) {
                    lvstate++;
                }
            }
            g.drawImage(py.im[py.count].getImage(), 50, 330, 200, 200, this);
            py.count++;
            }
            for (int i = 0; i < player1.size(); i++) {
                player_atk ba = player1.get(i);
                g.drawImage(ba.img, ba.x, ba.y, 150, 150, null);
                ba.move();
                if (ba.y < 0) {
                    player1.remove(i);
                }
                if (Intersect(ba.getbound(), mon1.getbound())) {
                    mons_hp--;
                    player1.remove(i);
                    System.out.println("hit " + mons_hp);
                }
            }

            for (int i = 0; i < player_shield.size(); i++) {
                shield sa = player_shield.get(i);
                g.drawImage(sa.img, sa.x, sa.y, 100, 100, null);
                sa.move();
                if (sa.y < 0) {
                    player_shield.remove(i);
                }
                if (lvstate == 1) {
                    if(slime1.isEmpty() == false) {
                        for(int j=0;j<slime1.size();j++) {
                            if (Intersect(player_shield.get(i).getbound(), slime1.get(j).getbound())) {
                                slime1.remove(i);
                                player_shield.remove(i);
                            }
                        }
                    }
                } else if (lvstate == 2) {
                        if (goblin1.isEmpty() == false) {
                            for(int j=0;j<goblin1.size();j++) {
                                if (Intersect(player_shield.get(i).getbound(), goblin1.get(j).getbound())) {
                                    goblin1.remove(i);
                                    player_shield.remove(i);
                                }
                            }
                        }
                    } else if (lvstate == 3) {
                        if (skeleton1.isEmpty() == false) {
                            for(int j=0;j<skeleton1.size();j++) {
                                if (Intersect(player_shield.get(i).getbound(), skeleton1.get(j).getbound())) {
                                    skeleton1.remove(i);
                                    player_shield.remove(i);
                                }
                            }
                        }
                    } else if (lvstate == 4) {
                        if (darkknight1.isEmpty() == false) {
                            for(int j=0;j<darkknight1.size();j++) {
                                if (Intersect(player_shield.get(i).getbound(), darkknight1.get(j).getbound())) {
                                    darkknight1.remove(i);
                                    player_shield.remove(i);
                                }
                            }
                        }
                    }
            }
            }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JBack) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
}
