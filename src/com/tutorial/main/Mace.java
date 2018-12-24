package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author David
 */
public class Mace extends GameObject{
    
    Handler handler;
    
    //protected int x, y; //protected can only be accessed by inherited classes
    protected int size, ropeLength;
    float velX, velY;
    protected Color color;
    protected GameObject player;
    
    public Mace(int ropeLength, int size, Color color, ID id, GameObject player, Handler handler){
        super(player.getX(), player.getY(), id);
        this.ropeLength = ropeLength;
        this.id = id;
        this.size = size;
        this.color = color;
        this.player = player;
        this.handler = handler;
        
    }
    
    @Override
    public void tick() {
        float xAxisDist = x - player.getX();
        float yAxisDist = y - player.getY();
        int directionChangeSlower = 1;
        float slowRate = .1f;
        
//        if(Math.abs(xAxisDist) > ropeLength){               //if distance between player and mace is greater than rope length
//            if(player.getVelX() > 0){                       //and if the player is moving 
//                velX = player.getVelX();                    //inherit their velocity and direction
//            } else {
//                velX = velX * -1 * directionChangeSlower;   //otherwise just change direction and maintain speed TODO might want to slow it down a bit too
//            }
//            x = player.getX() + xAxisDist;
//        } else if((Math.abs(xAxisDist) < ropeLength) && (Math.abs(velX) > 0)){
//            velX = velX - slowRate;

        //if outside rope radius
        if(Math.abs(xAxisDist) > ropeLength){
            if(Math.abs(player.getVelX()) > 0){                       
                velX = player.getVelX();                    
            } else {
                System.out.println("yAxisDist and player.y " + xAxisDist + ", " + player.getX());
                velX = velX * -1 * directionChangeSlower;   
            }
            if(xAxisDist > 0){
                x = player.getX() + ropeLength;
            } else if(xAxisDist < 0){
                x = player.getX() - ropeLength;
            }
//            y = player.getY() + yAxisDist;
//            System.out.println("y: " + y);
//            System.out.println("player.y and yAxisDist: " + player.getY() + ", " + yAxisDist);
        } else if((Math.abs(xAxisDist) < ropeLength)){
            if(velX > 1){
                System.out.println("velX" + velX);
                velX = velX - slowRate;
            } else if(velX < 0){
                System.out.println("velX" + velX);
                velX = velX + slowRate;
            }
            
        }
        if(Math.abs(yAxisDist) > ropeLength){            
            if(Math.abs(player.getVelY()) > 0){                       
                velY = player.getVelY();                    
            } else {
                System.out.println("yAxisDist and player.y " + yAxisDist + ", " + player.getY());
                velY = velY * -1 * directionChangeSlower;   
            }
            if(yAxisDist > 0){
                y = player.getY() + ropeLength;
            } else if(yAxisDist < 0){
                y = player.getY() - ropeLength;
            }
//            y = player.getY() + yAxisDist;
//            System.out.println("y: " + y);
//            System.out.println("player.y and yAxisDist: " + player.getY() + ", " + yAxisDist);
        } else if((Math.abs(yAxisDist) < ropeLength)){
            if(velY > 1){
                System.out.println("velY" + velY);
                velY = velY - slowRate;
            } else if(velY < 0){
                System.out.println("velY" + velY);
                velY = velY + slowRate;
            }
        }
//        velX = myFloor(velX);
//        velY = myFloor(velY);
        x += Math.floor(velX);//TODO might need to change x and y to floats
        y += Math.floor(velY);
        collision();
        
    }
    
    
//    private float myFloor(float num){
//        return (float)(Math.floor(num * 10f) / 10f);
//    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //Collision Code
                    handler.removeObject(tempObject);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(color);
        g.fillRect((int)x,(int)y,size,size);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,size,size);
    }
}
