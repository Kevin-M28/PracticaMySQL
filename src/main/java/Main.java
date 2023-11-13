import Views.menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame n = new JFrame();
        n.setContentPane(new menu());
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        n.pack();
        n.setVisible(true);
    }
}
