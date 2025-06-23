import java.util.Scanner;
public class HollowEqualateraltrianlge{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
System.out.println("enter triangle hight");
int height = scan.nextInt();
for(int i = 0;i<height;i++){
    for(int y=0;y<height-i+1;y++){
System.out.print(" ");
    }
    for(int x =0; x<i+1;x++){
if(x==0||x==i||i==height-1){
System.out.print("x ");
}
else{
    System.out.print("  ");
}
    }
    System.out.println();
}
  }
}