package Homework2.PlayerPack;
import java.util.Random;
import Homework2.UtilPack.Symbol;
import Homework2.UtilPack.Util;

public class ComputerPlayer extends CommonPlayer {

    private Random random;
    private boolean firstMove;
    
    public ComputerPlayer(){
        random = new Random();
        firstMove=true;
    }

    public void move(Symbol symbol) {
        if(firstMove) {                 // first move - random
            firstMove=false;
            moveRandom(symbol);
        }
        else {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (isCellValid(row, col)) {
                        table[row][col] = Symbol.SIGN_X.getValue();

                        if (Util.checkWin(Symbol.SIGN_X)) {         // check if there is a winning move for the player - put o there
                            table[row][col] = symbol.getValue();
                            return;
                        } else if (!Util.checkWin(Symbol.SIGN_X)) {     // if the move is not winning - return empty
                            table[row][col] = Symbol.SIGN_EMPTY.getValue();
                        }
                    }
                }
            }
        }
    }

    private void moveRandom(Symbol symbol) {
        int range=3;
        int x;
        int y;
            do {
                x = random.nextInt(range);
                y = random.nextInt(range);
            } while (!isCellValid(x, y));
            table[x][y] = symbol.getValue();
    }

}
