package Homework2.PlayerPack;
import java.util.Random;
import Homework2.UtilPack.Symbol;

public class ComputerPlayer extends CommonPlayer {

    private Random random;

    public ComputerPlayer(){
        random=new Random();
    }

    public void move(Symbol symbol) {
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
