/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author peridactite
 */
public class BasicEnemy extends GameObject{

    public static final int SIZE = 16;
    
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        
        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        if(y < 0 || y >= Game.HEIGHT - SIZE) velY *= -1; 
        if(x < 0 || x >= Game.WIDTH - SIZE) velX *= -1; 
    
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);
    }
    
    
}
