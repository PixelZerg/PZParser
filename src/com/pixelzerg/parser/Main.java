package com.pixelzerg.parser;

import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.tokens.*;

public class Main {

    //TODO parse with methods for each production
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner s = new Scanner("0X1Alu");
        IntegerLiteral m = new IntegerLiteral();
        Token t = new Token(s);
        int step = m.StepSafe(s);
        long endTime = System.nanoTime();
        System.out.println("Time elapsed: "+((endTime - startTime)/1e6)+"ms");
        t.value = s.read(step);
        t.type=m.type;
        System.out.println(step);
        System.out.println(t.toStringPretty());
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
