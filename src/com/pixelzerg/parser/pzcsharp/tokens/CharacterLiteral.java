package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;

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

    public int Step(Scanner s) {
        ScannerSave save = s.saveq();
        if(!character_literal(s))return 0;
        return s.getOffset(save);
    }
    
    public boolean character_literal(Scanner s){
    	if(!quote(s))return false;
    	if(!character(s))return false;
    	if(!quote(s))return false;
    	return true;
    	
    }
    
    /*if(!q()){
    *         if(!r())return false;
    *     }
	*/
    public static boolean character(Scanner s) {
		if(!single_character(s)){
			if(!simple_escape_sequence(s)){
				if(!hexadecimal_escape_sequence(s))return false;
			}
		}
		return true;
	}
    
    public static boolean hexadecimal_escape_sequence(Scanner s){
    	if(!hex_start(s))return false;
    	if(!IntegerLiteral.hex_digit(s))return false;
    	IntegerLiteral.hex_digit(s);
    	IntegerLiteral.hex_digit(s);
    	IntegerLiteral.hex_digit(s);
    	return true;
    	
    }
    
    public static boolean hex_start(Scanner s){
    	String word = s.read(2);
    	if(word.equals("\\x")){
    		s.increment(word.length());
    		return true;
    	}
    	return false;
    }
    
    public static boolean simple_escape_sequence(Scanner s){
    	String word = s.read(2);
        if(word.equals("\\'")||word.equals("\\\"")||word.equals("\\\\")||word.equals("\\0")||
        		word.equals("\\a")||word.equals("\\b")||word.equals("\\f")||word.equals("\\n")||
        		word.equals("\\r")||word.equals("\\t")||word.equals("\\v")){
             s.increment(word.length());
             return true;
        }
        return false;
    }
    
    public static boolean single_character(Scanner s){
       char c = s.getCur();
//      if (c == (char) -1) return false;
       if (!IsSingleCharacter(c)) return false;
       s.increment(1);
       return true;
    }
    
    public static boolean IsSingleCharacter(char c){
    	return !(c=='\''||c=='\\');
    }

	public static boolean quote(Scanner s){
    	char c = s.getCur();
//      if (c == (char) -1) return false;
      if (!IsQuote(c)) return false;
      s.increment(1);
      return true;
    }
    
    public static boolean IsQuote(char c){
    	return c=='\'';
    }
}
