/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.getKeyText;

/**
 *
 * @author peridactite
 */
public class KeyInput extends KeyAdapter{
    //BUGFIX: when opposite keys are pressed the player stops moving. Needs a fix.
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    
    public KeyInput(Handler handler){
        this.handler = handler;
        
        keyDown[0] = false;//W
        keyDown[1] = false;//S
        keyDown[2] = false;//D
        keyDown[3] = false;//A
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_W){ 
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if(key == KeyEvent.VK_S){
                    tempObject.setVelY(5f);
                    keyDown[1] = true;
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(-5);
                    keyDown[2] = true;
                }
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(5);
                    keyDown[3] = true;
                }
                
            }
            if(tempObject.getId() == ID.Player2){
                //key events for player 1
                if(key == KeyEvent.VK_UP){
                    tempObject.setVelY(-5);
                }
                if(key == KeyEvent.VK_DOWN){
                    tempObject.setVelY(5);
                }
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                
            }
        }
        
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_W) keyDown[0]=false;//tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) keyDown[1]=false;//tempObject.setVelY(0);
                if(key == KeyEvent.VK_A) keyDown[2]=false;//tempObject.setVelX(0);
                if(key == KeyEvent.VK_D) keyDown[3]=false;//tempObject.setVelX(0);
                
                //vert movement
                if(!keyDown[0] && !keyDown[1]){
                    tempObject.setVelY(0);            
                }
                if(!keyDown[2] && !keyDown[3]){
                    tempObject.setVelX(0);
                }
            }
            if(tempObject.getId() == ID.Player2){
                //key events for player 1
                if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);                
            }
        }
        //DELETE
        //This just tells you what key you're pressing
//        System.out.println(getKeyText(key));
    }
    
}
