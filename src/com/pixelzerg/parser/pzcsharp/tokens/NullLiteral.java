package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.6
 null-literal:
        null
 */
//TODO
public class NullLiteral extends TokenMatcher {
    public NullLiteral(){ super.type = Token.TokenType.NULL_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
