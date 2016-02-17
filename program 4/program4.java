//Edwin Cloud
//Program 4

import java.util.Scanner;

public class program4 {
         
   public static void main(String[] args) {
   
      int numb = 0;
   
   //purpose and table
      System.out.println("**************************************");
      System.out.println("***     This is a menu-driven      ***");
      System.out.println("***     program that performs      ***");
      System.out.println("***   four different operations    ***");
      System.out.println("***     using a seperate class     ***");
      System.out.println("***              file.             ***");
      System.out.println("**************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Find Area of a Trapezoid");
         System.out.println("2. Find Surface Area of a Cylinder");
         System.out.println("3. Find Volume of a Sphere");
         System.out.println("4. Calculate Compound Interest");
         System.out.println("5. Exit this Program");
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
            case 1: method1();
               break;
            case 2: method2();
               break;
            case 3: method3();
               break;
            case 4: method4();
               break;
            case 5: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 5);
   }

   static void method1() {
      Scanner scan = new Scanner(System.in);
      System.out.print("How long  is the top? : ");
      double a = scan.nextDouble();
      System.out.print("\nHow long  is the bottom? : ");
      double b = scan.nextDouble();
      System.out.print("\nWhat is the height? : ");
      double c = scan.nextDouble();
      p4Class r = new p4Class(a,b,c);
      System.out.println("\nAnswer: " + r.areaT());
   }
   
   static void method2() {
      Scanner scan = new Scanner(System.in);
      System.out.print("What is the radius? : ");
      double a = scan.nextDouble();
      System.out.print("\nWhat is the height? : ");
      double b = scan.nextDouble();
      p4Class r = new p4Class(a,b);
      System.out.println("\nAnswer: " + r.areaC());
   }
   
   static void method3() {
      Scanner scan = new Scanner(System.in);
      System.out.print("What is the radius? : ");
      double a = scan.nextDouble();
      p4Class r = new p4Class(a);
      System.out.println("\nAnswer: " + r.volume());
   }
   
   static void method4() {
      Scanner scan = new Scanner(System.in);
      System.out.print("What is the Principal Amount? : ");
      double a = scan.nextDouble();
      System.out.print("What is the percent interest (rate)? : ");
      double b = scan.nextDouble();
      System.out.print("How often will it be compounded (period)? : ");
      double c = scan.nextDouble();
      System.out.print("What is the duration in years? : ");
      double d = scan.nextDouble();
      p4Class r = new p4Class(a,b,c,d);
      System.out.println("\nAnswer: " + r.interest());
   }
}