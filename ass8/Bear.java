// Xuqing Wu
// 12/5/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #8
//
// This program will present a critter called bear which 
//infect if an enemy is in front, otherwise hop if possible,
//otherwise turn left. Its color change between white and 
//black. Its appearance chnage from / to \.

import java.awt.*;

public class Bear extends Critter{
   private int count;
   private boolean polar;
      
   //the constructor
   //polar is to determine whether it's black or white
   public Bear(boolean polar){
      count = 0;
      this.polar = polar;
   }
   
   //return the appearance of the bear(/ or \)
      public String toString(){
      if(count%2==0){
         return "/";
      }
      else{
         return "\\";
      }
   }
   
   //return the color of bear(black or white)
   public Color getColor(){
      if(polar){
         return Color.WHITE;
      }
      return Color.BLACK;
   }
   
   //return the movement of bear
   //info is the infomation about the position situation of the bear
   public Action getMove(CritterInfo info){
      count++;
      if(info.getFront() == Neighbor.OTHER){
         return Action.INFECT;
      }
      else if(info.getFront() == Neighbor.EMPTY){
         return Action.HOP;
      }
      else{
         return Action.LEFT;
      }
   }
}