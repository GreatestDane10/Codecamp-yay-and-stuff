import java.util.Scanner;
public class Shapes{
  public static void main(String[] args){
Scanner scan = new Scanner(System.in);
System.out.println("enter right triangle hight");
int height = scan.nextInt();
for(int i = 0; i<height; i++){
  int lc = 0;
 while(lc <i+1){
  System.out.print("*");
  lc++;
 }
  System.out.println();
}
  }
}
