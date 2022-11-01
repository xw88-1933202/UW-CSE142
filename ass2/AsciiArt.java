// Xuqing Wu
// 10/5/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #2 PartA
//
// This program will show a sequence of cute emogi.

public class AsciiArt{
   public static final int SIZE=4;
   public static void main(String[] args){
      for(int line=1;line<=SIZE;line++){
         for(int j=1;j<=-line+5;j++){
            System.out.print("  ");
         }
         for(int j=1;j<=-2*line+2*SIZE;j++){
            System.out.print("(-_-)");
         }
         for(int j=1;j<=5*line-SIZE*1;j++){
            System.out.print("(∩_∩)");
         }
         for(int j=1;j<=-2*line+2*SIZE;j++){
            System.out.print("(-_-)");
         }
      System.out.println();
      } 
   }    
}