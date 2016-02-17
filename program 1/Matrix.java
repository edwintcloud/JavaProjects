//Edwin Cloud
//Matrix class

public class Matrix {

//Initialize our variables
   private int size;
   private double[][] data;

//default matrix constructor
   public Matrix(int size) {
      this.size = size;
      data = new double[size][size];
   }
   
//our Matrix constructor
   public Matrix(double[][] data) {
      size = data.length;
      if(data.length != data[0].length || data.length != 3 || data.length != 4) throw new RuntimeException("Illegal matrix dimensions.");
      this.data = new double[size][size];
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++) {
            this.data[i][j] = data[i][j];
         }
      }
   }
   
// copy constructor
   public Matrix(Matrix m1) { this(m1.data); }
    
//getSize() method
   public int getSize() {
      return this.size;
   }
   
//set() method
   public void set(int x, int y, double v) {
      this.data[x][y] = v;
   }
   
//setAll() method
   public void setAll(double v) {
      for(int i=0;i<this.size;i++) {
         for(int j=0;j<this.size;j++)
            this.data[i][j] = v;
      }
   }
     
 //Addition Method
   public Matrix plus(Matrix m2) {
      Matrix m3 = new Matrix(size);
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++)
            m3.data[i][j] = this.data[i][j]+m2.data[i][j];
      }
      return m3;
   } 
   
 //Subtraction Method
   public Matrix minus(Matrix m2) {
      Matrix m3 = new Matrix(size);
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++)
            m3.data[i][j] = this.data[i][j]-m2.data[i][j];
      }
      return m3;
   } 
   
 //Multiplication Method
   public Matrix times(Matrix m2) {
      Matrix m3 = new Matrix(size);
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++){
            for(int k=0;k<size;k++)
               m3.data[i][j] += (this.data[i][k] * m2.data[k][j]);  
         }
      }
      return m3;
   } 
   
 //Scalar Multiplication Method
   public Matrix times(double num) {
      Matrix m3 = new Matrix(size);
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++)
            m3.data[i][j] = num * this.data[i][j];
      }
      return m3;
   } 
   
 //Transpose Method
   public Matrix transpose() {
      Matrix m3 = new Matrix(size);
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++)
            m3.data[j][i] = this.data[i][j];
      }
      return m3;
   }
   
 //Identity Method
   public Matrix identity() {
      Matrix m3 = new Matrix(size);
      switch(size) {
         case 3:
            m3.data = new double[][] {{1,0,0},{0,1,0},{0,0,1}};
            return m3;
         case 4:
            m3.data = new double[][] {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
            return m3;
         default:
            return m3;
      }
   }
 //Determinant method (privately used by inverse method)
   private double determinant() {
      double det = 0.0;
      switch(size) {
         case 3:
            det = data[0][0]*data[1][1]*data[2][2] + data[0][1]*data[1][2]*data[2][0] + 
               data[0][2]*data[1][0]*data[2][1] - data[0][0]*data[1][2]*data[2][1] - 
               data[0][1]*data[1][0]*data[2][2] - data[0][2]*data[1][1]*data[2][0];
            return det;
         case 4:
            det =
               data[0][3]*data[1][2]*data[2][1]*data[3][0] - data[0][2]*data[1][3]*data[2][1]*data[3][0] - data[0][3]*data[1][1]*data[2][2]*data[3][0] + data[0][1]*data[1][3]*data[2][2]*data[3][0]+
               data[0][2]*data[1][1]*data[2][3]*data[3][0] - data[0][1]*data[1][2]*data[2][3]*data[3][0] - data[0][3]*data[1][2]*data[2][0]*data[3][1] + data[0][2]*data[1][3]*data[2][0]*data[3][1]+
               data[0][3]*data[1][0]*data[2][2]*data[3][1] - data[0][0]*data[1][3]*data[2][2]*data[3][1] - data[0][2]*data[1][0]*data[2][3]*data[3][1] + data[0][0]*data[1][2]*data[2][3]*data[3][1]+
               data[0][3]*data[1][1]*data[2][0]*data[3][2] - data[0][1]*data[1][3]*data[2][0]*data[3][2] - data[0][3]*data[1][0]*data[2][1]*data[3][2] + data[0][0]*data[1][3]*data[2][1]*data[3][2]+
               data[0][1]*data[1][0]*data[2][3]*data[3][2] - data[0][0]*data[1][1]*data[2][3]*data[3][2] - data[0][2]*data[1][1]*data[2][0]*data[3][3] + data[0][1]*data[1][2]*data[2][0]*data[3][3]+
               data[0][2]*data[1][0]*data[2][1]*data[3][3] - data[0][0]*data[1][2]*data[2][1]*data[3][3] - data[0][1]*data[1][0]*data[2][2]*data[3][3] + data[0][0]*data[1][1]*data[2][2]*data[3][3];
            return det;
         default:
            return det;
      }
   }

 //Inverse method
   public Matrix inverse() {
      Matrix m3 = new Matrix(size);
      switch(size) {
         case 3:
            m3.data[0][0] = (data[1][1]*data[2][2] - data[1][2]*data[2][1])/determinant();
            m3.data[0][1] = (data[0][2]*data[2][1] - data[0][1]*data[2][2])/determinant();
            m3.data[0][2] = (data[0][1]*data[1][2] - data[0][2]*data[1][1])/determinant();
            m3.data[1][0] = (data[1][2]*data[2][0] - data[1][0]*data[2][2])/determinant();
            m3.data[1][1] = (data[0][0]*data[2][2] - data[0][2]*data[2][0])/determinant();
            m3.data[1][2] = (data[0][2]*data[1][0] - data[0][0]*data[1][2])/determinant();
            m3.data[2][0] = (data[1][0]*data[2][1] - data[1][1]*data[2][0])/determinant();
            m3.data[2][1] = (data[0][1]*data[2][0] - data[0][0]*data[2][1])/determinant();
            m3.data[2][2] = (data[0][0]*data[1][1] - data[0][1]*data[1][0])/determinant();
            return m3;
         case 4:
            m3.data[0][0] = (data[1][2]*data[2][3]*data[3][1] - data[1][3]*data[2][2]*data[3][1] + data[1][3]*data[2][1]*data[3][2] - data[1][1]*data[2][3]*data[3][2] - data[1][2]*data[2][1]*data[3][3] + data[1][1]*data[2][2]*data[3][3])/determinant();
            m3.data[0][1] = (data[0][3]*data[2][2]*data[3][1] - data[0][2]*data[2][3]*data[3][1] - data[0][3]*data[2][1]*data[3][2] + data[0][1]*data[2][3]*data[3][2] + data[0][2]*data[2][1]*data[3][3] - data[0][1]*data[2][2]*data[3][3])/determinant();
            m3.data[0][2] = (data[0][2]*data[1][3]*data[3][1] - data[0][3]*data[1][2]*data[3][1] + data[0][3]*data[1][1]*data[3][2] - data[0][1]*data[1][3]*data[3][2] - data[0][2]*data[1][1]*data[3][3] + data[0][1]*data[1][2]*data[3][3])/determinant();
            m3.data[0][3] = (data[0][3]*data[1][2]*data[2][1] - data[0][2]*data[1][3]*data[2][1] - data[0][3]*data[1][1]*data[2][2] + data[0][1]*data[1][3]*data[2][2] + data[0][2]*data[1][1]*data[2][3] - data[0][1]*data[1][2]*data[2][3])/determinant();
            m3.data[1][0] = (data[1][3]*data[2][2]*data[3][0] - data[1][2]*data[2][3]*data[3][0] - data[1][3]*data[2][0]*data[3][2] + data[1][0]*data[2][3]*data[3][2] + data[1][2]*data[2][0]*data[3][3] - data[1][0]*data[2][2]*data[3][3])/determinant();
            m3.data[1][1] = (data[0][2]*data[2][3]*data[3][0] - data[0][3]*data[2][2]*data[3][0] + data[0][3]*data[2][0]*data[3][2] - data[0][0]*data[2][3]*data[3][2] - data[0][2]*data[2][0]*data[3][3] + data[0][0]*data[2][2]*data[3][3])/determinant();
            m3.data[1][2] = (data[0][3]*data[1][2]*data[3][0] - data[0][2]*data[1][3]*data[3][0] - data[0][3]*data[1][0]*data[3][2] + data[0][0]*data[1][3]*data[3][2] + data[0][2]*data[1][0]*data[3][3] - data[0][0]*data[1][2]*data[3][3])/determinant();
            m3.data[1][3] = (data[0][2]*data[1][3]*data[2][0] - data[0][3]*data[1][2]*data[2][0] + data[0][3]*data[1][0]*data[2][2] - data[0][0]*data[1][3]*data[2][2] - data[0][2]*data[1][0]*data[2][3] + data[0][0]*data[1][2]*data[2][3])/determinant();
            m3.data[2][0] = (data[1][1]*data[2][3]*data[3][0] - data[1][3]*data[2][1]*data[3][0] + data[1][3]*data[2][0]*data[3][1] - data[1][0]*data[2][3]*data[3][1] - data[1][1]*data[2][0]*data[3][3] + data[1][0]*data[2][1]*data[3][3])/determinant();
            m3.data[2][1] = (data[0][3]*data[2][1]*data[3][0] - data[0][1]*data[2][3]*data[3][0] - data[0][3]*data[2][0]*data[3][1] + data[0][0]*data[2][3]*data[3][1] + data[0][1]*data[2][0]*data[3][3] - data[0][0]*data[2][1]*data[3][3])/determinant();
            m3.data[2][2] = (data[0][1]*data[1][3]*data[3][0] - data[0][3]*data[1][1]*data[3][0] + data[0][3]*data[1][0]*data[3][1] - data[0][0]*data[1][3]*data[3][1] - data[0][1]*data[1][0]*data[3][3] + data[0][0]*data[1][1]*data[3][3])/determinant();
            m3.data[2][3] = (data[0][3]*data[1][1]*data[2][0] - data[0][1]*data[1][3]*data[2][0] - data[0][3]*data[1][0]*data[2][1] + data[0][0]*data[1][3]*data[2][1] + data[0][1]*data[1][0]*data[2][3] - data[0][0]*data[1][1]*data[2][3])/determinant();
            m3.data[3][0] = (data[1][2]*data[2][1]*data[3][0] - data[1][1]*data[2][2]*data[3][0] - data[1][2]*data[2][0]*data[3][1] + data[1][0]*data[2][2]*data[3][1] + data[1][1]*data[2][0]*data[3][2] - data[1][0]*data[2][1]*data[3][2])/determinant();
            m3.data[3][1] = (data[0][1]*data[2][2]*data[3][0] - data[0][2]*data[2][1]*data[3][0] + data[0][2]*data[2][0]*data[3][1] - data[0][0]*data[2][2]*data[3][1] - data[0][1]*data[2][0]*data[3][2] + data[0][0]*data[2][1]*data[3][2])/determinant();
            m3.data[3][2] = (data[0][2]*data[1][1]*data[3][0] - data[0][1]*data[1][2]*data[3][0] - data[0][2]*data[1][0]*data[3][1] + data[0][0]*data[1][2]*data[3][1] + data[0][1]*data[1][0]*data[3][2] - data[0][0]*data[1][1]*data[3][2])/determinant();
            m3.data[3][3] = (data[0][1]*data[1][2]*data[2][0] - data[0][2]*data[1][1]*data[2][0] + data[0][2]*data[1][0]*data[2][1] - data[0][0]*data[1][2]*data[2][1] - data[0][1]*data[1][0]*data[2][2] + data[0][0]*data[1][1]*data[2][2])/determinant();
            return m3;
         default: 
            return m3;
      }
   }
   
 // print matrix to standard output
   public void print() {
      int l = 0;
      int z = 0;
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++){
            String text = String.valueOf(Math.abs(data[i][j]));
            int length1 = text.indexOf('.') + (text.length() - text.indexOf('.') - 1);
            int length2 = text.length() - text.indexOf('.') - 1;
            if(length1 >= l) l = length1;
            if(length2 >= z) z = length2;
         }
      }
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++)
            System.out.printf("%" + (l+1) + "." + (z-1) + "f ",data[i][j]);
         System.out.println();
      }
   }
    // print row for formatting
   public void printRow(int r) {
      int l = 0;
      int z = 0;
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++){
            String text = String.valueOf(Math.abs(data[i][j]));
            int length1 = text.indexOf('.') + (text.length() - text.indexOf('.') - 1);
            int length2 = text.length() - text.indexOf('.') - 1;
            if(length1 >= l) l = length1;
            if(length2 >= z) z = length2;
         }
      }
      for(int j=0;j<size;j++) {
         System.out.printf("%" + (l+1) + "." + (z-1) + "f ",data[r][j]);
      }
   }
}