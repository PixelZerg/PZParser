package com.pixelzerg.parser;

import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.tokens.KeywordTokenMatcher;

public class Main {

    //TODO parse with methods for each production
    public static void main(String[] args) {
        Scanner s = new Scanner("m\roo\r\nyoo");
//        NONE t = new NONE(s);
//        System.out.println(t.toStringPretty());
//        char c = (char) -1;
//        while (true) {
//            c = s.getCur();
//            System.out.println(Expand(c)+"\t"+s.getPos());
//            if(c==(char)-1){
//                break;
//            }
//            s.increment(1);
//        }
        KeywordTokenMatcher m = new KeywordTokenMatcher("moo", Token.TokenType.NONE);
        System.out.println(m.Select(s));
    }

    public static String Expand(char c) {
        if (c == (char) -1) {
            return "-1";
        } else if (c == '\n') {
            return "NL";
        }
        else if (c == '\r') {
            return "CR";
        }
        return "" + c;
    }
}
