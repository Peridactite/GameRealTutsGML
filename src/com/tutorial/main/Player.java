package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author David
 */
public class Player extends GameObject{
    
    public static final int SIZE = 32;
    Random r = new Random();
    int x1Bound = 100;
    int y1Bound = 100;
    int x2Bound = 200;
    int y2Bound = 200;
    
    public Player (int x, int y, ID id){
        super(x,y,id);
        
        velX = 0;
        velY = 0;
    }
    
    @Override
    public void tick(){
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);

        if(id == ID.Player){
            x += velX;
            y += velY;
        }
        
        if(id == ID.Player2){
            x += velX;
            y += velY;
        }
        
        if(id == ID.BasicEnemy){
            if(y == y1Bound && x < x2Bound){
                x += velX;
            }
            if(x == x2Bound && y < y2Bound){
                y += velY;
            }
            if(x > x1Bound && y == y2Bound){
                x -= velX;
            }
            if(x == x1Bound && y > y1Bound){
                y -= velY;
            }
        }
        
        //ADJUST SIZE LATER FOR Finessing
        x = Game.clamp(x, 0, Game.WIDTH - SIZE);
        y = Game.clamp(y, 0, Game.HEIGHT - SIZE);
    }
    
    @Override
    public void render(Graphics g){
        if(id == ID.Player){
            g.setColor(Color.WHITE);
            g.fillRect(x,y,SIZE,SIZE);
        }
        if(id == ID.Player2){
            g.setColor(Color.WHITE);
            g.fillRect(x,y,SIZE,SIZE);
        }
        
    }
    
    
}