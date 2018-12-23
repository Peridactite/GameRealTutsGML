/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author peridactite
 */
public class HUD {
    
    private float greenValue = 255;
    private float redValue = 200;
    public static float HEALTH = 100;
    boolean gameOver = false;
    
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
        
        if(HEALTH > 0){
            score++;            
        } else {
            //GAME OVER
            storeScore();
            gameOver = true;
       }
    }
    
    public void render(Graphics g){
        int xHudDist = 15;
        g.setColor(Color.GRAY);
        g.fillRect(xHudDist, xHudDist, 200, 32);
        g.setColor(new Color((int)redValue, (int)greenValue, 0));
        g.fillRect(xHudDist, xHudDist, (int)HEALTH*2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(xHudDist,xHudDist,200,32);
        
        g.drawString("SCORE: " + score, xHudDist, 65);
        g.drawString("LEVEL: " + level, xHudDist, 80);
        g.drawString("ENEMIES: " + enemies, xHudDist, 95);
        
        if(gameOver){            
            g.drawString("GAME OVER: " + score, Game.WIDTH/2 - 50, Game.HEIGHT/2);
        }
    }
    
    public void storeScore(){
        Properties prop = new Properties();
 
    	try {
            //set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "myuser");
            prop.setProperty("dbpassword", "mypwd");
            prop.setProperty("score", Integer.toString(score));

            //save properties to project root folder
//            prop.store(new FileOutputStream("resources/config.properties"), null);
            prop.store(new FileOutputStream(new File(".\\src\\resources\\config.properties")), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
