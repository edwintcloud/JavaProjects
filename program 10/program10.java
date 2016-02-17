//Edwin Cloud
//Program 10

//imports
import java.util.Scanner;

class program10 {

   static int[] data = {34,56,2,89,33,65,22,43,19,88,66,90,11,56,71};
   static Scanner scan = new Scanner(System.in);
   
   public static void main(String[] args) {
   	      
      int numb = 0;
      
   //purpose and table
      System.out.println("************************************");
      System.out.println("***     This is a menu-driven    ***");
      System.out.println("***     program that performs    ***");
      System.out.println("***     3 sorting routines on    ***");
      System.out.println("***      a set of predefined     ***");
      System.out.println("***             numbers.         ***");
      System.out.println("************************************");   
      do {
         System.out.print("\n");
         System.out.println("The Numbers to be Sorted are:");
         System.out.print("[" + data[0]);
         for(int i=1;i<data.length;i++) 
            System.out.print("," + data[i]);
         System.out.print("]\n\n");
         System.out.println("1. Insertion Sort");
         System.out.println("2. Selection Sort");
         System.out.println("3. Bubble Sort");
         System.out.println("4. Exit this Program");
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
            case 1: insertion(data);
               break;
            case 2: selection(data); 
               break;
            case 3: bubble(data);
               break;
            case 4: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 4);
   }
   
   static void insertion(int[] a) {
      int[] b = new int[a.length];
      int temp;
      for(int i=0;i<b.length;i++)
         b[i] = a[i];
      for (int i = 1; i < b.length; i++) {
         for(int j = i ; j > 0 ; j--){
            if(b[j] < b[j-1]){
               temp = b[j];
               b[j] = b[j-1];
               b[j-1] = temp;
            }
         }
         System.out.println("\nResults of Pass " + (i) + " are:");
         System.out.print("[" + b[0]);
         for(int h=1;h<b.length;h++) 
            System.out.print("," + b[h]);
         System.out.print("]\n\n");
      }
      System.out.println("\nThe End Result:");
      System.out.print("[" + b[0]);
      for(int i=1;i<b.length;i++) 
         System.out.print("," + b[i]);
      System.out.print("]\n\n");
   }
   
   static void selection(int[] a) {
      int[] b = new int[a.length];
      for(int i=0;i<b.length;i++)
         b[i] = a[i];
      for (int i = 0; i < b.length - 1; i++)
      {
         int k = i;
         for (int j = i + 1; j < b.length; j++)
            if (b[j] < b[k])
               k = j;
         int smallerNumber = b[k]; 
         b[k] = b[i];
         b[i] = smallerNumber;
         System.out.println("\nResults of Pass " + (i+1) + " are:");
         System.out.print("[" + b[0]);
         for(int h=1;h<b.length;h++) 
            System.out.print("," + b[h]);
         System.out.print("]\n\n");
      }
      System.out.println("\nThe End Result:");
      System.out.print("[" + b[0]);
      for(int i=1;i<b.length;i++) 
         System.out.print("," + b[i]);
      System.out.print("]\n\n");  
   }
   
   static void bubble(int[] a) {
      int[] b = new int[a.length];
      for(int i=0;i<b.length;i++)
         b[i] = a[i];
      int k, temp;
      int count = 1;
      for (int m = b.length; m >= 0; m--) {
         for (int i = 0; i < b.length - 1; i++) {
            k = i + 1;
            if (b[i] > b[k]) {
               temp = b[i];
               b[i] = b[k];
               b[k] = temp;
            }
         }
         System.out.println("\nResults of Pass " + (count) + " are:");
         System.out.print("[" + b[0]);
         for(int h=1;h<b.length;h++) 
            System.out.print("," + b[h]);
         System.out.print("]\n\n");
         count++;
      }
      System.out.println("\nThe End Result:");
      System.out.print("[" + b[0]);
      for(int i=1;i<b.length;i++) 
         System.out.print("," + b[i]);
      System.out.print("]\n\n");
   }
   
}