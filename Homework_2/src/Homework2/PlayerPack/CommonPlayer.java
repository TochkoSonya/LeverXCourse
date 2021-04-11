package Homework2.PlayerPack;

import Homework2.IBase;

import java.util.Random;
import java.util.Scanner;

public abstract class CommonPlayer implements IBase {

    protected Random random;
    protected Scanner scanner;

    protected CommonPlayer() {
        random=new Random();
        scanner = new Scanner(System.in);
    }

    protected boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[x][y] == Symbol.SIGN_EMPTY.getValue();
    }

    public abstract void move(Symbol symbol);

}
