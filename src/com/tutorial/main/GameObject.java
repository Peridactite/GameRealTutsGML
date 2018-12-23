/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author David
 */
public abstract class GameObject {
    
    protected float x, y; //protected can only be accessed by inherited classes
    protected ID id;
    protected float velX,velY;
    
    public static int size;
    
    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        size = -1;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    

}
