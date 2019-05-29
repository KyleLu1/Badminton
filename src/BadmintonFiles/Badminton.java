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
        birdie = new Birdie(350,200,30,50,2,2);
        leftPlayer = new Player(40, 200, 40,80, 5);
        rightPlayer = new Player(730, 200, 40, 80, 5);
        net = new Block(400, 460, 10, 120);
       
        
        
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
        net.draw(graphToBack);
        
 

        graphToBack.setColor(Color.red);
        
        if (!(birdie.getY() >= 20 && birdie.getY() <= 450)) {
            birdie.setySpeed(-birdie.getySpeed());
        }
        
        if (!(birdie.getX() >= 20 && birdie.getX() <= 760)) {
            birdie.setxSpeed(-birdie.getxSpeed());
        }
        
        
        
        if (birdie.didCollideLeft(leftPlayer)
                && (birdie.didCollideTop(leftPlayer) || birdie.didCollideBottom(leftPlayer))) {

            if (birdie.getX() <= leftPlayer.getX() + leftPlayer.getWidth() - Math.abs(birdie.getxSpeed())) {
                birdie.setySpeed(-birdie.getySpeed());
            } else {
                birdie.setxSpeed(-birdie.getxSpeed());
            }
        }

        if (birdie.didCollideRight(rightPlayer)
                && (birdie.didCollideTop(rightPlayer) || birdie.didCollideBottom(rightPlayer))) {
            if (birdie.getX() + birdie.getWidth() >= rightPlayer.getX() + Math.abs(birdie.getxSpeed())) {
                birdie.setySpeed(-birdie.getySpeed());
            } else {
                birdie.setxSpeed(-birdie.getxSpeed());
            }
        }
        
        
        
        
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
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keysRight[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keysRight[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keysRight[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keysRight[3] = true;
        }
      
        //rightplayer
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keysLeft[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keysLeft[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keysLeft[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keysLeft[3] = true;
        }
      
        
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        //leftplayer
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keysRight[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keysRight[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keysRight[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keysRight[3] = false;
        }
      
        //rightplayer
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keysLeft[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keysLeft[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keysLeft[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keysLeft[3] = false;
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
