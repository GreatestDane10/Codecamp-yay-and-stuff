import java.util.Scanner;
// import java.util.Set;
import java.util.ArrayList;

public class Battleship {
        static int P1PointsAwarded = 0;
        static int P2PointsAwarded = 0;
        static char[][] ShipNum1 = new char[10][10];
        static char[][] ShipNum2 = new char[10][10];
        static int[] hit1 = new int[5];
        static int[] hit2 = new int[5];

    public static void main(String[] args) {
        char[][] P1ShipBoard = new char[10][10];// make board
        char[][] P1ViewBoard = new char[10][10];// make board
        char[][] P2ShipBoard = new char[10][10];// make board
        char[][] P2ViewBoard = new char[10][10];// make board
        char[][][] ThreedArray = new char[2][10][10];
        ShipNum1 = CreateBoard();
        ShipNum2 = CreateBoard();
        P1ShipBoard = CreateBoard();
        P2ShipBoard = CreateBoard();
        P1ViewBoard = CreateBoard();
        P2ViewBoard = CreateBoard();
        P1BoardPrint(P1ViewBoard, P1ShipBoard);
        P1ShipBoard = SetShipsStats(P1ShipBoard,1);
       P1BoardPrint(P1ViewBoard,P1ShipBoard );
        Wait();
        ClearScreen();
        Wait();
        P2BoardPrint(P2ViewBoard, P2ShipBoard);
        P2ShipBoard = SetShipsStats(P2ShipBoard,2);
        P2BoardPrint(P2ViewBoard, P2ShipBoard);
        while(P1PointsAwarded<17&&P2PointsAwarded<17){
        Wait();
        ClearScreen();
            Wait();
            System.out.println("This is player 1s turn ");
            P1BoardPrint(P1ViewBoard,P1ShipBoard);
            ThreedArray=Guess(P1ViewBoard,P2ShipBoard,1);
            P1ViewBoard =SetViewEqual(ThreedArray,P1ViewBoard);
            P2ShipBoard = SetShipEqual(ThreedArray,P2ShipBoard);
            Wait();
            ClearScreen();;
            Wait();
            System.out.println("This is player 2s turn ");
            P2BoardPrint(P2ViewBoard,P2ShipBoard);
            ThreedArray = Guess(P2ViewBoard,P1ShipBoard,2);
            P2ViewBoard = SetViewEqual(ThreedArray,P2ViewBoard);
            P1ShipBoard = SetShipEqual(ThreedArray,P1ShipBoard);
        }
        if(P1PointsAwarded>=17){
        System.out.println("Congrats player one you win");
        }
        else if(P2PointsAwarded>=17){
            System.out.println("COngrats player two you win");
        }

    }
    
        public static char[][] SetViewEqual(char[][][] ThreedBoard,char[][] BoardNeedingSeting){
            for(int a=0;a<10;a++){
                for(int b =0; b<10;b++ ){
                    BoardNeedingSeting[a][b]=ThreedBoard[1][a][b];
                }
            }
            return BoardNeedingSeting;
        }
        public static char[][] SetShipEqual(char[][][] ThreedBoard,char[][] BoardNeedingSeting){
            for(int a=0;a<10;a++){
                for(int b =0; b<10;b++ ){
                    BoardNeedingSeting[a][b]=ThreedBoard[0][a][b];
                }
            }
            return BoardNeedingSeting;
        }
    public static char[][][] Guess(char[][] ViewBoard,char[][] ShipBoard,int player){
        Scanner scan = new Scanner(System.in);
        char[][][] ThreedStorage = new char[2][10][10];
        System.out.println("Which x coord would you like your guess at");
        int x = scan.nextInt();
        System.out.println("Which y coord would you like your guess at");
        int y = scan.nextInt();
        if(y>9||y<0||x>9||x<0){
            System.out.println("that is out of bounds please guess again");
            Guess(ViewBoard,ShipBoard,player);
        }
        if(ViewBoard[y][x]=='o'||ViewBoard[y][x]=='¤'){
            System.out.println("you have already guessed there please guess again");
            Guess(ViewBoard,ShipBoard,player);
        }
        if(ShipBoard[y][x]=='■'){
            int i;
            int num;
            char notnum;
            System.out.println("congradulations you hit");
                if(player==1){
                    if(hit1[4]==2&&ShipNum2[y][x]=='6'){
                        System.out.println("congradulation sunk");
                    }
                    for(i = 0;i<4;i++){
                num = i+2;
                notnum = (char) num;
                    if (hit1[i]==i+1&&ShipNum2[y][x]==notnum){
                        System.out.println("congradulations Sunk");
                    }
                }
            }
                else if(player==2){
                    if(hit1[4]==2&&ShipNum1[y][x]=='6'){
                        System.out.println("congradulation sunk");
                    }
                    for(i=0;i<4;i++){
                num = i+2;
                notnum = (char) num;
                    if (hit1[i]==i+1&&ShipNum1[y][x]==notnum){
                        System.out.println("congradulations Sunk");
                    }
                }
            }


            ShipBoard[y][x]='¤';
            ViewBoard[y][x]='¤';
            if(player==1){
            P1PointsAwarded = P1PointsAwarded + 1;
            hit1[Character.getNumericValue(ShipNum1[y][x])-2]++;
            ShipNum1[y][x]='¤';
            }
            else{
                P2PointsAwarded=P2PointsAwarded+1;
            hit2[Character.getNumericValue(ShipNum1[y][x])-2]++;
                ShipNum2[y][x]='¤';
            }
        }
        else if(ShipBoard[y][x]=='□'){
            System.out.println("sorry you missed");
            ViewBoard[y][x]='o';
            ShipBoard[y][x]='o';
        }
            for(int two =0;two<10;two++){
                for(int three=0; three<10;three++){
                    ThreedStorage[0][two][three]=ShipBoard[two][three];
                }
            }
            for(int two =0;two<10;two++){
                for(int three=0; three<10;three++){
                    ThreedStorage[1][two][three]=ViewBoard[two][three];
                }
            }
            return ThreedStorage;
    }
    public static void Wait(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please press enter when you are ready to continue to the next players turn");
        scan.nextLine();
    }
    public static char[][] SetShipsStats(char[][] ShipBoard,int player) {
        int ShipThreeNum=1;
        Scanner scan = new Scanner(System.in);
        char[][] NewShipBoard = new char[10][10];
        ArrayList<Integer> ShipsLeft = new ArrayList<Integer>();
        ShipsLeft.add(2);
        ShipsLeft.add(3);
        ShipsLeft.add(3);
        ShipsLeft.add(4);
        ShipsLeft.add(5);
        while (ShipsLeft.size() > 0) {
                if(ShipThreeNum!=2){
                ShipThreeNum = 1;
                }
            System.out.println("You are placing a ship with the lenght of " + ShipsLeft.get(0));
            System.out.println("which x coordinate would you like to start your ship of " + ShipsLeft.get(0) + " at");
            int XCoordinate = scan.nextInt();
            System.out.println("which y coordinate would you like to start your ship of " + ShipsLeft.get(0) + " at");
            int YCoordinate = scan.nextInt();
            System.out.println("Which derection would you like it going(Up, Down, Left, or Right)");
            String Direction = scan.nextLine().toLowerCase();
            Direction = scan.nextLine().toLowerCase();
            if (InBounds(XCoordinate, YCoordinate, ShipsLeft.get(0), Direction, NewShipBoard) == false) {// add to inbounds check is
                                                                                           // there is a ship already
                                                                                           // there
                continue;
            }
            NewShipBoard = PlaceShips(XCoordinate, YCoordinate, ShipsLeft.get(0), Direction, ShipBoard,ShipThreeNum,player);
                if(ShipsLeft.get(0)==3){
                        ShipThreeNum++;
                }
            ShipBoard = NewShipBoard;
            ShipsLeft.remove(0);
            System.out.print("  ");
        for (int c = 0; c < 10; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int a = 0; a < 10; a++) {
            System.out.print(a + " ");
            for (int b = 0; b < 10; b++) {
                System.out.print(NewShipBoard[a][b] + " ");
            }
                System.out.println();
            }
        }
        return NewShipBoard;
    }

    public static char[][] PlaceShips(int x, int y, int lenght, String Direction, char[][] ShipBoard,int ShipThreeNum,int player) {
        if (Direction.equals("up")) {
            for (int u = 0; u < lenght; u++) {
                ShipBoard[y - u][x] = '■';
                    if(player==1){
                ShipNum1[y - u][x] = (""+lenght*ShipThreeNum).charAt(0);
                        }
                    else if(player==2){
                ShipNum2[y - u][x] = (""+lenght*ShipThreeNum).charAt(0);
                        }
            }
        } else if (Direction.equals("down")) {
            for (int d = 0; d < lenght; d++) {
                ShipBoard[y + d][x] = '■';
                    if(player==1){
                ShipNum1[y + d][x]=(""+lenght*ShipThreeNum).charAt(0);
                    }
                    else if(player==2){
                ShipNum2[y +d][x]=(""+lenght*ShipThreeNum).charAt(0);
                    }
            }
        } else if (Direction.equals("left")) {
            for (int l = 0; l < lenght; l++) {
                ShipBoard[y][x - l] = '■';
                    if(player==1){
                ShipNum1[y][x - 1] =(""+lenght*ShipThreeNum).charAt(0);
                    }
                    else if(player==2){
                ShipNum2[y][x - 1] =(""+lenght*ShipThreeNum).charAt(0);
                    }
            }
        } else if (Direction.equals("right")) {
            for (int r = 0; r < lenght; r++) {
                ShipBoard[y][x + r] = '■';
                    if(player==1){
                ShipNum1[y][x + r] = (""+lenght*ShipThreeNum).charAt(0);
                    }
                    else if(player ==2){     
                ShipNum2[y][x + r] = (""+lenght*ShipThreeNum).charAt(0);
                    }
            }
        }
    return ShipBoard;

    }

    public static boolean InBounds(int x, int y, int ShipSize, String Direction, char[][] ShipBoard) {
        if (x > 9 || y > 9 || x < 0 || y < 0) {
            System.out.println("This is out of bounds, place again now");
            return false;
        }
        if (Direction.equals("up") && (y - ShipSize) + 1 < 0) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("down") && y + (ShipSize - 1) > 9) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("left") && x - (ShipSize - 1) < 0) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
        if (Direction.equals("right") && x + (ShipSize - 1) > 9) {
            System.out.println("That is out of bounds, please place again");
            return false;
        }
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
        if(Direction.equals("left")==false && Direction.equals("right")==false && Direction.equals("up")==false && Direction.equals("down")==false){
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
            System.out.print(a + " ");
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
    public static void ClearScreen() {  
    for(int stuffandstuff=0;stuffandstuff<100;stuffandstuff++){
        System.out.println("\n");
    }
}  
}
// ■
// □
// ¤


