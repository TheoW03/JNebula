package org.NayaEngine.ObjectEditor.Lexer;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Token {
    public enum Tokens {
        GAME_OBJECT, STRING, COMPENET
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
