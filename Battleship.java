import java.util.Scanner;

public class Battleship {
    Scanner scan = new Scanner(System.in);

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
    public static char[][] SetShips(char[][] ShipBoard){
        System.out.println("which courdenent would you like to start your largest ship of 5 at")
        
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