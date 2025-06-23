import java.util.Scanner;

public class HollowDiamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter diamond hight");
        int height = scan.nextInt();
        int NHT;
        int NHB;
        if (height % 2 == 0) {
            NHT = height / 2;
            NHB = height / 2;
        } else {
            NHT = height / 2 + 1;
            NHB = height / 2;
        }
        for (int i = 0; i < NHT; i++) {// runs for each row needed
            for (int y = 0; y < NHT - (i + 1); y++) {// runs for each
                System.out.print(" ");
            }
            for (int x = 0; x < i + 1; x++) {// runs nfor each charicter
                if (x == 0 || x == i) {
                    System.out.print("x ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
        // bottem triangle code begins
        for (int i = 0; i < NHB; i++) {// runs for each row needed
            for (int y = 0; y < i+(height%2); y++) {// runs for each space
                System.out.print(" ");
            }
            for (int x = 0; x < NHB - i; x++) {// runs nfor each charicter
                if (x == 0 || x == NHB - (i + 1)) {
                    System.out.print("x ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}
