//Edwin Cloud
//Program 4 class file

import java.lang.Math;
import java.text.DecimalFormat;

public class p4Class {

   public double x1,x2,h,r,P,i,n,q;
   private final double pi = 3.1416;
   private DecimalFormat twoDec = new DecimalFormat("0.00");  
   
   //Volume of a Sphere
   public p4Class(double a) {
      r = a;
   }
   
   //Surface Area of Cylinder
   public p4Class(double a, double b) {
      r = a;
      h = b;
   }
   
   //Area of Trapezoid
   public p4Class(double a, double b, double c) {
      x1 = a;
      x2 = b;
      h = c;
   }
   
   //Compound Interest
   public p4Class(double a, double b, double c, double d) {
      P = a;
      i = b;
      n = c;
      q = d;
   }
  
   public double areaT() {
      return Double.valueOf(twoDec.format(1/2.0*(x1+x2)*h));
   }
   
   public double areaC() {
      return Double.valueOf(twoDec.format((2.0*pi*Math.pow(r,2.0))+(2.0*pi*r*h)));
   }
   
   public double volume() {
      return Double.valueOf(twoDec.format((4/3.0)*pi*Math.pow(r,3.0)));
   }
   
   public double interest() {
      return Double.valueOf(twoDec.format(P*Math.pow(1.0+((i/100)/q),n*q)));
   }
}