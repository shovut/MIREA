package Lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
    private StringBuilder input = new StringBuilder();
    private TokenEnum typeOfTokenEnum;
    private String value;
    private boolean flag = false;

    public Lexer(String input) {
        this.input.append(input);
    }

    public List<Token> getTokens() {
        List<Token> tokens = new ArrayList<>();
        while (input.length() != 0 && !flag) {
            deleteNonPrintable();

            if (findNextToken()) {
                tokens.add(new Token(typeOfTokenEnum, value));
            } else {
                flag = true;
            }
        }
        return tokens;
    }

    private boolean findNextToken() {
        for (TokenEnum tokenEnum : TokenEnum.values()) {
            Matcher matcher = tokenEnum.getPattern().matcher(input.toString());
            if (matcher.find()) {
                typeOfTokenEnum = tokenEnum;
                value = input.substring(matcher.start(), matcher.end());
                input.delete(matcher.start(), matcher.end());
                return true;
            }
        }
        return false;
    }

    private void deleteNonPrintable() {
        int pos = 0;
        while (input.charAt(pos) == ' ' || input.charAt(pos) == '\n' || input.charAt(pos) == '\r'
                || input.charAt(pos) == '\t') {
            pos++;
        }
        if (pos > 0) {
            input.delete(0, pos);
        }
    }
}
