package org.NayaEngine.ObjectEditor.Lexer;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Lexxer {
    public ArrayList<String> lines;
    public Lexxer(ArrayList<String> lines) {
        this.lines = lines;
    }
    public ArrayList<Token> lexString(){
        ArrayList<Token> tokens = new ArrayList<>();
        return tokens;
    }
}
