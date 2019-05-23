/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BadmintonFiles;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author luk8724
 */
public class Birdie extends Block{
    
    private int xSpeed;
    private int ySpeed;
    
    public Birdie(int x, int y, int w, int h) {
        super(x, y, w, h);
        xSpeed = 3;
        ySpeed = 1;
    }
    
    public Birdie(int x, int y, int w, int h, int xSp, int ySp) {
        super(x, y, w, h);
        xSpeed = xSp;
        ySpeed = ySp;
    }

    /**
     * @return the xSpeed
     */
    public int getxSpeed() {
        return xSpeed;
    }

    /**
     * @param xSpeed the xSpeed to set
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * @return the ySpeed
     */
    public int getySpeed() {
        return ySpeed;
    }

    /**
     * @param ySpeed the ySpeed to set
     */
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public void moveAndDraw(Graphics window) {
        //draw a white ball at old ball location
        
        draw(window,Color.white);
        setX(getX() + getxSpeed());
        setY(getY()+getySpeed());
        
        //draw the ball at its new location
        
        draw(window);
    }
    
    
    
}
