package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
    
/**
 *
 * @author David
 */
public class Game extends Canvas implements Runnable{
    //INSERT SERIAL CODE
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH /12 * 9; //Aspect Ratio calculation
    
    private Thread thread;
    private boolean running = false; 
    
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        r = new Random();
        handler.addObject(new Player((WIDTH/2)- (Player.size/2), (HEIGHT/2) - (Player.size/2), handler));//adds a centered Player object
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), handler));
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        
//        for(int i = 0; i < 20; i++){
//            handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT), handler));
//        }
        
    
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){ // if it's been more than a second print fps
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();        
    }
    
    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        hud.render(g);//i had commented this out 6/10
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float var, float min, float max){
        if(var >= max){
            return var = max;
        }else if(var <= min){
            return var = min;
        }else{
            return var;
        }
    }
    
    public static void main(String args[]){
        System.out.println("START");
        new Game();
    }
}
