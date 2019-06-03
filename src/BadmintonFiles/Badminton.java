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
    private Block bottom;
    private Block leftWall;
    private Block rightWall;
    private Block top;
    private int leftScore;
    private int rightScore;
    
    public Badminton(){
        //instantiate objects
        birdie = new Birdie(350,200,30,50,2,2);
        leftPlayer = new Player(60, 420, 40,80, 3);
        rightPlayer = new Player(720, 420, 40, 80, 3);
        net = new Block(400, 380, 10, 120);
        bottom = new Block(20,500,740,20);
        leftWall = new Block(0, 0, 20, 520);
        rightWall = new Block(760, 0, 20, 520);
        top = new Block(0, 0, 780, 20);
        leftScore = 0;
        rightScore = 0;
       
        
        
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
        bottom.draw(graphToBack);
        leftWall.draw(graphToBack);
        rightWall.draw(graphToBack);
        top.draw(graphToBack);
        
    
        
        graphToBack.drawString("rightScore = " + rightScore, 450, 540);
        graphToBack.drawString("leftScore = " + leftScore, 300, 540);
 

        graphToBack.setColor(Color.red);
        
        if (!(birdie.getY() >= 20 && birdie.getY() <= 450)) {
            birdie.setySpeed(-birdie.getySpeed());
        }
        
        if (!(birdie.getX() >= 20 && birdie.getX() <= 740)) {
            birdie.setxSpeed(-birdie.getxSpeed());
        }
        
        if(birdie.didCollideRight(net) || didCollideLeft(net))
        {
            birdie.setxSpeed(-birdie.getxSpeed());
            birdie.setySpeed(-birdie.getySpeed());
        }
        
        if(birdie.didCollideTop(bottom) && birdie.getX()>400)
        {
            leftScore += 1;   
            birdie.setX(rightPlayer.getX());
            birdie.setY(rightPlayer.getY() - 40);
        }
        
        if(birdie.didCollideTop(bottom) && birdie.getX()<400)
        {
            rightScore += 1;   
            birdie.setX(leftPlayer.getX());
            birdie.setY(leftPlayer.getY() - 40);
        }
        //players collide wall
        
        if(leftPlayer.didCollideRight(leftWall))
        {
           leftPlayer.setX();
        }
        
        if(leftPlayer.didCollideLeft(net))
        {
            leftPlayer.setX();
        }
        
        if(rightPlayer.didCollideLeft(rightWall))
        {
            rightPlayer.setX();
        }
        
        if(rightPlayer.didCollideRight(net))
        {
            rightPlayer.setX();
        }
           
               
        
        
        
        
        if(leftScore == 7)
        {
            graphToBack.drawString("Player One Wins!", 375, 200);
            birdie.setXSpeed(0);
            birdie.setYSpeed(0);
        }
        
        if(rightScore == 7)
        {
            graphToBack.drawString("Player Two Wins!", 375, 200);
            birdie.setXSpeed(0);
            birdie.setYSpeed(0);
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
            //leftPlayer.moveUpAndDraw(graphToBack);
        }
        if (keysLeft[1] == true) {
            //leftPlayer.moveDownAndDraw(graphToBack);
        }
        if (keysLeft[2] == true) {
           leftPlayer.moveRightAndDraw(graphToBack);
        }
        if (keysLeft[3] == true) {
           leftPlayer.moveLeftAndDraw(graphToBack);
        }
        
        if (keysRight[0] == true) {
            //rightPlayer.moveUpAndDraw(graphToBack);
        }
        if (keysRight[1] == true) {
            //rightPlayer.moveDownAndDraw(graphToBack);
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
