package Homework2;

public interface IBase {
    enum Mode{
        ComputerHuman,
        HumanHuman
    }

    enum Symbol{
        SIGN_X("x"),
        SIGN_O("o"),
        SIGN_EMPTY(".");
        private String value;
        Symbol(String value){
            this.value=value;
        }
        public String getValue(){return value;}
    }

    String[][] table= new String[3][3];
}
