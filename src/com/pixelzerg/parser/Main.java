package com.pixelzerg.parser;

import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.errorhandling.CompilerException;
import com.pixelzerg.parser.pzcsharp.tokens.*;

public class Main {

    //TODO parse with methods for each production
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Scanner s = new Scanner("1.2e+6M");
        RealLiteral m = new RealLiteral();

        long endTime;
        Token t = new Token(s);
        try {
            int step = m.StepSafe(s);
            endTime = System.nanoTime();
            t.value = s.read(step);
            t.type = m.type;
            System.out.println(step);
            System.out.println(t.toStringPretty());
        }catch (CompilerException e){
            endTime = System.nanoTime();
            System.out.println(e);
        }

        System.out.println("Time elapsed: "+((endTime - startTime)/1e6)+"ms");

    }
}
