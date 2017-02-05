package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;
import com.pixelzerg.parser.pzcsharp.Utils.CharacterType;

/**
 * Created by pixelzerg on 25/01/17.
 */
public class KeywordTokenMatcher extends TokenMatcher {
    public String keyword = null;
    public boolean identifierRules = true;

    public KeywordTokenMatcher(String keyword, Token.TokenType type) {
        this.keyword = keyword;
        super.type = type;
    }

    public Token Select(Scanner s) throws NullPointerException {
        if(this.keyword == null)throw new NullPointerException("Keyword not set in KeywordTokenMatcher");
        Token ret = new Token(s);
        
        String sel = "";
        if (identifierRules) {
            if (!IsValidStart(s.getCur())) return null;
            sel+=s.getCur();
        }
        int i;
        for (i = 1; !Utils.IsWhiteSpace(s.look(i)); i++) {
            if(i>this.keyword.length()-1){
                //System.out.println("TOO LONG!");
                return null; //too long!
        	}
        	
        	if(identifierRules){
        		if(!IsValid(s.look(i)))return null;
        	}

            if (this.keyword.charAt(i) != s.look(i)) {
                //System.out.println("MISMATCH!");
                return null;
            }
            sel+=s.look(i);
        }
        s.increment(i+1);//+1 because whitespace
        ret.value = sel;
        ret.type = super.type;
         return ret;
    }

    public static boolean IsValidStart(char c) {
        if (c == '_') return true;
        return Utils.CheckCharacter(c, Utils.CharacterType.Letter);
    }

    public static boolean IsValid(char c) {
        return Utils.CheckCharacter(c, CharacterType.Combining)||Utils.CheckCharacter(c, CharacterType.Connecting)||Utils.CheckCharacter(c, CharacterType.DecimalDigit)||Utils.CheckCharacter(c, CharacterType.Formatting)||Utils.CheckCharacter(c, CharacterType.Letter);
    }
}

