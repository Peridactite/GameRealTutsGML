/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.util.Random;

/**
 *
 * @author peridactite
 */
public class testing {
    public static void main(String[] args){
        System.out.println(1/3);
        int enemies = 1;
        for(int level = 1; level < 200; level++){
            System.out.println("Level: " + level);
//            System.out.println("level/3         " + (level/3));
//            System.out.println("(level%(level/3)): " + (level%(level/3 + 1)));
            if(level < 5){
                System.out.println("Enemy+");
                enemies++;
            }else if((level%((level/5)+1)) == 0){
                System.out.println("\tEnemy: " + enemies);
                enemies++;
            }
        }
        System.out.println("enemies: " + enemies);
        
        
        
        
        
        
        
        
        
        
    }
    
}
