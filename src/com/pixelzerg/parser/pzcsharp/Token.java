package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Pos;
import com.pixelzerg.parser.Scanner;

public class Token {
	public enum TokenType{
		NONE,
		IDENTIFIER,
		KEYWORD,
		BOOLEAN_LITERAL,
		INTEGER_LITERAL,
		REAL_LITERAL,
		CHARACTER_LITERAL,
		STRING_LITERAL,
		NULL_LITERAL,
		OPERATOR_OR_PUNCTUATOR,
	}
	public String value = null;
	public Token.TokenType type = Token.TokenType.NONE;
	public Pos pos = new Pos();
	
	public Token(){}
	
	public Token(Scanner s){
		this.pos = s.getPos();
	}
	
	public String toStringPretty() {
        return "{\r\n\"value\": \"" + jsonEscape(this.value) + "\",\r\n  \"type\": {\r\n    \"index\": " + this.type.ordinal() + ",\r\n    \"value\": \"" + this.type.toString() + "\"\r\n  },\r\n  \"pos\": " + pos.toString()+ "\r\n}";
    }

    public String toString() {
        return "{\"value\": \"" + jsonEscape(this.value)+ "\", \"type\": { \"index\": " + this.type.ordinal() + ", \"value\": \"" + this.type.toString() + "\"}, \"pos\": " + this.pos.toString() + "}";
    }

    public String jsonEscape(String s){
	    return s.replace("\"", "\\\"").replace("\n","\\n");
    }
	

}
