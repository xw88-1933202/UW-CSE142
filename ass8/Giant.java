// Xuqing Wu
// 12/5/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #8
//
// This program will present a critter called giant which 
//infect if an enemy is in front, otherwise hop if possible,
//otherwise turn right. Its appearance is "fee" for 6 moves, 
//then "fie" for 6 moves, then "foe" for 6 moves, then "fum" 
//for 6 moves, then repeat. Its color is gray.

import java.awt.*;

public class Giant extends Critter{
   private int step;
   
   //the constructor
   public Giant(){
      step = 0;
   }
   
   //return the color of giant(gray)
   public Color getColor(){
      return Color.GRAY;
   }
   
   //return the appearance of giant
   //"fee","fie","foe","fum" each for 6 moves
   public String toString(){
      String[] str = {"fee","fie","foe","fum"};
      return str[step/6%4];
   }
   
   //return the movement of giant
   //info is the infomation about the position situation of the lion
   public Action getMove(CritterInfo info){
      step++;
      if(info.getFront() == Neighbor.OTHER){
         return Action.INFECT;
      }
      else if(info.getFront() == Neighbor.EMPTY){
         return Action.HOP;
      }
      else{
         return Action.RIGHT;
      }
   }
}
      