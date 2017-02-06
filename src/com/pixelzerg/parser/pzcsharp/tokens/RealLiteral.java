package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.3

 real-literal:
        decimal-digits   .   decimal-digits   exponent-partopt   real-type-suffixopt
        .   decimal-digits   exponent-partopt   real-type-suffixopt
        decimal-digits   exponent-part   real-type-suffixopt
        decimal-digits   real-type-suffix
 exponent-part:
        e   signopt   decimal-digits
        E   signopt   decimal-digits
 sign: one of
        + -
 real-type-suffix: one of
        F f D d M m
 */
//TODO
public class RealLiteral extends TokenMatcher {
    public RealLiteral(){ super.type = Token.TokenType.REAL_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
