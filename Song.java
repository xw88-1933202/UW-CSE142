// Xuqing Wu
// 9/29/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #1
//
// This program will show a very hateful song.
public class Song{
   public static void main(String[] args){
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      verse7();
   }
   
   public static void verse1(){
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
      ld();
      System.out.println();
   }
   
   public static void verse2(){  
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
      fly();
      ld();
      System.out.println();
   }
      
   public static void verse3(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
      spider();
      fly();
      ld();
      System.out.println();
   }
      
   public static void verse4(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat();
      bird();
      spider();
      fly();
      ld();
      System.out.println();
   }
      
   public static void verse5(){
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog();
      cat();
      bird();
      spider();
      fly();
      ld();
      System.out.println();
   }
      
   public static void verse6(){
      System.out.println("There was an old woman who swallowed a wolf,");
      System.out.println("which needs to get hair off");
      System.out.println("She swallowed the wolf to catch the dog,");
      dog();
      cat();
      spider();
      fly();
      ld();
      System.out.println();
   }
      
   public static void verse7(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }


   public static void ld(){
      System.out.println("Perhaps she'll die.");
   }
   
   public static void fly(){
      System.out.println("I don't know why she swallowed that fly,");
   }
      
   public static void spider(){
      System.out.println("She swallowed the spider to catch the fly,");
   }
      
   public static void bird(){
      System.out.println("She swallowed the bird to catch the spider,");
   }
      
   public static void cat(){
      System.out.println("She swallowed the cat to catch the bird,");
   }
      
   public static void dog(){
      System.out.println("She swallowed the dog to catch the cat,");
   }
}
   
   
      
      
      
    