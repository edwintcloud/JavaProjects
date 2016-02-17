//Edwin Cloud
//Program 6

//imports
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class program6 {
   
   //initialize an UnorderedLinkedList to hold data from file
   static LinkedList<String> data = new LinkedList();
   
   public static void main(String[] args) {
   
    //purpose and table
      System.out.println("************************************");
      System.out.println("***     This is a menu-driven    ***");
      System.out.println("***     program that utilizes    ***");
      System.out.println("***  a LinkedList to dynamically ***");
      System.out.println("***    manage an input file and  ***");
      System.out.println("***      its contained data.     ***");
      System.out.println("************************************");   
      
      //Read from text file into LinkedList
      try {
         Scanner fs = new Scanner(new FileReader("program6data.txt"));
         while(fs.hasNext())
            add(fs.nextLine());
         fs.close();
      }
      catch(FileNotFoundException e) {
         System.out.println("***File not found!!***");
      }
   
      int numb = 0;
      String inp1, inp2, res;
		int pos,pos2;
   
      do {
         System.out.print("\n");
         System.out.println("1. Add a name to the list");
         System.out.println("2. Delete a name from the list");
         System.out.println("3. Search for a name in the list");
         System.out.println("4. Swap the place of two names in the list (update)");
         System.out.println("5. Print the list");
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
            case 1: 
               System.out.print("\nPlease enter the First Name to add: ");
               inp1 = scan.next();
               System.out.print("\nPlease enter the Last Name to add: ");
               inp2 = scan.next();
               inp1 = fixr(inp1);
               inp2 = fixr(inp2);
               if(search(inp2 + " " + inp1) != -1) {
                  System.out.println("\nEntry " + inp2  + " " + inp1 + " is already in the list.");
                  delete(inp2 + " " + inp1);
               } else {
                  System.out.println("\nEntry " + inp2  + " " + inp1 + " has been added to the list.");
                  add(inp2 + " " + inp1);
               }
               break;
            case 2: 
               System.out.print("\nPlease enter the name to remove: ");
					inp1 = scan.next();
					res = delete(inp1);
               if(res != "")
                  System.out.println("\nEntry " + res + " has been deleted from the list.");
               else
                  System.out.println("\nName " + inp1 + " was not in the list.");
               break;
            case 3:
               System.out.print("\nPlease enter the name to search: ");
					inp1 = scan.next();
					pos = search(inp1);
               if(pos != -1)
                  System.out.println("\nEntry " + get(pos) + " has been found at position " + (pos+1) + " in the list.");
               else
                  System.out.println("\nEntry " + inp1 + " is not in the list.");
               break;
            case 4:
               System.out.print("\nPlease enter the name of canidate a: ");
					inp1 = scan.next();
               pos = search(inp1);
               System.out.print("\nPlease enter the name of canidate b: ");
					inp2 = scan.next();
					pos2 = search(inp2);
               if(pos != -1 && pos2 != -1) {
                  System.out.println("\nCanidate a and b have swapped places! Print to verify.");
                  update(pos,pos2);
               } else {
                  System.out.println("\nOne of the names entered was not found in the list.");
               } 
               break;
            case 5: 
               print();
               break;
            case 6: System.out.println("Thank you for using this menu-driven program, have a great day!");
               break;
            default: System.out.println("\nPlease follow the directions...");
               break;
         }
      }while(numb != 6);
   }
   static void add(String n) {
      data.add(n);
   }
	static String get(int n) {
      return data.get(n);
   }
   static String delete(String n) {
		for(int i=0;i<data.size();i++) {
			if(data.get(i).toLowerCase().contains(n.toLowerCase())) {
				String rem = data.get(i);
				data.remove(i);
				return rem;
			}
		}
		return "";
   }
	static int search(String n) {
		for(int i=0;i<data.size();i++) {
			if(data.get(i).toLowerCase().contains(n.toLowerCase()))
				return i;
		}
		return -1;
   }
   //replacement method (change the position in the list of an entry)
   static void update(int a, int b) {
      data.set(a,data.get(b));
      data.set(b,data.get(a));
   }
   static void print() {
      for(int i=0;i<data.size();i++)
         System.out.println(data.get(i));
   }
   static String fixr(String s) {
      String p1 = String.valueOf(s.charAt(0)).toUpperCase();
      String p2 = s.substring(1).toLowerCase();
      return p1+p2;
   }

}