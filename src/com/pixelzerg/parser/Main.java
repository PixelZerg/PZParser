package com.pixelzerg.parser;

import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.Utils;
import com.pixelzerg.parser.pzcsharp.matchers.KeywordMatcher;

public class Main {

    //TODO parse with methods for each production
    public static void main(String[] args) {
        Scanner s = new Scanner("m\roo\r\nyoo");
        Token t = new Token(s);
        System.out.println(t.toStringPretty());
        char c = (char) -1;
        while (true) {
            c = s.getCur();
            System.out.println(Expand(c)+"\t"+s.getPos());
            if(c==(char)-1){
                break; 
            }
            s.increment(1);
        }
//        KeywordMatcher m = new KeywordMatcher("moo", Utils.TokenType.Token);
//        System.out.println(m.Select(s));
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
