package Homework2;

public enum Symbol {
    SIGN_X('x'), SIGN_O('o'), SIGN_EMPTY('.');
    private char value;
    Symbol(char value){
        this.value=value;
    }
    public char getValue(){return value;}
}
