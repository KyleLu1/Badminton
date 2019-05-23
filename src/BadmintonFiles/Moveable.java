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
public interface Moveable {

    public void setPos(int x, int y);

    public void setX(int x);

    public void setY(int y);

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();
    
    

    public void setWidth(int w);

    public void setHeight(int h);

    public void setSpeed(int s);

    public int getSpeed();
}
