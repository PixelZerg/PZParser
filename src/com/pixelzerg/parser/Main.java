package com.pixelzerg.parser;

import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.tokens.*;

public class Main {

    //TODO parse with methods for each production
    public static void main(String[] args) {
        Scanner s = new Scanner("@moo%yo");
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
        Identifier m = new Identifier();
        Token t = new Token(s);
        t.value = s.read(m.StepSafe(s));
        t.type=m.type;
        System.out.println(t.toStringPretty());
        //TODO: Fix @
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
