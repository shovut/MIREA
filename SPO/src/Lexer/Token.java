package Lexer;

public class Token {
    private TokenEnum typeOfTokenEnum;
    private String value;

    Token(TokenEnum typeOfTokenEnum, String value) {
        this.typeOfTokenEnum = typeOfTokenEnum;
        this.value = value;
    }

    public TokenEnum getLexeme() {
        return typeOfTokenEnum;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return typeOfTokenEnum + " '" + value + "'";
    }
}
