package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class CharUtils {
    public static boolean IsNewline(char c){
        return (c=='\r'||c=='\n'||c=='\u2028'||c=='\u2029');
    }

    public static String Expand(char c) {
        if (c == (char) -1) {
            return "EOF";
        } else if (c == '\n') {
            return "NL";
        }
        else if (c == '\r') {
            return "CR";
        }
        return "" + c;
    }
}
