import java.awt.*;


import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;



public class MyPanel extends JPanel implements ActionListener{



    final int PANEL_WIDTH = 1000;

    final int PANEL_HEIGHT = 1000;

    Image enemy;

    Image backgroundImage;

    Timer timer;

    int xVelocity = 2;

    int yVelocity = 3;

    int x = 0;

    int y = 0;

    int enemy_width;

    int enemy_height;



    MyPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        this.setBackground(Color.black);

        enemy = new ImageIcon("penrose.png").getImage();


        backgroundImage = new ImageIcon("space.png").getImage();

        timer = new Timer(10, this);

        timer.start();

    }



    public void paint(Graphics g) {



        super.paint(g); // paint background



        Graphics2D g2D = (Graphics2D) g;



        g2D.drawImage(backgroundImage, 0, 0,PANEL_WIDTH, PANEL_HEIGHT, null);

        enemy_width = enemy.getWidth(null);
        enemy_height = enemy.getHeight(null);

        enemy_width = 50;
        enemy_height = 50;
        g2D.drawImage(enemy, x, y, enemy_width, enemy_height, null);


        //TEST
        g2D.drawLine(500, 500, 500, 500);

        g2D.drawString("AXVLEDA", 500,500);
    }



//    @Override
    public void actionPerformed(ActionEvent e) {


        //Logo Movements
        if(x>=PANEL_WIDTH-enemy_width || x<0) {
            xVelocity = (int) (xVelocity * -1);
        }
        x = x + xVelocity;

        if(y>=PANEL_HEIGHT-enemy_height || y<0) {
            yVelocity = (int) (yVelocity * -1);
        }
        y = y + yVelocity;



        repaint();

    }

}