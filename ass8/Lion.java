// Xuqing Wu
// 12/5/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #8
//
// This program will present a critter called lion that Infect
//if an enemy is in front, otherwise turn left if a wall is in 
//front or to the right, otherwise turn right if a fellow Lion 
//is in front, otherwise hop. Its appearance is L, and its color
//is red. 

import java.awt.*;
import java.util.*;

public class Lion extends Critter{
   private Random r;
   private int time;
   private Color color;
      
   //the constructor
   public Lion(){
      r = new Random();
      time = 0; 
   }
   
   //return the appearance of lion(L)
   public String toString(){
      return "L";
   }
   
   //return the color of lion
   //color changes every 3 steps randomly from red, green or blue
   public Color getColor(){
      if(time%3 == 0){
         int choice = r.nextInt(3);
         if(choice == 0){
            color = Color.RED;
         }
         else if(choice == 1){
            color = Color.GREEN;
         }
         else{
            color = Color.BLUE;
         }       
      }
      else{
         color = color;
      } 
      return color;
   }
   
   //return the movement of lion
   //info is the infomation about the position situation of the lion
   public Action getMove(CritterInfo info){      
      time++;
      if(info.getFront() == Neighbor.OTHER){
         return Action.INFECT;
      }
      else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
         return Action.LEFT;
      }
      else if(info.getFront() == Neighbor.SAME){
         return Action.RIGHT;
      }
      else{
         return Action.HOP;
      }
   }
}    