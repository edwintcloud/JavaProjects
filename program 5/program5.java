//Edwin Cloud
//Program 5

//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

class program5 {

   static ArrayList<String> data = new ArrayList<String>();
   static Scanner scan = new Scanner(System.in);
   
   public static void main(String[] args) {
   	
      try {
         Scanner fread = new Scanner(new FileReader("program5data.txt"));
         while(fread.hasNext())
            data.add(fread.nextLine());
         fread.close();
      
      }
      catch(FileNotFoundException e) {
         System.out.println("***File Not Found!!***");
      }
      
      int numb = 0;
      
   //purpose and table
      System.out.println("************************************");
      System.out.println("***     This is a menu-driven    ***");
      System.out.println("***     program that utilizes    ***");
      System.out.println("***  an ArrayList to dynamically ***");
      System.out.println("***    manage an input file and  ***");
      System.out.println("***      its contained data.     ***");
      System.out.println("************************************");   
      do {
         System.out.print("\n");
         System.out.println("1. Add");
         System.out.println("2. Delete");
         System.out.println("3. Search");
         System.out.println("4. Print");
         System.out.println("5. Exit this Program");
         System.out.print("\nPlease make a selection: ");
       
      //Inputs a scanner to accept infomation coming in from the keyboard
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
      System.out.print("\nPlease enter the First Name to add: ");
      String inp1 = scan.next();
      System.out.print("\nPlease enter the Last Name to add: ");
      String inp2 = scan.next();
      inp1 = fixr(inp1);
      inp2 = fixr(inp2);
      if(!data.contains(inp2 + " " + inp1)) {
         data.add(inp2 + " " + inp1);
         System.out.println("\n Entry " + inp2  + " " + inp1 + " has been successfully added at index " + data.lastIndexOf(inp2 + " " + inp1));
      } 
      else {
         System.out.println("\n Entry " + inp2  + " " + inp1 + " already exists in the list at index " + data.lastIndexOf(inp2 + " " + inp1));
      }
   }
   static void method2() {
      System.out.print("\nPlease enter the First Name to delete: ");
      String inp1 = scan.next();
      System.out.print("\nPlease enter the Last Name to delete: ");
      String inp2 = scan.next();
      inp1 = fixr(inp1);
      inp2 = fixr(inp2);
      if(data.contains(inp2 + " " + inp1)) {
         data.remove(inp2 + " " + inp1);
         System.out.println("\n Entry " + inp2  + " " + inp1 + " has been successfully deleted.");
      }
      else {
         System.out.println("\n Entry " + inp2  + " " + inp1 + " was not found in the list.");
      }
   }
   static void method3() {
      System.out.print("\nPlease enter the search string: ");
      String inp1 = scan.next();
      System.out.println("\nSearch returned the following results: " );
      boolean found = false;
      for(int i=0;i<data.size();i++) {
         if(data.get(i).contains(inp1) | data.get(i).contains(fixr(inp1))) {
            System.out.println(" " +  data.get(i) + " (at index: " + i + ")");
            found = true;
         }
      }
      if (!found) {
         System.out.println("\n No entry was found matching the search string " + inp1 + " .");
      }
   }
   static void method4() {
      for(String st : data) {
         System.out.println(st);
      }
   }
   static String fixr(String s) {
      String p1 = String.valueOf(s.charAt(0)).toUpperCase();
      String p2 = s.substring(1).toLowerCase();
      return p1+p2;
   }
}