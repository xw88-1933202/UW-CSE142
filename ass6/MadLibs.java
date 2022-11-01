// Xuqing Wu
// 11/11/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #6
//
// This program will show a game madlib, users can type the name of files for
// input and output. They will then type words to replace placeholders in the
// input file. Users can create, view the madlib or quit the game.

import java.io.*;
import java.util.*;

public class MadLibs{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		intro();
      String choice = "";
		while(!choice.equals("q")){
			System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
			choice = console.nextLine().toLowerCase();
			if(choice.equals("c")){
            File file = inputFile(console);
				PrintStream output = outputFile(console);
            replace(file, output, console);
			} 
         else if(choice.equals("v")){
				File file = inputFile(console);
				view(file, console);
			}
		}
	}
   
   //type the introduction of the game
   public static void intro(){
		System.out.println("Welcome to the game of Mad Libs.");
		System.out.println("I will ask you to provide various words");
		System.out.println("and phrases to fill in a story.");
		System.out.println("The result will be written to an output file.");
      System.out.println();
	}
   
   //let user type file names until the file exists and return file
   //Scanner console - Scanner to get the name of input file
   public static File inputFile(Scanner console){
		System.out.print("Input file name: ");
		File file = new File(console.nextLine());
		while (!file.exists()){
			System.out.print("File not found. Try again: ");
			file = new File(console.nextLine());
		}
		return file;
	}
	
   //let user type output file name and return PrintStream output - the output file
   //Scanner console - Scanner to get the name of output file   
	public static PrintStream outputFile(Scanner console) throws FileNotFoundException{
		System.out.print("Output file name: ");
		String outputFile = console.nextLine();
		PrintStream output = new PrintStream(new File(outputFile));
      System.out.println();
		return output;
	}
   
   //let user type words to replace placeholders and saves them to the output file
   //File file - input file
   //PrintStream output - output file
   //Scanner console - Scanner to get the input file content
	public static void replace(File file, PrintStream output, Scanner console) throws 
   FileNotFoundException{
		Scanner input = new Scanner(file);
		while(input.hasNextLine()){
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()){
				String word = lineScan.next();
				if(word.startsWith("<") && word.endsWith(">")){
					word = word.substring(1, word.length() - 1);
					word = word.replace("-", " ");
               String first = word.toLowerCase();
               if(first.startsWith("a") || first.startsWith("e") || first.startsWith("i") 
                  || first.startsWith("o") || first.startsWith("u")){
					   System.out.print("Please type an " + word + ": ");
					} 
               else{
						System.out.print("Please type a " + word + ": ");
					}
					String newWord = console.nextLine();
					output.print(newWord + " ");
				} 
            else{
					output.print(word + " ");
            }
			}
			output.println();
		}
      System.out.println("Your mad-lib has been created!");
      System.out.println();
	}
   
   //show the created mad-lib
   //File file - input file
   //Scanner console - Scanner to get the viewed file
   public static void view(File file, Scanner console) throws FileNotFoundException{
		System.out.println();
		console = new Scanner(file);
		while (console.hasNextLine()){
			String row = console.nextLine();
			System.out.println(row);
		}
		System.out.println();    
	}
}