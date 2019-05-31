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
public class Block extends MovingThing{
    
    private Color color;
    private final int gravity = 10;
    private final int terminalVelocity = 300;
    private int verticalSpeed = 0;
    private int verticalPosition;
        
    
    public Block(int x, int y, int w, int h)
    {
        super(x, y, w, h);
  
    }
    
    public Block(int x, int y, int w, int h, int s)
    {
        super(x, y, w, h);
        setSpeed(s);
    }
    
    public Color getColor() {
        return color;
    }

    public void move(String direction){
        
    }
    
    public void setColor(Color col) {
        this.color = col;
    }
    
   
    
    public void draw(Graphics window) {
        //uncomment after you write the set and get methods
        window.setColor(color.BLACK);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public String toString(){
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }
    
 
}
