// Xuqing Wu
// 10/27/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #5
//
// This program will show an guessing game and calculate statistics.

import java.util.*;  //to use Scanner and Random

public class GuessingGame{
   public static final int TOTAL = 100;  //control range of random integers
   
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      intro();
      int guessTime = guess(console, rand);
      int timeMin = guessTime;
      int gameTime = 1;
      String choice = choice(console);
      
      //judge whether response given by users means play again or not
      while(choice.toUpperCase().charAt(0)=='Y'){
         gameTime++;
         int moreTime = guess(console, rand);
         timeMin = Math.min(timeMin, moreTime);
         guessTime += moreTime;
         choice = choice(console);
      }
      print(gameTime, guessTime, timeMin);
   }
   
   //print the introduction in the form of a haiku
   public static void intro(){
      System.out.println("Let's have a guess now");
      System.out.println("It is not very difficult");
      System.out.println("Are you ready guys?");
      System.out.println();
   }
   
   //process of guessing and return the value of total guessing times
   //Scanner console - to get the guesses from users
   //Random rand - to generate an integer which is the answer
   public static int guess(Scanner console, Random rand){
      System.out.println("I'm thinking of a number between 1 and " + TOTAL + " ...");
      int answer = rand.nextInt(TOTAL)+1;
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int time = 1;
      while(guess!=answer){
         time++;
         if(guess>answer){
            System.out.println("It's lower.");
         }
         else{
            System.out.println("It's higher.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
      }
      String lastWord;
      if(time == 1){
         lastWord = " guess!";
      }
      else{
         lastWord = " guesses!";
      }
      System.out.println("You got it right in "+ time + lastWord);
      return time;
   }
   
   //use Scanner to get the response from user and return response
   //Scanner console - get the choice from user whether to play again
   public static String choice(Scanner console){
      System.out.print("Do you want to play again? ");
      String choice = console.next();
      System.out.println();
      return choice;
   }
   
   //print the statistics of the game
   //gameTime - the total guessing games user played
   //guessTime - the total guessing times of all games
   //timeMin - the minimum amount of guesses
   public static void print(int gameTime, int guessTime, int timeMin){
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gameTime);
      System.out.println("Total guesses = " + guessTime);
      System.out.print("Guesses/game  = ");
      double average = 1.0*guessTime / gameTime;
      System.out.printf("%.1f", average);
      System.out.println();
      System.out.println("Best game     = " + timeMin);
   }
}