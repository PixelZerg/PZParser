package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.1
 boolean-literal:
        true
        false
 */
//TODO
public class BooleanLiteral extends TokenMatcher {
    public BooleanLiteral(){ super.type = Token.TokenType.BOOLEAN_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
