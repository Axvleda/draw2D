import java.awt.*;


import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;



public class MyHappening extends JPanel implements ActionListener{



    final int PANEL_WIDTH = 1000;

    final int PANEL_HEIGHT = 1000;

    Image enemy;

    Image backgroundImage;

    Timer timer;

    int xVelocity = 2;

    int yVelocity = 3;

    int x = 0;

    int y = 0;

    int z = 0;

    int enemy_width;

    int enemy_height;

    
    int[] firstX = {0,0};
    int[] secondX = {0,0};
    int[] thirdX = {0, 0};
    int myoffset = 0;

    MyHappening(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        this.setBackground(Color.black);

//        enemy = new ImageIcon("penrose.png").getImage();


//        backgroundImage = new ImageIcon("space.png").getImage();

        timer = new Timer(10, this);

        timer.start();

    }



    public void paint(Graphics g) {
        



        super.paint(g); // paint background



        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);



//        g2D.drawImage(backgroundImage, 0, 0,PANEL_WIDTH, PANEL_HEIGHT, null);

//        enemy_width = enemy.getWidth(null);
//        enemy_height = enemy.getHeight(null);

        enemy_width = 50;
        enemy_height = 50;
        g2D.drawImage(enemy, thirdX()[0], thirdX()[1], enemy_width, enemy_height, null);



        //TEST
//        g2D.drawString("IVICOUH!", firstX[0], firstX[1], firstX[0]-1, firstX[1]-1);
        g2D.drawString("d!", firstX[0], firstX[1]);
        g2D.drawString("h!", secondX[0], secondX[1]);
        g2D.drawString("v!", PANEL_HEIGHT/4, PANEL_HEIGHT/4);
        g2D.drawString("AXVLEDA", thirdX[0],100);


        g2D.drawLine(PANEL_HEIGHT/4, PANEL_WIDTH/4, PANEL_HEIGHT/4 -100, PANEL_WIDTH/4 - 100);
        g2D.drawLine(thirdX[0], thirdX[1],thirdX[1],  thirdX[1]);
        g2D.setColor(Color.CYAN);
        g2D.drawLine(thirdX()[0], thirdX()[1],thirdX()[1],  thirdX()[1]);

    }

    private int[] firstX() {
        return new int[]{PANEL_HEIGHT/3, PANEL_WIDTH/3};
    }
    
    private int[] secondX(){
        return new int[]{PANEL_HEIGHT/2, PANEL_WIDTH/2};
    }
    
    private int[] thirdX(){
        int random = (int) (PANEL_HEIGHT/(Math.random()*100));
        int random1 = (int) (PANEL_HEIGHT/(Math.random()*100));
        System.out.println(random);
        return new int[]{(random), random1};

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

        //TEST
        firstX = firstX();
        secondX = secondX();
        thirdX = thirdX();


        myoffset = (int) (Math.random() * 100);

        




        repaint();

    }

}