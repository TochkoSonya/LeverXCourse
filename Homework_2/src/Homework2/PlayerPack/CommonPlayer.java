package Homework2.PlayerPack;

import Homework2.IBase;
import Homework2.Symbol;

public abstract class CommonPlayer implements IBase{

    protected boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[x][y] == Symbol.SIGN_EMPTY.getValue();
    }

    public abstract void move(Symbol symbol);

}
