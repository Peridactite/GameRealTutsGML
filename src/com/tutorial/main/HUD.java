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
    
    private int greenValue = 255;
    private int redValue = 200;
    public static int HEALTH = 100;
    
    private int score = 0;
    private int level = 1;
    private int enemies = 1;
    
    public void tick(){
        //HEALTH++;
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        redValue = Game.clamp(greenValue, 0, 255);
        
        greenValue = HEALTH*2;
        redValue = 200 - (HEALTH*2);
        
        score++;
    }
    
    public void render(Graphics g){
        int xHudDist = 15;
        g.setColor(Color.GRAY);
        g.fillRect(xHudDist, xHudDist, 200, 32);
        g.setColor(new Color(redValue, greenValue, 0));
        g.fillRect(xHudDist, xHudDist, HEALTH*2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(xHudDist,xHudDist,200,32);
        
        g.drawString("SCORE: " + score, xHudDist, 65);
        g.drawString("LEVEL: " + level, xHudDist, 80);
        g.drawString("ENEMIES: " + enemies, xHudDist, 95);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEnemies() {
        return enemies;
    }

    public void setEnemies(int enemies) {
        this.enemies = enemies;
    }
    
    
}
