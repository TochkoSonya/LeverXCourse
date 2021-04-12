package Homework2;

import Homework2.PlayerPack.ComputerPlayer;
import Homework2.PlayerPack.HumanPlayer;
import Homework2.UtilPack.Mode;
import Homework2.UtilPack.Symbol;
import Homework2.UtilPack.Util;

public class Game implements IBase{

    private Util util;
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    private HumanPlayer humanPlayer2;

    private Mode mode;

    Game() {
        util=new Util();
        computerPlayer= new ComputerPlayer();
        humanPlayer= new HumanPlayer();
        humanPlayer2= new HumanPlayer();
    }

    public static void main(String[] args) {
        Game newGame=new Game();
        newGame.game();
    }

    private void game() {
        util.initTable();
        mode=util.chooseOpponent();
        if(mode==Mode.ComputerHuman)
        {
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (util.checkWin(Symbol.SIGN_X)) {
                    System.out.println("YOU WIN!");
                    break;
                }
                if (util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                computerPlayer.move(Symbol.SIGN_O);
                util.printTable();
                if (util.checkWin(Symbol.SIGN_O)) {
                    System.out.println("AI WIN!");
                    break;
                }
                if (util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            util.printTable();
        }
        else if(mode==Mode.HumanHuman){
            while (true) {
                humanPlayer.move(Symbol.SIGN_X);
                if (util.checkWin(Symbol.SIGN_X)) {
                    System.out.println("Player1 WIN!");
                    break;
                }
                if (util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                humanPlayer2.move(Symbol.SIGN_O);
                util.printTable();
                if (util.checkWin(Symbol.SIGN_O)) {
                    System.out.println("Player2 WIN!");
                    break;
                }
                if (util.isTableFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            util.printTable();
        }
    }

}


