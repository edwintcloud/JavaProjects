//Edwin Cloud
//Program 1

import java.lang.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class program1 {

//static vars
   static Matrix A = new Matrix(4);
   static Matrix B = new Matrix(4);
   static Matrix C = new Matrix(4);

   public static void main (String[] args) { 	 
   
      int numb = 0;
   
   //purpose and table
      System.out.println("**************************************");
      System.out.println("***     This is a menu-driven      ***");
      System.out.println("***     program that performs      ***");
      System.out.println("***    various operations on a     ***");
      System.out.println("***    set of three dimensional    ***");
      System.out.println("***           matrices.            ***");
      System.out.println("**************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Use Data File");
         System.out.println("2. Enter data manually");
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
            case 2: path2();
               break;
            case 3: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 3);
   }
   static void path1() {
   
   //read from data file
      A = new Matrix(3);
      B = new Matrix(3);
      C = new Matrix(3);
      try{
         Scanner fr = new Scanner(new FileReader("matrixdata.txt"));
         for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++)
               A.set(i,j,fr.nextDouble());
         }
         for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++)
               B.set(i,j,fr.nextDouble());
         }
         fr.close();
      
      }
      catch(FileNotFoundException e) {
         System.out.println("***File Not Found!***");
      }
      
   //display matrices
      switch(A.getSize()) {
         case 3: 
            System.out.print("   ");
            A.printRow(0);
            System.out.print("    ");
            B.printRow(0);
            System.out.println();
            System.out.print("A =");
            A.printRow(1);
            System.out.print(" B =");
            B.printRow(1);
            System.out.println();
            System.out.print("   ");
            A.printRow(2);
            System.out.print("    ");
            B.printRow(2);
            System.out.println();
            break;
               
         case 4:
            System.out.print("   ");
            A.printRow(0);
            System.out.print("    ");
            B.printRow(0);
            System.out.println();
            System.out.print("A =");
            A.printRow(1);
            System.out.print(" B =");
            B.printRow(1);
            System.out.println();
            System.out.print("   ");
            A.printRow(2);
            System.out.print("    ");
            B.printRow(2);
            System.out.println();
            System.out.print("   ");
            A.printRow(3);
            System.out.print("    ");
            B.printRow(3);
            System.out.println();
            break;
         default:
            break;
      }
   
   
   //display option menu
      menu();
   
   }
   static void path2() {
      int numb = 0;
      do {
         System.out.print("\n");
         System.out.println("1. Use 3D Matrices");
         System.out.println("2. Use 4D Matrices");
         System.out.println("3. Back to Main Menu");
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
            case 1: A = new Matrix(3);
               B = new Matrix(3);
               C = new Matrix(3);
               setMatrices(3);
               menu();
               break;
            case 2: A = new Matrix(4);
               B = new Matrix(4);
               C = new Matrix(4);
               setMatrices(4);
               menu();
               break;
            case 3: 
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 3);
         
   }
   static void menu() {
      int numb = 0;
      do {
         System.out.print("\n");
         System.out.println("1. Replacement");
         System.out.println("2. Addition");
         System.out.println("3. Subtraction");
         System.out.println("4. Scalar Multiplication");
         System.out.println("5. Multiplication");
         System.out.println("6. Replace by constant 0");
         System.out.println("7. Replace by constant 1");
         System.out.println("8. Identity");
         System.out.println("9. Transpose");
         System.out.println("10. Inverse");
         System.out.println("11. Go Back");
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
            case 1: C = A;
               printC();
               break;
            case 2: C = A.plus(B);
               altPrint(C.getSize(),"+");
               break;
            case 3: C = A.minus(B);
               altPrint(C.getSize(),"-");
               break;
            case 4: C = A.times(3);
               switch(C.getSize()) {
                  case 3: 
                     System.out.print("       ");
                     A.printRow(0);
                     System.out.print("  ");
                     C.printRow(0);
                     System.out.println();
                     System.out.print("C = 3 *");
                     A.printRow(1);
                     System.out.print(" =");
                     C.printRow(1);
                     System.out.println();
                     System.out.print("       ");
                     A.printRow(2);
                     System.out.print("  ");
                     C.printRow(2);
                     System.out.println();
                     break;
               
                  case 4:
                     System.out.print("       ");
                     A.printRow(0);
                     System.out.print("  ");
                     C.printRow(0);
                     System.out.println();
                     System.out.print("C = 3 *");
                     A.printRow(1);
                     System.out.print(" =");
                     C.printRow(1);
                     System.out.println();
                     System.out.print("       ");
                     A.printRow(2);
                     System.out.print("  ");
                     C.printRow(2);
                     System.out.println();
                     System.out.print("       ");
                     A.printRow(3);
                     System.out.print("  ");
                     C.printRow(3);
                     System.out.println();
                     break;
                  default:
                     break;
               }
               break;
            case 5: C = A.times(B);
               altPrint(C.getSize(),"*");
               break;
            case 6: C.setAll(0);
               printC();
               break;
            case 7: C.setAll(1);
               printC();
               break;
            case 8: C = C.identity();
               printC();
               break;
            case 9: C = A.transpose();
               printC();
               break;
            case 10: C = B.inverse();
               printC();
               break;
            case 11: 
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 11);
   
   }
   
   static void altPrint(int size, String symbol) {
      switch(size) {
         case 3: 
            System.out.print("    ");
            A.printRow(0);
            System.out.print("  ");
            B.printRow(0);
            System.out.print("  ");
            C.printRow(0);
            System.out.println();
            System.out.print("C = ");
            A.printRow(1);
            System.out.print(" " + symbol);
            B.printRow(1);
            System.out.print(" =");
            C.printRow(1);
            System.out.println();
            System.out.print("    ");
            A.printRow(2);
            System.out.print("  ");
            B.printRow(2);
            System.out.print("  ");
            C.printRow(2);
            System.out.println();
            break;
      
         case 4:
            System.out.print("    ");
            A.printRow(0);
            System.out.print("  ");
            B.printRow(0);
            System.out.print("  ");
            C.printRow(0);
            System.out.println();
            System.out.print("C = ");
            A.printRow(1);
            System.out.print(" " + symbol);
            B.printRow(1);
            System.out.print(" =");
            C.printRow(1);
            System.out.println();
            System.out.print("    ");
            A.printRow(2);
            System.out.print("  ");
            B.printRow(2);
            System.out.print("  ");
            C.printRow(2);
            System.out.println();
            System.out.print("    ");
            A.printRow(3);
            System.out.print("  ");
            B.printRow(3);
            System.out.print("  ");
            C.printRow(3);
            System.out.println();
            break;
         default:
            break;
      }
   }
   
   static void printC() {
      switch(C.getSize()) {
         case 3: 
            System.out.print("   ");
            C.printRow(0);
            System.out.println();
            System.out.print("C =");
            C.printRow(1);
            System.out.println();
            System.out.print("   ");
            C.printRow(2);
            System.out.println();
            break;
               
         case 4:
            System.out.print("   ");
            C.printRow(0);
            System.out.println();
            System.out.print("C =");
            C.printRow(1);
            System.out.println();
            System.out.print("   ");
            C.printRow(2);
            System.out.println();
            System.out.print("   ");
            C.printRow(3);
            System.out.println();
            break;
         default:
            break;
      }
   }
   static void setMatrices(int a) {
      System.out.println("Let's give our new Matrices some values\n");
      Scanner scan = new Scanner(System.in);
      for(int i=0;i<a;i++) {
         for(int j=0;j<a;j++) {
            System.out.print("Matrix A: [" + i + "][" + j + "] = ");
            A.set(i,j,scan.nextDouble());
            System.out.println();
         }
      }
      for(int i=0;i<a;i++) {
         for(int j=0;j<a;j++) {
            System.out.print("Matrix B: [" + i + "][" + j + "] = ");
            B.set(i,j,scan.nextDouble());
            System.out.println();
         }
      }  
   }
}







