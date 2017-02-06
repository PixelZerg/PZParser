package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 06/02/17.

 2.4.4.5

 string-literal:
        regular-string-literal
        verbatim-string-literal
 regular-string-literal:
        "   regular-string-literal-charactersopt   "
 regular-string-literal-characters:
        regular-string-literal-character
        regular-string-literal-characters   regular-string-literal-character
 regular-string-literal-character:
        single-regular-string-literal-character
        simple-escape-sequence
        hexadecimal-escape-sequence
        unicode-escape-sequence
 single-regular-string-literal-character:
        Any character except " (U+0022), \ (U+005C), and new-line-character
 verbatim-string-literal:
        @"   verbatim -string-literal-charactersopt   "
 verbatim-string-literal-characters:
        verbatim-string-literal-character
        verbatim-string-literal-characters   verbatim-string-literal-character
 verbatim-string-literal-character:
        single-verbatim-string-literal-character
        quote-escape-sequence
 single-verbatim-string-literal-character:
        Any character except "
 quote-escape-sequence:
        ""
 */
//TODO
public class StringLiteral extends TokenMatcher {
    public StringLiteral(){ super.type = Token.TokenType.STRING_LITERAL; }

    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        return s.getOffset(save);
    }
}
