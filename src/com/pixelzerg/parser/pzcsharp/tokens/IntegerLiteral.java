package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.2

 integer-literal:
        decimal-integer-literal
        hexadecimal-integer-literal
 decimal-integer-literal:
        decimal-digits   integer-type-suffixopt
 decimal-digits:
        decimal-digit
        decimal-digits   decimal-digit
 decimal-digit: one of
        0 1 2 3 4 5 6 7 8 9
 integer-type-suffix: one of
        U u L l UL Ul uL ul LU Lu lU lu
 hexadecimal-integer-literal:
        0x   hex-digits   integer-type-suffixopt
         0X   hex-digits   integer-type-suffixopt
 hex-digits:
        hex-digit
        hex-digits   hex-digit
 hex-digit: one of
        0 1 2 3 4 5 6 7 8 9 A B C D E F a b c d e f
 */
//TODO
public class IntegerLiteral extends TokenMatcher {
    public IntegerLiteral(){ super.type = Token.TokenType.INTEGER_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
