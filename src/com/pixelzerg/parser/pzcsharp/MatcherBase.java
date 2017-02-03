package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.pzcsharp.Token;

public class MatcherBase {
    public com.pixelzerg.parser.pzcsharp.Utils.TokenType type = com.pixelzerg.parser.pzcsharp.Utils.TokenType.Token;

    public Token Select(Scanner scanner) {
        //look at cur char in scanner
		//look ahead
		//then once done, if full match and see whitespace, return substring and increment Scanner index
		//otherwise, return null
        return null;
    }
}

