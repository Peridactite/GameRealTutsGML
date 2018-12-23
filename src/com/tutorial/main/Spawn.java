package com.tutorial.main;

import java.util.Random;

/**
 *
 * @author David
 */
public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    private int scoreKeep = 0;//TODO I don't want to use this, but tut man does
    
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        
        if(scoreKeep >= 100){
            scoreKeep = 0;
            int level = hud.getLevel();
            hud.setLevel(level + 1);
            
            if(hud.getLevel() < 5){
                spawnEnemy(ID.BasicEnemy);
            }else if((level%((level/5)+1)) == 0){
                if(level%3 == 0){
                    spawnEnemy(ID.FastEnemy);                    
                }else{
                    spawnEnemy(ID.BasicEnemy);                    
                }
            }
        }
    }
    
    public void spawnEnemy(ID enemy){        
        if(ID.BasicEnemy == enemy){
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
            hud.setEnemies(hud.getEnemies() +1);            
        }else if(ID.FastEnemy == enemy){
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
            hud.setEnemies(hud.getEnemies() +1);            
        }
    }
}
