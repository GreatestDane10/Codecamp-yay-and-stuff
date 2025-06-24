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
    public static char[][] SetShipsStats(char[][] ShipBoard){
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> ShipsLeft=new ArrayList<Integer>();
    ShipsLeft.add(2);
    ShipsLeft.add(3);
    ShipsLeft.add(3);
    ShipsLeft.add(4);
    ShipsLeft.add(5);
    While(ShipsLeft.size()>0){
        System.out.println("You are placing a ship with the lenght of" + ShipsLeft.get(0));
        System.out.println("which y coordinate would you like to start your ship of" + ShipsLeft.get(0) + "at");
        int YCoordinate = scan.nextInt();
        System.out.println("which x coordinate would you like to start your ship of " + ShipsLeft.get(0) + " at");
        int XCoordinate = scan.nextInt();
        System.out.println("Which derection would you like it going(Up, Down, Left, or Right)");
        String Direction = scan.nextLine().toLowerCase();
        if (InBounds(XCoordinate, YCoordinate, ShipSize, Direction) == false){//add to inbounds check is there is a ship already there
            continue;
        }
        PlaceShips(XCoordinate,YCoordinate,ShipsLeft.get(0),Direction,ShipBoard);
        ShipBoard=PlaceShips;
    }
    return ShipBoard;
    }
    public static char[][] PlaceShips(int x,int y,int lenght,string Direction, char[][] ShipBoard){
        if(Direction="up"){
            for(u=0;u<lenght;u++){
                ShipBoard[x][y-u]='■';
            }
        }
        if(Direction="down"){
            for(d=0;u<lenght;u++){
                ShipBoard[x][y+d]='■';
            }
        }
        if(Direction="left"){
            for(l=0;u<lenght;u++){
                ShipBoard[x-l][y]='■';
            }
        }
        if(Direction="right"){
            for(u=0;r<lenght;u++){
                ShipBoard[x+r][y]='■';
            }
        }
        return ShipBoard;
    }
    public static boolean InBounds (int x,int y,int ShipSize,String Direction){
        if(x>9||y>9||x<0||y<0){
            System.out.println("This is out of bounds, place again now");
            return false;
        }
        if(Direction==up && y-(ShipSize+1)<0){
                    System.out.println("That is out of bounds, please place again");
                    return false;
        }
        if(Direction=="down"&& y+(ShipSize-1)>9){
             System.out.println("That is out of bounds, please place again");
            return false;
        }
        if(Direction=="left"&&x-(ShipSize-1)>0){
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if(Direction=="right"&&x+(ShipSize-1)>9){
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