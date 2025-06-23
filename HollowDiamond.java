import java.util.Scanner;
public class HollowDiamond{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
System.out.println("enter triangle hight");
int height = scan.nextInt();
for(int i = 0;i<height;i++){//runs for each row needed
    for(int y=0;y<height-(i+1);y++){//runs for each 
System.out.print(" ");
    }
    for(int x =0; x<i+1;x++){//runs nfor each charicter
if(x==0||x==i||i==height-1){
System.out.print("x ");
}
else{
    System.out.print("  ");
}
    }
    
    System.out.println();
}
for(int i = 0;i<height;i++){//runs for each row needed
    for(int y=0;y<i+1;y++){//runs for each space 
System.out.print(" ");
    }
    for(int x =0; x<height-x;x++){//runs nfor each charicter
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