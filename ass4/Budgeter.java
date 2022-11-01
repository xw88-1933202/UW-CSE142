// Xuqing Wu
// 10/19/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #4
//
// This program will show net income.

// scanner concole: get response from users
// totalIncome: the monthly income user types in
// choice: the monthly or daily choice
// totalExpense: the monthly or daily expense user types in
// expenseTotal: the monthly expense

import java.util.*;
public class Budgeter{
   public static final int DAYS = 31;
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      intro();
      double totalIncome = money(console, "income");
      int choice = choice(console);
      double totalExpense = money(console, "expense");
      double expenseTotal = print(choice, totalExpense, totalIncome);
      compare(totalIncome, expenseTotal);
   }
   
   //round numbers to two decimal places
   public static double round(double num){
      return Math.round(num*100)/100.0;
   }
      
   //print the introduction of the programe
   public static void intro(){
      System.out.println("This program asks for your monthly income and ");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
      
   //get the total income and expense values
   public static double money(Scanner console, String money){
      System.out.print("How many categories of " + money + "? ");
      int numCate = console.nextInt();
      double total = 0;
      for(int i=0; i<numCate; i++){
          System.out.print("    Next "+ money + " amount? $");
          double single  = console.nextDouble();
          total += single;
      }
      System.out.println();
      return total;
   }
   
   //get choice of monthly or daily
   public static int choice(Scanner console){
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int choice = console.nextInt();
      return choice;
   }

   //print total and daily income and expense
   public static double print(int choice, double total, double inTot){
      double exTot;
      double exDay;
      if(choice == 1){
         exTot = total;
         exDay = total/DAYS;
      }
      else{
         exTot = total*DAYS;
         exDay = total;
      }
      double inDay = inTot/DAYS;
      System.out.println("Total income = $" + round(inTot) + " ($" + round(inDay) + "/day)");
      System.out.println("Total expenses = $" + round(exTot) + " ($" + round(exDay) + "/day)");
      System.out.println();
      return exTot;
   }
   
   //compare the income and expense, and give comments
   public static void compare(double in, double out){
      double d = in - out;
      String b = "saver";
      String a = "more";
      if(d>0){
         if(d>250){
            b = "big saver";
            a = "much more";
         }
         System.out.println("You earned $" + round(d) + " more than you spent this month."); 
         System.out.println("You're a " + b + ".");
         System.out.println("You may spend " + a + ".");
      }else{
         if(d<-250){
            b = "big spender";
            a = "much less";
         }else{
            b = "spender";
            a = "less";
         }
         System.out.println("You spent $" + round(Math.abs(d)) + " more than you earned this month."); 
         System.out.println("You're a " + b + ".");
         System.out.println("You must spend " + a + ".");
      }
   }
}