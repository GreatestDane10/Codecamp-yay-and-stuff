import java.util.Scanner;
import java.util.Set;
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
        P1ShipBoard = SetShipsStats(P1ShipBoard);
        P1BoardPrint(P1ViewBoard, P1ShipBoard);

    }

    public static char[][] SetShipsStats(char[][] ShipBoard) {
        Scanner scan = new Scanner(System.in);
        char[][] NewShipBoard = new char[10][10];
        ArrayList<Integer> ShipsLeft = new ArrayList<Integer>();
        ShipsLeft.add(2);
        ShipsLeft.add(3);
        ShipsLeft.add(3);
        ShipsLeft.add(4);
        ShipsLeft.add(5);
        while (ShipsLeft.size() > 0) {
            System.out.println("You are placing a ship with the lenght of " + ShipsLeft.get(0));
            System.out.println("which y coordinate would you like to start your ship of " + ShipsLeft.get(0) + " at");
            int YCoordinate = scan.nextInt();
            System.out.println("which x coordinate would you like to start your ship of " + ShipsLeft.get(0) + " at");
            int XCoordinate = scan.nextInt();
            System.out.println("Which derection would you like it going(Up, Down, Left, or Right)");
            String Direction = scan.nextLine().toLowerCase();
            Direction = scan.nextLine().toLowerCase();
            if (InBounds(XCoordinate, YCoordinate, ShipsLeft.get(0), Direction, NewShipBoard) == false) {// add to inbounds check is
                                                                                           // there is a ship already
                                                                                           // there
                continue;
            }
            NewShipBoard = PlaceShips(XCoordinate, YCoordinate, ShipsLeft.get(0), Direction, ShipBoard);
            ShipBoard = NewShipBoard;
            ShipsLeft.remove(0);
            for (int z = 0; z < 10; z++) {
                for (int x = 0; x < 10; x++) {
                    System.out.print(NewShipBoard[z][x] + " ");
                }
                System.out.println();
            }
        }
        return NewShipBoard;
    }

    public static char[][] PlaceShips(int x, int y, int lenght, String Direction, char[][] ShipBoard) {
        if (Direction.equals("up")) {
            for (int u = 0; u < lenght; u++) {
                ShipBoard[y - u][x] = '■';
            }
        } else if (Direction.equals("down")) {
            for (int d = 0; d < lenght; d++) {
                ShipBoard[y + d][x] = '■';
            }
        } else if (Direction.equals("left")) {
            for (int l = 0; l < lenght; l++) {
                ShipBoard[y][x - l] = '■';
            }
        } else if (Direction.equals("right")) {
            for (int r = 0; r < lenght; r++) {
                ShipBoard[y][x + r] = '■';
            }
        }
    return ShipBoard;

    }

    public static boolean InBounds(int x, int y, int ShipSize, String Direction, char[][] ShipBoard) {
        if (Direction.equals("up")) {
            for (int u = 0; u < ShipSize; u++) {
                if(ShipBoard[y - u][x] == '■'){
                    System.out.println("This overlaps with anouther ship please try again");
                    return false;
                }

            }
        }
        else if(Direction.equals("down")) {
            for (int d = 0; d < ShipSize; d++) {
                if(ShipBoard[y + d][x] == '■'){
                    System.out.println("This overlaps with anouther ship please try again");
                    return false;
                }
            }
        }
         else if (Direction.equals("left")) {
            for (int l = 0; l < ShipSize; l++) {
                if(ShipBoard[y][x - l] == '■'){
                    System.out.println("This overlaps with anouther ship please try again");
                    return false;
                }
            }
        } else if (Direction.equals("right")) {
            for (int r = 0; r < ShipSize; r++) {
                if(ShipBoard[y][x + r] == '■'){
                    System.out.println("This overlaps with anouther ship please try again");
                    return false;
                }
            }
        }
        if (x > 9 || y > 9 || x < 0 || y < 0) {
            System.out.println("This is out of bounds, place again now");
            return false;
        }
        if (Direction.equals("up") && y - (ShipSize + 1) < 0) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("down") && y + (ShipSize - 1) > 9) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("left") && x - (ShipSize - 1) > 0) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("right") && x + (ShipSize - 1) > 9) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        return true;
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