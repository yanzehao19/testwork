package testwork;

import java.util.Random;

public class testArray {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    byte[][] a = new byte[10240][10240];
    int sum= 0;
    prln s =new prln();
    
    for(int i=0; i<10240;i++)
    {
      for(int j=0;j<10240;j++)
      {
        a[i][j]= (byte)(Math.random()*100);
        //sum+= a[j][i];
      }
    }
    
    for(int i=0; i<10240;i++)
    {
      for(int j=0;j<10240;j++)
      {
        //sum += a[i][j];
        sum+= a[j][i];
      }
    }
    s.prlns(sum);
  }

}
