package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.pzcsharp.Token;

public class MatcherBase {
    public com.pixelzerg.parser.pzcsharp.Token.TokenType type = com.pixelzerg.parser.pzcsharp.Token.TokenType.NONE;

    public Token Select(Scanner scanner) {
        //look at cur char in scanner
		//look ahead
		//then once done, if full match and see whitespace, return substring and increment Scanner index
		//otherwise, return null
        return null;
    }
}

