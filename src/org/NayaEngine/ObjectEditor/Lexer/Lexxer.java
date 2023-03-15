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

    public HashMap<String, Token> tokenMap = new HashMap<>();
    public ArrayList<Token> lexString() {
        ArrayList<Token> tokens = new ArrayList<>();
        int state = 1;
        boolean stateisword = true;
        String buffer = "";
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            for (int i1 = 0; i1 < currentLine.length(); i1++) {
                char currentCChar = currentLine.charAt(i1);

                if (currentCChar != ' ' && currentCChar != '\0' && currentCChar != '\t') {
//                    switch (currentCChar) {
//                        case '1', '2', '3', '4', '5', '6', '7', '8', '9','-',')' -> {
//                            stateisword = false;
//                        }
//                        default -> {
//                            stateisword = true;
//                        }
//                    }
                    //state
//                    if(!stateisword){
                    if (state == 1) {
                        if(tokens.size() != 1){
                            tokens.forEach(contents -> {
                                System.out.println("token debug: "+contents.toString());
                            });
                        }

                        System.out.println("state: " +state+" buffer: "+ buffer +" line: "+i+" current: "+i1);
                        switch (currentCChar) {
                            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-' -> {
                                buffer += currentCChar;
                            }
                            case '(', ';', ',', ')' -> {
                                state = 2;
                                if (!buffer.equals("")) {
                                    tokens.add(new Token(buffer, Token.Tokens.NUMBER));
                                    buffer = "";
                                }


                                buffer += currentCChar;
                            }
                        }
                    }else if (state == 2) {
                        if(tokens.size() != 1){
                            tokens.forEach(contents -> {
                                System.out.println("token debug: "+contents.toString());
                            });
                        }

                        System.out.println("state: " +state+" buffer: "+ buffer +" line: "+i+" current: "+i1);
                        if (buffer.equals(",")) {

                            tokens.add(new Token(buffer, Token.Tokens.COMMA));
                            buffer = "";

                        } else if (buffer.equals(")") || buffer.equals("(")) {
                            tokens.add(new Token(buffer, Token.Tokens.PARENTHSIS));
                            buffer = "";
                        } else if (buffer.equals(";")) {
                            tokens.add(new Token(buffer, Token.Tokens.END_OF_LINE));
                            buffer = "";
                        }
                        switch (currentCChar) {
                            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-' -> {
                                state = 1;
                                buffer += currentCChar;
                            }
                            case ';' -> {
                                buffer += currentCChar;
                            }

                        }
                    }

                } else {
//                    if (state == 1) {
//                        buffer.append(currentCChar);
//
//                    }
                }

//                }else


            }
        }
        return tokens;
    }
}
