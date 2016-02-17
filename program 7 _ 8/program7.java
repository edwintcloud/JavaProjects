//Edwin Cloud
//Program 7

import java.util.Scanner;

class program7 {
   
   static int bb = 0;
   static Scanner scan = new Scanner(System.in);
   
   public static void main(String[] args) {
   
      int numb = 0;
   
   //purpose and table
      System.out.println("***************************************");
      System.out.println("***      This is a menu-driven      ***");
      System.out.println("***   program containing problems   ***");
      System.out.println("***   1-3, and 6 on pg. 358 in the  ***");
      System.out.println("***    Data Structures textbook.    ***");
      System.out.println("***************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Problem 1 (stars in order)");
         System.out.println("2. Problem 2 (stars in reverse order)");
         System.out.println("3. Problem 3 (stars in format of a diamond)");
         System.out.println("4. Problem 6 (recursive isPalindrome)");
         System.out.println("5. Exit this Program");
         System.out.print("\nPlease make a selection: ");
       
      //Inputs a scanner to accept infomation coming in from the keyboard
         boolean bErr = true;
         while(bErr) {
            if (scan.hasNextInt()) {
               numb = scan.nextInt();
            } 
            else {
               System.out.print("\nPlease make a selection: ");
               scan.next();
               continue;
            }
            bErr = false;
         }
      	 
         System.out.print("\n");
       
      //here is my switch
         switch(numb) {
            case 1: System.out.print("How many stars?: ");
               bb = scan.nextInt();
               System.out.println();
               p1(bb);
               break;
            case 2: System.out.print("How many stars?: ");
               bb = scan.nextInt();
               System.out.println();
               p2(bb);
               break;
            case 3: System.out.print("How many stars?: ");
               bb = scan.nextInt();
               System.out.println();
               p3(bb);
               break;
            case 4: System.out.print("Enter a string: ");
               String pal = scan.next();
               if(isPalindrome(pal) == true)
                  System.out.println("\nThe string " + pal + " is a palindrome.");
               else
                  System.out.println("\nThe string " + pal + " is NOT a palindrome.");
               break;
            case 5: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 5);   
   }
   
   //n stars to 1 star then pop stack
   static void p1(int n) {
      for(int i=0; i<n; i++) 
         System.out.print("*");
      System.out.println();
      if (n > 1)
         p1(n - 1);
      for(int i=0; i<n; i++) 
         System.out.print("*");
      System.out.println();
   }
   
   //1 star to n stars then pop stack
   static void p2(int n) {
      for(int i=bb; i>=n; i--) 
         System.out.print("*");
      System.out.println();
      if (n > 1)
         p2(n - 1);
      for(int i=bb; i>=n; i--) 
         System.out.print("*");
      System.out.println();
   }
   
   //diamond of stars with a width of n
   static void p3(int n) {
      for(int i=0; i<=n; i++) 
         System.out.print(" ");
      for(int i=bb; i>n; i--) 
         System.out.print("* ");
      System.out.println();
      if (n > 1)
         p3(n - 1);
      for(int i=0; i<n; i++) 
         System.out.print(" ");
      for(int i=bb; i>=n; i--) 
         System.out.print("* ");
      System.out.println();
   }
   
   static boolean isPalindrome(String p) {
   
      //check length; if recursively executes until 1 or 0 then the string is indeed a palindrome
      if(p.length() == 0 || p.length() == 1)
         return true;
         
      //our recursive if statement, check first and last and reduce moving inward until all letters are matched.
      if(p.charAt(0) == p.charAt(p.length()-1))
         //run method using resulting substring after trimming first and last
         return isPalindrome(p.substring(1,p.length()-1));
         
      //default return of false
      return false;
   }
}