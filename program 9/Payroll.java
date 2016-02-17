//Edwin Cloud
//Payroll class

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Payroll {

//Initialize our variables
   private int size;
   private  ArrayList<String> master = new ArrayList<String> ();
   private  ArrayList<String> transaction = new ArrayList<String> ();
   private String[][] data;

   public Payroll () {
      try {
         Scanner fr = new Scanner(new FileReader("masterfile.txt"));
         while(fr.hasNext())
            master.add(fr.nextLine());
         fr.close();              
      } 
      catch(FileNotFoundException e) {
         System.out.println("***File Not Found!***");
      }
      try {
         Scanner fr = new Scanner(new FileReader("transactionfile.txt"));
         while(fr.hasNext())
            transaction.add(fr.nextLine());
         fr.close();              
      } 
      catch(FileNotFoundException e) {
         System.out.println("***File Not Found!***");
      }
      this.size = master.size();
      data = new String[size][11];
      for(int i=0;i<this.size;i++){
         String[] temp1 = master.get(i).split(" ");
         String[] temp2 = transaction.get(i).split(" ");
         for(int p=0;p<8;p++)
            data[i][p] = temp1[p];
         data[i][8] = temp2[2];
         data[i][9] = getGross(i);
         data[i][10] = getNet(i);
      }     
   }    
   private String getGross(int index) {
      double rate = Double.valueOf(data[index][3]);
      double hours = Double.valueOf(data[index][8]);
      int type = Integer.valueOf(data[index][5]);
      double pay = 0;
      if (type == 0 && hours > 40)
         pay += doOvertime((hours-40), rate);
      pay += (rate * hours);
      return Double.toString(pay);
   }
   private String getNet(int index) {
      double gross = Double.valueOf(getGross(index));
      int dep = Integer.valueOf(data[index][4]);
      double tax = doTax(gross, dep);
      return Double.toString(gross-tax);
   }
   private double doTax(double gross, double dep) {
      if (dep == 1) {
         return (gross*0.15);
      } 
      else {
         double cal = (1-(dep/(dep+6)))*0.15;
         if(cal > 0.025) {
            return (gross*cal);
         } 
         else {
            return (gross*0.025);
         }
      }
   }
   private double doOvertime(double hours, double rate) {
      double newR = rate * 1.5;
      return (hours * newR);
   }
   private double totalNet() {
      double sum = 0;
      for(int i=0;i<this.size;i++) 
         sum += Double.valueOf(data[i][10]);
      return sum;
   }
   private double totalGross() {
      double sum = 0;
      for(int i=0;i<this.size;i++) 
         sum += Double.valueOf(data[i][9]);
      return sum;
   }
   public void printPayroll() {
   System.out.printf("%10s%10s%8s%14s%15s%22s%n","LName","FName","ID","Location","Gross Pay","Net Pay");
   for(int i=0;i<this.size-1;i++) System.out.print("________");
      System.out.println("\n");
      for(int i=0;i<this.size;i++)
         System.out.printf("%10s%10s%8d%14s%15.2f%22.2f%n",data[i][1],data[i][2],Integer.valueOf(data[i][0]),data[i][6],Double.valueOf(data[i][9]),Double.valueOf(data[i][10]));
      for(int i=0;i<this.size-1;i++) System.out.print("________");
      System.out.printf("%n%n%49s%8.2f%14s%8.2f","Total Gross: ",totalGross(),"Total Net: ",totalNet());
   }
}