// Xuqing Wu
// 12/5/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #8
//

import java.awt.*;
import java.util.*;

public class Husky extends Critter{
   private Random r; 
   
   public Husky(){
   r = new Random();
   }
   
   public Color getColor(){
      int choice = r.nextInt(2);
      if(choice == 0){
         return Color.YELLOW;
      }
      else{
         return Color.BLUE;
      }
   }
   
   public String toString(){
      return "HUSKY";
   }
   
   public Action getMove(CritterInfo info){
      if(info.getFront() == Neighbor.OTHER){
         return Action.INFECT;
      }
      else if(info.getLeft() == Neighbor.EMPTY||info.getRight() == Neighbor.EMPTY){
         return Action.HOP;
      }
      else{
         return Action.RIGHT;
      }
   }
}