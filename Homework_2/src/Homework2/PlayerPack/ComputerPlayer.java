package Homework2.PlayerPack;

public class ComputerPlayer extends CommonPlayer {

    public void move(Symbol symbol) {
        int x;
        int y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = symbol.getValue();
    }
}
