//Edwin Cloud
//Program 3

//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class program3 {

   static int sw = 0;
//our vars
   static char[][] data = new char[13][6];
   public static void main(String[] args) {
   	
      try {
         Scanner fread = new Scanner(new FileReader("program3data.txt"));
         for(int i=0;i<13;i++){
            for(int j=0;j<6;j++){
               String g = fread.next();
               data[i][j] = g.charAt(0);
            }
         }
         fread.close();
      }
      catch(FileNotFoundException e) {
         System.out.println("***File Not Found!***");
      }
      
      int numb = 0;
      sw = 1;
      
   //purpose and table
      System.out.println("************************************");
      System.out.println("***     This is a menu-driven    ***");
      System.out.println("***     program that allows a    ***");
      System.out.println("***     user to request seats    ***");
      System.out.println("***      for an airplane and     ***");
      System.out.println("***    displays a seating chart. ***");
      System.out.println("************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Request a Seat");
         System.out.println("2. Display Seating Chart");
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
            case 1: method1();
               break;
            case 2: print();
               break;
            case 3: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 3);
   }
	
   static void method1(){
      int numb = 0;
      do {
         System.out.print("\nWhat type of seat would you like?\n");
         System.out.println("1. First Class");
         System.out.println("2. Business Class");
         System.out.println("3. Economy Class");
         System.out.println("4. Go Back");
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
            case 1: fc();
               break;
            case 2: bc();
               break;
            case 3: ec();
               break;
            case 4:
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 4 && sw != 1);
   }
	
   static void fc() {
      sw = 0;
      String avb = "";
      ArrayList<Integer> list1 = new ArrayList<Integer>();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      System.out.println();
      for(int i=0;i<2;i++){
         for(int j=0;j<6;j++){
            if(data[i][j] == '*') {
               avb += "Row " + (i+1) + " Seat " + toLetter(j) + ",";
               list1.add(i);
               list2.add(j);  
            }
         }
      }
      String[] info = avb.split(",");
      Integer[] row = list1.toArray(new Integer[list1.size()]);
      Integer[] seat = list2.toArray(new Integer[list2.size()]);
      int numb = 0;
      do {
         System.out.print("\nPick an available seat\n");
         for(int i=0;i<info.length;i++){
            System.out.println((i+1) + ". " + info[i]);
         }
         System.out.println((info.length+1) + ". Go Back");
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
       
         if(numb > info.length || numb < 1) {
            System.out.println("\nPlease follow the directions...");
         }
         else{
            data[row[numb-1]][seat[numb-1]] = 'X';
            System.out.println("You have reserved your seat.");
            numb = (info.length+1);
            sw = 1;
         }
      }while(numb != (info.length+1)); 
   }
   static void bc() {
      sw = 0;
      String avb = "";
      ArrayList<Integer> list1 = new ArrayList<Integer>();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      System.out.println();
      for(int i=2;i<7;i++){
         for(int j=0;j<6;j++){
            if(data[i][j] == '*') {
               avb += "Row " + (i+1) + " Seat " + toLetter(j) + ",";
               list1.add(i);
               list2.add(j);  
            }
         }
      }
      String[] info = avb.split(",");
      Integer[] row = list1.toArray(new Integer[list1.size()]);
      Integer[] seat = list2.toArray(new Integer[list2.size()]);
      int numb = 0;
      do {
         System.out.print("\nPick an available seat\n");
         for(int i=0;i<info.length;i++){
            System.out.println((i+1) + ". " + info[i]);
         }
         System.out.println((info.length+1) + ". Go Back");
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
       
         if(numb > info.length || numb < 1) {
            System.out.println("\nPlease follow the directions...");
         }
         else{
            data[row[numb-1]][seat[numb-1]] = 'X';
            System.out.println("You have reserved your seat.");
            numb = (info.length+1);
            sw = 1;
         }
      }while(numb != (info.length+1)); 
   }
   static void ec() {
      sw = 0;
      String avb = "";
      ArrayList<Integer> list1 = new ArrayList<Integer>();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      System.out.println();
      for(int i=7;i<13;i++){
         for(int j=0;j<6;j++){
            if(data[i][j] == '*') {
               avb += "Row " + (i+1) + " Seat " + toLetter(j) + ",";
               list1.add(i);
               list2.add(j);  
            }
         }
      }
      String[] info = avb.split(",");
      Integer[] row = list1.toArray(new Integer[list1.size()]);
      Integer[] seat = list2.toArray(new Integer[list2.size()]);
      int numb = 0;
      do {
         System.out.print("\nPick an available seat\n");
         for(int i=0;i<info.length;i++){
            System.out.println((i+1) + ". " + info[i]);
         }
         System.out.println((info.length+1) + ". Go Back");
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
       
         if(numb > info.length || numb < 1) {
            System.out.println("\nPlease follow the directions...");
         }
         else{
            data[row[numb-1]][seat[numb-1]] = 'X';
            System.out.println("You have reserved your seat.");
            numb = (info.length+1);
            sw = 1;
         }
      }while(numb != (info.length+1)); 
   }
   
   static void print() {
      System.out.printf("%19s%n", "A B C D E F");
      for(int i=0;i<13;i++){
         System.out.printf("Row %-3d", (i+1));
         for(int j=0;j<6;j++){
            System.out.printf("%2c", data[i][j]);
         }
         System.out.printf("%n");
      }
   }

   static String toLetter(int a) {
      switch(a) {
         case 0:
            return "A";
         case 1:
            return "B";
         case 2:
            return "C";
         case 3:
            return "D";
         case 4:
            return "E";
         case 5:
            return "F";
         default:
            return "";
      }  
   }
}