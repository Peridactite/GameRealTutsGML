/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author peridactite
 */
public class FastEnemy extends GameObject{

    private Handler handler;
    public static int size = 16;
    
    public FastEnemy(float x, float y, Handler handler) {
        super(x, y, ID.FastEnemy);        
        this.handler = handler;
        
        velX = 2;
        velY = 8;
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,size,size);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        if(y < 0 || y >= Game.HEIGHT - size) velY *= -1; 
        if(x < 0 || x >= Game.WIDTH - size) velX *= -1; 
        
        //ADJUST SIZE LATER FOR Finessing
        x = Game.clamp(x, 0, Game.WIDTH - size);
        y = Game.clamp(y, 0, Game.HEIGHT - size);
        
        handler.addObject(new Trail(x,y, ID.Trail, Color.CYAN, size, size, 0.1f, handler));
    
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, size, size);
    }     
}
