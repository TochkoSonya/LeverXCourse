package Homework2;

import Homework2.PlayerPack.ComputerPlayer;
import Homework2.PlayerPack.HumanPlayer;
import Homework2.UtilPack.Mode;
import Homework2.UtilPack.Symbol;

import java.util.Scanner;

public class Game implements IBase{

    private Scanner scanner;
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    private HumanPlayer humanPlayer2;

    private Mode mode;

    Game() {
        scanner=new Scanner(System.in);
        computerPlayer= new ComputerPlayer();
        humanPlayer= new HumanPlayer();
        humanPlayer2= new HumanPlayer();
    }

    public static void main(String[] args) {
        Game newGame=new Game();
        newGame.game();
    }

    private void game() {
        initTable();
        mode=chooseOpponent();
        if(mode==Mode.ComputerHuman)
        {
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (checkWin(Symbol.SIGN_X)) {
                    System.out.println("YOU WIN!");
                    break;
                }
                if (isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                computerPlayer.move(Symbol.SIGN_O);
                printTable();
                if (checkWin(Symbol.SIGN_O)) {
                    System.out.println("AI WIN!");
                    break;
                }
                if (isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            printTable();
        }
        else if(mode==Mode.HumanHuman){
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (checkWin(Symbol.SIGN_X)) {
                    System.out.println("Player1 WIN!");
                    break;
                }
                if (isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                humanPlayer2.move(Symbol.SIGN_O);
                printTable();
                if (checkWin(Symbol.SIGN_O)) {
                    System.out.println("Player2 WIN!");
                    break;
                }
                if (isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            printTable();
        }
    }

    public Mode chooseOpponent(){
        System.out.println("Choose an opponent - computer(0) or human(1)");
        int x = scanner.nextInt();
         return x==0 ? Mode.ComputerHuman : Mode.HumanHuman;
    }

    public void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = Symbol.SIGN_EMPTY.getValue();
    }

    public void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    public boolean checkWin(Symbol symbol) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == symbol.getValue() && table[i][1] == symbol.getValue() &&
                    table[i][2] == symbol.getValue()) ||
                    (table[0][i] == symbol.getValue() && table[1][i] == symbol.getValue() &&
                            table[2][i] == symbol.getValue()))
                return true;
        if ((table[0][0] == symbol.getValue() && table[1][1] == symbol.getValue() &&
                table[2][2] == symbol.getValue()) ||
                (table[2][0] == symbol.getValue() && table[1][1] == symbol.getValue() &&
                        table[0][2] == symbol.getValue()))
            return true;
        return false;
    }

    public boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == Symbol.SIGN_EMPTY.getValue())
                    return false;
        return true;
    }
}


