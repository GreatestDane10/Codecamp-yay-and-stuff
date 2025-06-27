import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        Hi hi = new Hi(12);
        System.out.println(hi.getpie());
        System.out.println(hi.getwaterbottle());
    }
}