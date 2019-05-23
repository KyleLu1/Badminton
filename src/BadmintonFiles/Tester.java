/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BadmintonFiles;

/**
 *
 * @author luk8724
 */

import javax.swing.JFrame;
import java.awt.Component;

public class Tester extends JFrame{
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    public Tester(){
        super("Badminton");
        setSize(WIDTH, HEIGHT);

        Badminton game = new Badminton();

        ((Component) game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]) {
        Tester run = new Tester();
    }
    
}
