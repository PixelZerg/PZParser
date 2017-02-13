package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.1
 boolean-literal:
        true
        false
 */

public class BooleanLiteral extends TokenMatcher {
    public BooleanLiteral(){ super.type = Token.TokenType.BOOLEAN_LITERAL; }

    public int Step(Scanner s){
        return Utils.matchn(s,false,false,"true","false");
    }
}
