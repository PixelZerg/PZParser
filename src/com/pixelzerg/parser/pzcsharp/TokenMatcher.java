package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;

public class TokenMatcher {
    public com.pixelzerg.parser.pzcsharp.Token.TokenType type = com.pixelzerg.parser.pzcsharp.Token.TokenType.NONE;

    public int Step(Scanner scanner) {
        //look at cur char in scanner
		//look ahead
		//then once done, if full match and see whitespace, return substring and increment Scanner index
		//otherwise, return null
        return 0;
    }

    public int StepSafe(Scanner s){
        ScannerSave save = s.save();
        int ret = Step(s);
        s.load(save);
        return ret;
    }
}

