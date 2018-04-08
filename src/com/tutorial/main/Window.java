/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

    private static final long serialVersionUID = -7259108873705494293L;
    
    public Window(int width, int height, String title, Game game){
       JFrame frame = new JFrame(title);
       
       frame.setUndecorated(true);//destroy frame decoratrions (borders and buttons)
       frame.setPreferredSize(new Dimension(width, height));
       frame.setMaximumSize(new Dimension(width, height));
       frame.setMinimumSize(new Dimension(width, height));
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);//keep things simple
       frame.setLocationRelativeTo(null);//center
       frame.add(game);
       frame.setVisible(true);
       game.start();//start thread
    }
    
    
}
