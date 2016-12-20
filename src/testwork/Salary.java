package testwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Salary {

  String name;
  int baseSalary;
  int bonus;
  
  public Salary() {
    // TODO Auto-generated constructor stub
    baseSalary =(int)(Math.random()*95+5);
    bonus = (int)(Math.random()*10);
    name = getRnStr(5);
    
  }
  
  public static String getRnStr(int length){
    String base = "qwertyuiopasdfghjklzxcvbnm1234567890";
    Random random = new Random();
    StringBuffer sBuffer = new StringBuffer();
    for(int i=0;i<length;i++){
      int num =random.nextInt(base.length());
      sBuffer.append(base.charAt(num));
    }
    return sBuffer.toString();
      
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Salary> a= new ArrayList<Salary>();
    for(int i=0;i<10000;i++){
      Salary bSalary =new Salary();
      a.add(bSalary);
    }
    Collections.sort(a,new Comparator<Salary>() {
      public int compare(Salary o1,Salary o2) {
        if((o1.getBaseSalary()*13+o1.getBonus())>(o2.getBaseSalary()*13+o2.getBonus())){
          return 1;
        }
        if((o1.getBaseSalary()*13+o1.getBonus())==(o2.getBaseSalary()*13+o2.getBonus())){
          return 0;
        }
        return -1;
      }
    });
   for(int i=0;i<a.size();i++){
     System.out.println(a.get(i).baseSalary);
     System.out.println(a.get(i).bonus);
     System.out.println(a.get(i).name);
   }
   for(int i= a.size()-10;i<a.size();i++){
     System.out.println(a.get(i).name+"   "+(a.get(i).baseSalary*13+a.get(i).bonus));
   }
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(int baseSalary) {
    this.baseSalary = baseSalary;
  }

  public int getBonus() {
    return bonus;
  }

  public void setBonus(int bonus) {
    this.bonus = bonus;
  }

}
