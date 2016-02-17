//Edwin Cloud
//Program 9
//This is a skeleton! The main operation is in the class file Payroll

import java.util.Scanner;

public class program9 {

   public static void main (String[] args) { 	 
   
      int numb = 0;
   
   //purpose and table
      System.out.println("**************************************");
      System.out.println("***     This is a menu-driven      ***");
      System.out.println("***     program that performs      ***");
      System.out.println("***      a payroll report on       ***");
      System.out.println("***    two supplied data files.    ***");
      System.out.println("**************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Print Payroll Report");
         System.out.println("2. Print Error and Control Report");
         System.out.println("3. Exit this Program");
         System.out.print("\nPlease make a selection: ");
       
      //Inputs a scanner to accept infomation coming in from the keyboard
         Scanner scan = new Scanner(System.in);
         boolean bErr = true;
         while(bErr) {
            if (scan.hasNextInt()) {
               numb = scan.nextInt();
            } 
            else {
               System.out.print("\nPlease enter a number... : ");
               scan.next();
               continue;
            }
            bErr = false;
         }
      	 
         System.out.print("\n");
       
      //here is my switch
         switch(numb) {
            case 1: path1();
               break;
            case 2: System.out.println("This function has not yet been implemented. This is probably because it is useless!");
               break;
            case 3: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 3);
   }
   static void path1() {
      Payroll pr = new Payroll();
      pr.printPayroll();
   }
}







