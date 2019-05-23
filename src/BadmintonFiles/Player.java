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
         try {
            URL url = getClass().getResource("Resources/ship.jpg");
            image = ImageIO.read(url);
        } catch (Exception e) {
            //feel free to do something here
        }
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

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    
    
    
    
    
    
    
}
