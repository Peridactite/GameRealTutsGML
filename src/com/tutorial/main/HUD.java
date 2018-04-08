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
public class HUD {
    
    public static int HEALTH = 100;
    
    public void tick(){
        HEALTH++;
        HEALTH = Game.clamp(HEALTH, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15, 15, HEALTH*2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15,15,200,32);
    }
}
