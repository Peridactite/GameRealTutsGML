/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private int hiScore = loadHiScore();
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
            if(score > hiScore){
                hiScore = score;
                storeScore();                
            }
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
        
        int yHudDist = 65;
        g.drawString("HIGHSCORE: " + hiScore, xHudDist, yHudDist);
        yHudDist += 15;
        g.drawString("SCORE: " + score, xHudDist, yHudDist);
        yHudDist += 15;
        g.drawString("LEVEL: " + level, xHudDist, yHudDist);
        yHudDist += 15;
        g.drawString("ENEMIES: " + enemies, xHudDist, yHudDist);
        yHudDist += 15;
        
        if(gameOver){            
            g.drawString("GAME OVER: " + score, Game.WIDTH/2 - 50, Game.HEIGHT/2);
        }
    }
    
    public void storeScore(){
        Properties prop = new Properties();
 
    	try {
            //set the properties value
            prop.setProperty("highscore", Integer.toString(score));

            //save properties to project root folder
//            prop.store(new FileOutputStream("resources/config.properties"), null);
            prop.store(new FileOutputStream(new File(".\\src\\resources\\config.properties")), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public int loadHiScore(){
        Properties prop = new Properties();
	InputStream input = null;
        String hiScore = "";

	try {
            input = new FileInputStream(".\\src\\resources\\config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            hiScore = prop.getProperty("highscore");

	} catch (IOException ex) {
            ex.printStackTrace();
	} finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
	}
        if(hiScore != null){
            return Integer.parseInt(hiScore);            
        }else{
            return 0;
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
