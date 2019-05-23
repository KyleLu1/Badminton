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
import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int speed;

    public MovingThing() {
        xPos = 10;
        yPos = 10;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int s){
        speed = s;
    }
    
    public abstract void move(String direction);

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}
