import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTakToe {

    private static char [][] map;
    private static final int SIZE = 3;
    private static final char EMPTY_DOT = '•';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static Scanner sc;


    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            System.out.println();
            if (checkWin(X_DOT)) {
                System.out.println("You win");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }
            computerTurn();
            printMap();
            System.out.println();
            if (checkWin(O_DOT)) {
                System.out.println("You lose");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static boolean checkDraw() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        if(map[0][0] == c && map[0][1] == c && map[0][2] == c) {
            return true;
        }
        if(map[1][0] == c && map[1][1] == c && map[1][2] == c) {
            return true;
        }
        if(map[2][0] == c && map[2][1] == c && map[2][2] == c) {
            return true;
        }
        if(map[0][0] == c && map[1][0] == c && map[2][0] == c) {
            return true;
        }
        if(map[0][1] == c && map[1][1] == c && map[2][1] == c) {
            return true;
        }
        if(map[0][2] == c && map[1][2] == c && map[2][2] == c) {
            return true;
        }
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        if(map[2][0] == c && map[1][1] == c && map[0][2] == c) {
            return true;
        }
        return false;
    }

    private static void computerTurn() {
        int xCoordinate;
        int yCoordinate;
        do {
            Random random = new Random();
            xCoordinate = random.nextInt(SIZE);
            yCoordinate = random.nextInt(SIZE);
        } while (!isValidCell(xCoordinate, yCoordinate));
        map[yCoordinate][xCoordinate] = O_DOT;
    }

    private static void humanTurn() {
        int xCoordinate = -1;
        int yCoordinate = -1;
        do {
            System.out.println("Введите координаты в формате x y");
            if (sc.hasNextInt()) {
                xCoordinate = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                yCoordinate = sc.nextInt() - 1;
            }
            sc.nextLine();
        } while (!isValidCell(xCoordinate, yCoordinate));
        map[yCoordinate][xCoordinate] = X_DOT;
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > map.length - 1 || y > map.length - 1) {
            return false;
        }
        return map[y][x] == EMPTY_DOT;
    }

    private static void printMap() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        sc = new Scanner(System.in);
        map = new char[SIZE][SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, EMPTY_DOT);
        }
    }
}


////good Horizontal move
//                if (map[i][j] == player) countH++;
//                        else if (map[i][j] == cNull) countHNull++;
//                        if ((countH == size - 1) && (countHNull == 1)) {
//                        //System.out.println("WARNING FOR CPU! horiz line = " + (i + 1)); // i - horiz line
//                        for (int k = 0; k < size; k++) {
//        if (map[i][k] == cNull) {
//        map[i][k] = c;
//        return;
