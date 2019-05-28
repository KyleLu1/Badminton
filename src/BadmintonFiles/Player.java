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
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Player extends MovingThing{
    
    private int speed;
    private Image image;
    
    public Player(int x, int y, int w, int h, int s)
    {
        super(x,y,w,h);
        speed = s;

    }
    
    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return 0;
    }
    
    public void move(String direction) {
        if (direction.equals("LEFT")) {
            setX(getX() + speed);
        } else if (direction.equals("RIGHT")) {
            setX(getX() - speed);
        } else if (direction.equals("UP")) {
            setY(getY() + speed);
        } else if (direction.equals("DOWN")) {
            setY(getY() - speed);
        }
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        window.drawLine(x, y, x, y-40);
        window.drawLine(x,y, x-20, y+20);
        window.drawLine(x,y, x +20, y+20);
        window.drawOval(x-10, y-60, 20, 20);
        window.drawLine(x, y-20 , x+25, y-30);
        window.drawLine(x, y-20 , x-25, y-30);
    }
    
    public void moveUpAndDraw(Graphics window) {

        window.setColor(Color.WHITE);
        
        window.drawLine(getX(), getY(), getX(), getY()-40);
        window.drawLine(getX(),getY(), getX()-20, getY()+20);
        window.drawLine(getX(),getY(), getX() +20, getY()+20);
        window.drawOval(getX()-10, getY()-60, 20, 20);
        window.drawLine(getX(), getY()-20 , getX()+25, getY()-30);
        window.drawLine(getX(), getY()-20 , getX()-25, getY()-30);
        
        window.fillRect(getX(),getY(),getWidth(),getHeight());
        move("UP");
        draw(window);
    }

    public void moveDownAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        
        window.drawLine(getX(), getY(), getX(), getY()-40);
        window.drawLine(getX(),getY(), getX()-20, getY()+20);
        window.drawLine(getX(),getY(), getX() +20, getY()+20);
        window.drawOval(getX()-10, getY()-60, 20, 20);
        window.drawLine(getX(), getY()-20 , getX()+25, getY()-30);
        window.drawLine(getX(), getY()-20 , getX()-25, getY()-30);
        
        window.fillRect(getX(),getY(),getWidth(),getHeight());
        move("DOWN");
        draw(window);
    }
    
    public void moveLeftAndDraw(Graphics window){
        window.setColor(Color.WHITE);
        
        window.drawLine(getX(), getY(), getX(), getY()-40);
        window.drawLine(getX(),getY(), getX()-20, getY()+20);
        window.drawLine(getX(),getY(), getX() +20, getY()+20);
        window.drawOval(getX()-10, getY()-60, 20, 20);
        window.drawLine(getX(), getY()-20 , getX()+25, getY()-30);
        window.drawLine(getX(), getY()-20 , getX()-25, getY()-30);
        
        window.fillRect(getX(),getY(),getWidth(),getHeight());
        move("LEFT");
        draw(window);
    }
    
    public void moveRightAndDraw(Graphics window){
        window.setColor(Color.WHITE);
        
        window.drawLine(getX(), getY(), getX(), getY()-40);
        window.drawLine(getX(),getY(), getX()-20, getY()+20);
        window.drawLine(getX(),getY(), getX() +20, getY()+20);
        window.drawOval(getX()-10, getY()-60, 20, 20);
        window.drawLine(getX(), getY()-20 , getX()+25, getY()-30);
        window.drawLine(getX(), getY()-20 , getX()-25, getY()-30);
        
        window.fillRect(getX(),getY(),getWidth(),getHeight());
        move("RIGHT");
        draw(window);
    }
    
    


public void draw(Graphics window) {
 
        
        window.setColor(Color.black);
        
        window.drawLine(getX(), getY(), getX(), getY()-40);
        window.drawLine(getX(),getY(), getX()-20, getY()+20);
        window.drawLine(getX(),getY(), getX() +20, getY()+20);
        window.drawOval(getX()-10, getY()-60, 20, 20);
        window.drawLine(getX(), getY()-20 , getX()+25, getY()-30);
        window.drawLine(getX(), getY()-20 , getX()-25, getY()-30);
        
        
    }
    
    
    
    
    
    
    
    
    public String toString() {
        return super.toString() + " " + speed;
    }
}
