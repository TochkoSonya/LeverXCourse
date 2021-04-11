package Homework2.PlayerPack;

import java.util.Scanner;
import Homework2.Symbol;

public class HumanPlayer extends CommonPlayer {

    private Scanner scanner;
    public HumanPlayer(){
        scanner = new Scanner(System.in);
    }
    public void move(Symbol symbol) {
        int x;
        int y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = symbol.getValue();
    }
}
