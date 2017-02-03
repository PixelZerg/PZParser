package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Pos;
import com.pixelzerg.parser.Scanner;

public class Token {
	public String value = null;
	public Utils.TokenType type = Utils.TokenType.Token;
	public Pos pos = new Pos();
	
	public Token(){}
	
	public Token(Scanner s){
		this.pos = s.getPos();
	}
	
	public String toStringPretty() {
        return "{\r\n\"value\": \"" + this.value + "\",\r\n  \"type\": {\r\n    \"index\": " + this.type.ordinal() + ",\r\n    \"value\": \"" + this.type.toString() + "\"\r\n  },\r\n  \"pos\": " + pos.toString()+ "\r\n}";
    }

    public String toString() {
        return "{\"value\": \"" + this.value + "\", \"type\": { \"index\": " + this.type.ordinal() + ", \"value\": \"" + this.type.toString() + "\"}, \"pos\": " + this.pos.toString() + "}";
    }
	

}
