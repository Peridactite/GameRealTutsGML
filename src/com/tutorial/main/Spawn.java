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
//        scoreKeep++;
//        
//        if(scoreKeep >= 1000){
//            scoreKeep = 0;
//            int level = hud.getLevel();
//            hud.setLevel(level + 1);
//            
//            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
//            if(hud.getLevel() < 5){
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
//                hud.setEnemies(hud.getEnemies() +1);
//            }else if((level%((level/5)+1)) == 0){
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
//                hud.setEnemies(hud.getEnemies() +1);
//            }
//        }
    }
}
