import java.util.Scanner;
public class HollowDiamond{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
System.out.println("enter triangle hight");
int height = scan.nextInt();
for(int i = 0;i<height;i++){
    for(int y=0;y<height-i+1;y++){
System.out.print(" ");
    }
    for(int x =0; x<i+1;x++){

System.out.print("x ");
    }
    System.out.println();
}
  }
}