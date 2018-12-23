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
            //Learned: Might be better to have a percentage that either gets higher or lower depending on the level. Ex) 100% spawn rate at beggining and 20% spawn rate later. OR a time based consistent rating.
            }else if((level%((level/5)+1)) == 0){
                //Learned: might be better with random since there is already something being impacted by modulus
                if(level%3 == 0){
                    spawnEnemy(ID.FastEnemy);                    
                }else{
                    spawnEnemy(ID.BasicEnemy);                    
                }
            } 
            if(level == 5){
                spawnEnemy(ID.SmartEnemy);
            }
        }
    }
    
    public void spawnEnemy(ID enemy){        
        
        if(ID.BasicEnemy == enemy){
            handler.addObject(new BasicEnemy((float)r.nextInt(Game.WIDTH - 50), (float)r.nextInt(Game.HEIGHT - 50), handler));
            hud.setEnemies(hud.getEnemies() +1);            
        }else if(ID.FastEnemy == enemy){
            handler.addObject(new FastEnemy((float)r.nextInt(Game.WIDTH - 50), (float)r.nextInt(Game.HEIGHT - 50), handler));
            hud.setEnemies(hud.getEnemies() +1);            
        }else if(ID.SmartEnemy == enemy){
            handler.addObject(new SmartEnemy((float)r.nextInt(Game.WIDTH - 50), (float)r.nextInt(Game.HEIGHT - 50), handler));
            hud.setEnemies(hud.getEnemies() +1);            
        }
    }
}
