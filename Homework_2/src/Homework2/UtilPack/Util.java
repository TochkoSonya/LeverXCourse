package Homework2.UtilPack;

import Homework2.IBase;

public class Util implements IBase {

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
