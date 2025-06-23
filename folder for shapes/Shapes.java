import java.util.Scanner;
public class Shapes{
  public static void main(String[] args){
Scanner scan = new Scanner(System.in);
System.out.println("enter right triangle hight");
int height = scan.nextInt();
for(int i = 0; i<height; i++){
  int lc = 0;
for(int y = 0;y<i+1;y++){
  System.out.print("*");

 }
  System.out.println();
}
  }
}
