package Homework2;
import Homework2.PlayerPack.ComputerPlayer;
import Homework2.PlayerPack.HumanPlayer;
import Homework2.UtilPack.Mode;
import Homework2.UtilPack.Symbol;
import Homework2.UtilPack.Util;

public class Game implements Base {

    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    private HumanPlayer humanPlayer2;
    private Mode mode;

    public Game() {
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
        humanPlayer2 = new HumanPlayer();
    }

    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.game();
    }

    private void game() {
        Util.initTable();
        mode=Util.chooseOpponent();
        if (mode==Mode.ComputerHuman) {
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (Util.checkWin(Symbol.SIGN_X)) {
                    System.out.println("YOU WIN!");
                    break;
                }
                if (Util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                computerPlayer.move(Symbol.SIGN_O);
                Util.printTable();
                if (Util.checkWin(Symbol.SIGN_O)) {
                    System.out.println("AI WIN!");
                    break;
                }
                if (Util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            Util.printTable();
        }
        else if (mode==Mode.HumanHuman) {
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (Util.checkWin(Symbol.SIGN_X)) {
                    System.out.println("Player1 WIN!");
                    break;
                }
                if (Util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                humanPlayer2.move(Symbol.SIGN_O);
                Util.printTable();
                if (Util.checkWin(Symbol.SIGN_O)) {
                    System.out.println("Player2 WIN!");
                    break;
                }
                if (Util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            Util.printTable();
        }
    }
}


