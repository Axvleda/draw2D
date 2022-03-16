import javax.swing.*;


public class MyFrame extends JFrame {


    MyHappening panel;


    MyFrame() {


        panel = new MyHappening();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);

        this.pack();

        this.setLocationRelativeTo(null);

        this.setSize(1000,1000);

        this.setVisible(true);

    }

}