//Edwin Cloud
//Program 2 - PG 636 #11

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class program2 {

//initialize an array to hold the data from text file
   static int[][] data = new int[12][2];
   
   public static void main(String[] args) {
   
    //purpose and table
      System.out.println("************************************");
      System.out.println("***     This is a menu-driven    ***");
      System.out.println("***   program that find the low  ***");
      System.out.println("***      and high temperature    ***");
      System.out.println("***  of each month, the averages ***");
      System.out.println("***   of each, and displays that ***");
      System.out.println("***         information.         ***");
      System.out.println("************************************");   
      
      //Read from text file into array
      try {
         Scanner fs = new Scanner(new FileReader("program2data.txt"));
         for (int i=0;i<12;i++) {
            for(int j=0;j<2;j++) {
               data[i][j] = fs.nextInt();
            }
         }
         fs.close();
      }
      catch(FileNotFoundException e) {
         System.out.println("***File not found!!***");
      }
   
      int numb = 0;
   
      do {
         System.out.print("\n");
         System.out.println("1. Display temperatures");
         System.out.println("2. Find the average high temperature of the year");
         System.out.println("3. Find the average low temperature of the year");
         System.out.println("4. Month of the highest temperature");
         System.out.println("5. Month of the lowest temperature");
         System.out.println("6. Exit this Program");
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
            case 1: getData();
               break;
            case 2: method2();
               break;
            case 3: method3();
               break;
            case 4: method4();
               break;
            case 5: method5();
               break;
            case 6: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 6);
   
   }
   
   static void getData() {
      System.out.printf("%15s%6s%n","Low","High");
      for (int i=0;i<12;i++) {
         System.out.printf("%-10s",getMonth(i));
         for(int j=0;j<2;j++)
            System.out.printf("%4d ",data[i][j]);
         System.out.printf("%n");
      }
   }
   static String getMonth(int r) {
      switch(r) {
         case 0: 
            return "January";
         case 1: 
            return "February";
         case 2: 
            return "March";
         case 3: 
            return "April";
         case 4: 
            return "May";
         case 5: 
            return "June";
         case 6: 
            return "July";
         case 7: 
            return "August";
         case 8: 
            return "September";
         case 9: 
            return "October";
         case 10: 
            return "November";
         case 11: 
            return "December";
         default: 
            return "";
      }
   }  
   static void method2() {
      System.out.printf("%15s%n","High");
      for (int i=0;i<12;i++)
         System.out.printf("%-10s%4d %n",getMonth(i),data[i][1]);
      System.out.printf("%nThe average highest temperature is: %d%n", averageHigh());
   }
   
   static void method3() {
      System.out.printf("%15s%n","Low");
      for (int i=0;i<12;i++)
         System.out.printf("%-10s%4d %n",getMonth(i),data[i][0]);
      System.out.printf("%nThe average lowest temperature is: %d%n", averageLow());
   }
   
   static void method4() {
       System.out.printf("The month with the highest temperature is: %s%n", getMonth(indexHighTemp()));
       System.out.printf("%43s%d%n", "With a temperature of: ",data[indexHighTemp()][1]);
   }
   
   static void method5() {
       System.out.printf("The month with the lowest temperature is: %s%n", getMonth(indexLowTemp()));
       System.out.printf("%42s%d%n", "With a temperature of: ",data[indexLowTemp()][0]);
   }
   
   static int averageHigh() {
      double sum = 0.0;
      for (int i=0;i<12;i++)
         sum += data[i][1];
      return (int)((sum/12)+.5);
   }
   
   static int averageLow() {
      double sum = 0.0;
      for (int i=0;i<12;i++)
         sum += data[i][0];
      return (int)((sum/12)+.5);
   }
   
   static int indexHighTemp() {
      int index = 0;
      int highest = data[0][1];
      for (int i=0;i<12;i++) {
         if(data[i][1] >= highest) {
            highest = data[i][1];
            index = i;
         }
      }
      return index;
   }
   
   static int indexLowTemp() {
      int index = 0;
      int lowest = data[0][0];
      for (int i=0;i<12;i++) {
         if(data[i][0] <= lowest) {
            lowest = data[i][0];
            index = i;
         }
      }
      return index;
   }
}