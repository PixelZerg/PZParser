package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.4

 character-literal:
        '   character   '
 character:
        single-character
        simple-escape-sequence
        hexadecimal-escape-sequence
        unicode-escape-sequence
 single-character:
         Any character except ' (U+0027), \ (U+005C), and new-line-character
 simple-escape-sequence: one of
        \' \" \\ \0 \a \b \f \n \r \t \v
 hexadecimal-escape-sequence:
        \x   hex-digit   hex-digitopt   hex-digitopt   hex-digitopt
 */
//TODO
public class CharacterLiteral extends TokenMatcher {
    public CharacterLiteral(){ super.type = Token.TokenType.CHARACTER_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
