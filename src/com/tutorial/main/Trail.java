/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author David
 */
public class Trail extends GameObject{
//I STOPPED TUT 5 ON 19:58
    private float alpha = 0.70f;
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;
    
    //trailDuration or life = anything from .001 to .1 
    
    public Trail(float x, float y, ID id, Color color, int width, int height, float duration, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = duration;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha -= (life - 0.01f);
        }else{
            handler.removeObject(this);
        }        
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x,(int)y,width,height);
        
        //you need to watch this part of vid with sound find out what's happening
        g2d.setComposite(makeTransparent(1));
    }

    //render out transparencies
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }
    
    @Override
    public Rectangle getBounds() {
        return null;
    }
    
    
    
}
