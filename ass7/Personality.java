// Xuqing Wu
// 11/19/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #7
//
// This program will read the file of personality data that user
// types in and then sort these data by names and types. The programe 
// will finally create an output file with all these information.

import java.util.*;
import java.io.*;

public class Personality{
   public static final int NUMBER = 4;
   public static void main(String[] args) throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      introduction();      
      File inputFile = inputFile(console);
      Scanner input = new Scanner(inputFile);
      PrintStream outputFile = outputFile(console);
      while(input.hasNextLine()){
         String name = input.nextLine();
         String choiceTotal = input.nextLine();
         String[] splited = splitParts(choiceTotal);
         int[] percentage = countsOfAB(splited);
         String[] type = classification(percentage);
         printResult(outputFile, name, percentage, type);
      }      
   }
   
   //This method prints out the introduction of this program to the user
   public static void introduction(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the"); 
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //This method asks the input file name from user
   //it then returns the input file
   //Scanner console - to ask the input file name from user
   public static File inputFile(Scanner console) throws FileNotFoundException{
      System.out.print("input file name? ");
      File inputFile = new File(console.nextLine());
      return inputFile;
   }
   
   //This method asks the output file name from user
   //it then creates the output file and return it
   //Scanner console - to ask the output file name from user
   public static PrintStream outputFile(Scanner console) throws FileNotFoundException{
      System.out.print("output file name? ");
      String outputFileName = console.nextLine();
      PrintStream outputFile = new PrintStream(new File(outputFileName));
      return outputFile;
   }      
   
   //this method split the 70 characters into one array with 4 elements
   //it then returns the array
   //String line - the single row after name line we get from main 
   public static String[] splitParts(String line){
      String[] fourParts = new String[NUMBER];      
      for(int i=0; i<10; i++){
         fourParts[0] += line.substring(0,1);
         fourParts[1] += line.substring(1,3);
         fourParts[2] += line.substring(3,5);
         fourParts[3] += line.substring(5,7);
         if(i<=8){
            line = line.substring(7);
         }
      }
      return fourParts;
   }
   
   //This method calculate the percentage of B
   //it creates three arrays, each with 4 elements
   //then for each type of personality, it calculates the percentage
   //it returns the percentage
   //String[] splited - the array with 4 elements(choices for each type of personality)
   public static int[] countsOfAB(String[] splited){   
      int[] numberOfA = new int[NUMBER];
      int[] numberOfB = new int[NUMBER]; 
      int[] percentage = new int[NUMBER];              
      for(int i=0; i<NUMBER; i++){
         String choice = splited[i];
         for(int j=0; j<choice.length(); j++){
            char choiceSingle = choice.charAt(j);
            if(choiceSingle==('A')||choiceSingle==('a')){
               numberOfA[i]++;
            }
            else if(choiceSingle==('B')||choiceSingle==('b')){
               numberOfB[i]++;
            }
         }
         double percent = 100.0*numberOfB[i]/(numberOfB[i]+numberOfA[i]);
         percentage[i] = (int)Math.round(percent);
      }
      return percentage;     
   }
   
   //This method determines the type of personality of each person
   //it returns the personality as an array of string
   //int[] percentage - the percentage of B choices in each personality type
   public static String[] classification(int[] percentage){
      String[] type = {"I","N","F","P"};
      for(int i=0; i<NUMBER; i++){
         if(percentage[i]<50){
            if(type[i].equals("I")){
               type[i]="E";
            }
            if(type[i].equals("N")){
               type[i]="S";
            }
            if(type[i].equals("F")){
               type[i]="T";
            }
            else if(type[i].equals("P")){
               type[i]="J";
            }
         }
         else if(percentage[i]==50){
            type[i]="X";
         }
      }
      return type;
   }
   
   //This method prints the name, percantage, and personality to the output file
   //PrintStream outputFile - to print result to output file
   //String name - the name of the person we get from main
   //int[] percentage - the percentage of B for each personality type
   //String[] type - an array of the type of personality
   public static void printResult(PrintStream outputFile, String name, 
   int[] percentage, String[] type){
      String typeFinal = type[0]+type[1]+type[2]+type[3];      
      outputFile.print(name + ": ");
      outputFile.print(Arrays.toString(percentage));
      outputFile.print(" = " + typeFinal);
      outputFile.println();
   }
}           