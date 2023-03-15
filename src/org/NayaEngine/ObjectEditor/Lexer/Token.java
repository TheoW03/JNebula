package org.NayaEngine.ObjectEditor.Lexer;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Token {
    public enum Tokens {
        GAME_OBJECT, STRING, COMPONENT,
        BOOLEAN,NUMBER,STR, COMMA, PARENTHSIS, END_OF_LINE, GROUP
    }

    public Token.Tokens tokens;
    public String characters;

    public Token(String characters, Token.Tokens tokens) {
        this.tokens = tokens;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return tokens + "(" + characters + ")";
    }
}
