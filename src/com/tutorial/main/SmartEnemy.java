package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author peridactite
 */
public class SmartEnemy extends GameObject{

    private Handler handler;
    private GameObject player;
    public static int size;
    
    public SmartEnemy(float x, float y, Handler handler) {
        super(x, y, ID.SmartEnemy);        
        this.handler = handler;
        size = 16;
        
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player){
                player = handler.object.get(i);
            }
        }
        
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,size,size);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        homing(-3.0f);
        
        //ADJUST SIZE LATER FOR Finessing
        x = Game.clamp(x, 0, Game.WIDTH - size);
        y = Game.clamp(y, 0, Game.HEIGHT - size);
        
        handler.addObject(new Trail(x,y, ID.Trail, Color.GREEN, size, size, 0.1f, handler));
    
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, size, size);
    }     
    
    public void homing(float speed){        
        float diffX = x - player.getX() - (size/8);//should size be based off enemy size??
        float diffY = y - player.getY() - (size/8);        
        float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
        
        velX = (float) ((speed/distance)*diffX);
        velY = (float) ((speed/distance)*diffY);
        
        if(y < 0 || y >= Game.HEIGHT - size) velY *= speed; 
        if(x < 0 || x >= Game.WIDTH - size) velX *= speed; 
    }
}
