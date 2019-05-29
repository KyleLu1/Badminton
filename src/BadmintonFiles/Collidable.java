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

public interface Collidable {

    public abstract boolean didCollideLeft(Object obj);

    public boolean didCollideRight(Object obj);

    boolean didCollideTop(Object obj);

    boolean didCollideBottom(Object obj);
}
