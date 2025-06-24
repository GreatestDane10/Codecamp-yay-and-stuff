import java.util.Scanner;
import java.util.ArrayList;

public class Battleship {

    public static void main(String[] args) {
        char[][] P1ShipBoard = new char[10][10];// make board
        char[][] P1ViewBoard = new char[10][10];// make board
        char[][] P2ShipBoard = new char[10][10];// make board
        char[][] P2ViewBoard = new char[10][10];// make board
        P1ShipBoard = CreateBoard();
        P2ShipBoard = CreateBoard();
        P1ViewBoard = CreateBoard();
        P2ViewBoard = CreateBoard();
        P1BoardPrint(P1ViewBoard, P1ShipBoard);

    }
    public static void SetShipsStats(char[][] ShipBoard){
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> ShipsLeft=new ArrayList<Integer>();
    ShipsLeft.add(2);
    ShipsLeft.add(3);
    ShipsLeft.add(3);
    ShipsLeft.add(4);
    ShipsLeft.add(5);
    While(ShipsLeft.size()>0)
        System.out.println("You are placing ship")
        System.out.println("which y coordinate would you like to start your ship of" + ShipSize + "at")
        int YCoordinate = scan.nextInt();
        System.out.println("which x coordinate would you like to start your ship of" + ShipSize + "at")
        int XCoordinate = scan.nextInt();
        System.out.println("Which derection would you like it going(Up, Down, Left, or Right)");
        String Direction = scan.nextLine().toLowerCase();
        InBounds(XCoordinate, YCoordinate, ShipSize, Direction);
        
    }
    public static boolean InBounds (int x,int y,int ShipSize,String Direction){
       for(int d = 0;d<ShipSize;d++){
            if(Direction==up){
                if(XCoordinate+(ShipSize-1)<=10){
                    System.out.println("That is out of bounds, please place again");
                    
                }
            }
        }
    }

    public static void P1BoardPrint(char[][] ViewBoard, char[][] ShipBoard) {
        System.out.println("this is player 1s view board");
        System.out.print("  ");
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int a = 0; a < 10; a++) {
            System.out.print(a + " ");
            for (int b = 0; b < 10; b++) {
                System.out.print(ViewBoard[a][b] + " ");
            }
            System.out.println();
        }
        // end of viewprint
        System.out.println("this is player 1s ship board");
           System.out.print("  ");
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int a = 0; a < 10; a++) {
            System.out.print(a + " ");
            for (int b = 0; b < 10; b++) {
                System.out.print(ShipBoard[a][b] + " ");
            }
            System.out.println();
        }
    }

    public static void P2BoardPrint(char[][] ViewBoard, char[][] ShipBoard) {
        System.out.println("this is player 2s view board");
            System.out.print("  ");
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int a = 0; a < 10; a++) {
            System.out.print(a + 1 + " ");
            for (int b = 0; b < 10; b++) {
                System.out.print(ViewBoard[a][b] + " ");
            }
            System.out.println();
        }
        // end of viewprint
        System.out.println("this is player 2s ship board");
            System.out.print("  ");
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int a = 0; a < 10; a++) {
            System.out.print(a + " ");
            for (int b = 0; b < 10; b++) {
                System.out.print(ShipBoard[a][b] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] CreateBoard() {
        char[][] board = new char[10][10];
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                board[a][b] = '□';
            }
        }
        return board;
    }
}
// ■
// □