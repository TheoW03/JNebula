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
        int wordstate = 1;
        boolean stateisword = false;
        boolean stateisstring = false;
        boolean stateiscomment = false;
        HashMap<String, Token> operators = new HashMap<>();
        operators.put("{", new Token("{", Token.Tokens.OPEN_BRACE));
        operators.put("}", new Token("}", Token.Tokens.CLOSE_BRACE));
        operators.put(":", new Token(":", Token.Tokens.EQAULS_TO));
        operators.put(")", new Token("(", Token.Tokens.PARENTHSIS));
        operators.put("(", new Token(")", Token.Tokens.PARENTHSIS));
        operators.put(";", new Token(";", Token.Tokens.END_OF_LINE));
        operators.put(",", new Token(",", Token.Tokens.COMMA));
        String buffer = "";
        String wordbuffer = "";
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            for (int i1 = 0; i1 < currentLine.length(); i1++) {
                char currentCChar = currentLine.charAt(i1);
                if (currentCChar == '/') {
                    stateiscomment = true;
                }
                if (stateiscomment) {
                    continue;
                }
                if (currentCChar != ' ' && currentCChar != '\0' && currentCChar != '\t') {
                    switch (currentCChar) {
                        case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '*', ')', '(', '.', '-',',',';' -> { //can I regex

                        }
                        default -> {
                            stateisword = true;
                        }
                    }
                    if (stateisstring) {
                        if (currentCChar == '"') {
                            if (!buffer.equals("")) {
                                tokens.add(new Token(buffer, Token.Tokens.STRING));
                                buffer = "";
                            }

//                            stateIsNum = true;
                            stateisstring = false;
                            continue;
                        }
                        buffer += currentCChar;
                        continue;
                    }
                    if (currentCChar == '"') {
                        stateisstring = true;
                        continue;
                    }

                    //                    switch (currentCChar) {
//                        case '1', '2', '3', '4', '5', '6', '7', '8', '9','-',')' -> {
//                            stateisword = false;
//                        }
//                        default -> {
//                            stateisword = true;
//                        }
//                    }
                    //state
                    if (!stateisword) {
                        if (!wordbuffer.equals("")) {
                            if (operators.getOrDefault(wordbuffer, null) != null) {
                                tokens.add(operators.get(wordbuffer));
                                wordbuffer = "";
                            } else {
                                tokens.add(new Token(wordbuffer, Token.Tokens.WORD));
                                wordbuffer = "";
                            }
                        }
                        if (state == 1) {
                            if (tokens.size() != 1) {
                                tokens.forEach(contents -> {
                                    System.out.println("token debug: " + contents.toString());
                                });
                            }

                            System.out.println("state: " + state + " buffer: " + buffer + " line: " + i + " current: " + i1);
                            switch (currentCChar) {
                                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '.' -> {
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
                        } else if (state == 2) {
                            if (tokens.size() != 1) {
                                tokens.forEach(contents -> {
                                    System.out.println("token debug: " + contents.toString());
                                });
                            }
                            System.out.println("state: " + state + " buffer: " + buffer + " line: " + i + " current: " + i1);
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
                                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '.' -> {
                                    state = 1;
                                    buffer += currentCChar;
                                }
                                case ';' -> {
                                    buffer += currentCChar;
                                }

                            }
                        }
                    } else {
                        if (wordstate == 1) {
                            switch (currentCChar) {
                                case '(', ';', ',', ')', '{', '}', ':' -> {
                                    stateisword = false;
                                    if (!wordbuffer.equals("")) {
                                        tokens.add(new Token(wordbuffer, Token.Tokens.WORD));
                                        wordbuffer = "";
                                    }
                                    wordbuffer += currentCChar;
                                    if (operators.getOrDefault(wordbuffer, null) != null) {
                                        tokens.add(operators.get(wordbuffer));
                                        wordbuffer = "";
                                    }

                                }
                                default -> {
                                    wordbuffer += currentCChar;
                                }
                            }


                        }

                    }
                } else {
                    if (!buffer.equals("")) {
                        if (buffer.equals(",")) {

                            tokens.add(new Token(buffer, Token.Tokens.COMMA));
                            buffer = "";

                        } else if (buffer.equals(")") || buffer.equals("(")) {
                            tokens.add(new Token(buffer, Token.Tokens.PARENTHSIS));
                            buffer = "";
                        } else if (buffer.equals(";")) {
                            tokens.add(new Token(buffer, Token.Tokens.END_OF_LINE));
                            buffer = "";
                        } else {
                            tokens.add(new Token(buffer, Token.Tokens.NUMBER));
                            buffer = "";

                        }
                    }

                }

//                }else


            }
            stateiscomment = false;
        }
        return tokens;
    }
}
