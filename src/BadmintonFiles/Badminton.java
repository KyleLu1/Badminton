/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BadmintonFiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

/**
 *
 * @author luk8724
 */
public class Badminton extends Canvas implements KeyListener, Runnable {
    private Birdie birdie;
    private Block net;
    private Player leftPlayer;
    private Player rightPlayer;
    private boolean[] keysLeft;
    private boolean[] keysRight;
    private BufferedImage back;
    
    public Badminton(){
        //instantiate objects
        birdie = new Birdie(350,200,30,50,3,3);
        leftPlayer = new Player(40, 200, 15, 75, 5);
        rightPlayer = new Player(730, 200, 15, 75, 5);
        net = new Block(495, 600, 10, 50);
        
        keysLeft = new boolean[4];
        keysLeft = new boolean[]{false, false, false, false};
        
        keysRight = new boolean[4];
        keysRight = new boolean[]{false, false, false, false};
        
        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);	
    }
    
    public void update(Graphics window){
        paint(window);
    }
    
    public void paint(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D) window;
        
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        
        Graphics graphToBack = back.createGraphics();
        
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(440, 520, 80, 80);
        
        birdie.moveAndDraw(graphToBack);
        leftPlayer.draw(graphToBack);
        rightPlayer.draw(graphToBack);
        
 

        graphToBack.setColor(Color.red);
        System.out.print("hi");
        
        
        
        
        
        
        
        
        
        if (keysLeft[0] == true) {
            leftPlayer.moveUpAndDraw(graphToBack);
        }
        if (keysLeft[1] == true) {
            leftPlayer.moveDownAndDraw(graphToBack);
        }
        if (keysLeft[2] == true) {
            leftPlayer.moveRightAndDraw(graphToBack);
        }
        if (keysLeft[3] == true) {
            leftPlayer.moveLeftAndDraw(graphToBack);
        }
        
        if (keysRight[0] == true) {
            rightPlayer.moveUpAndDraw(graphToBack);
        }
        if (keysRight[1] == true) {
            rightPlayer.moveDownAndDraw(graphToBack);
        }
        if (keysRight[2] == true) {
            rightPlayer.moveRightAndDraw(graphToBack);
        }
        if (keysRight[3] == true) {
            rightPlayer.moveLeftAndDraw(graphToBack);
        }
        
       twoDGraph.drawImage(back, null, 0, 0);
        
        
    }
    
    public void keyPressed(KeyEvent e) {
        //leftplayer
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keysLeft[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keysLeft[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keysLeft[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keysLeft[3] = true;
        }
      
        //rightplayer
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keysRight[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keysRight[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keysRight[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keysRight[3] = true;
        }
      
        
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        //leftplayer
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keysLeft[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keysLeft[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keysLeft[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keysLeft[3] = false;
        }
      
        //rightplayer
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keysRight[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keysRight[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keysRight[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keysRight[3] = false;
        }
      
        repaint();
    }
    
    
    
    
    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }
    
}
