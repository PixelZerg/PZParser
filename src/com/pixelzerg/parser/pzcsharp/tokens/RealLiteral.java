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
		if(!real_literal(s))return 0;
        return s.getOffset(save);
    }
	
	public boolean real_literal(Scanner s){
		if(!IntegerLiteral.decimal_digits(s)){
			if(!dot(s))return false;
			if(!IntegerLiteral.decimal_digits(s))return false;
			exponent_part(s);
			real_type_suffix(s);
			return true;
		}
		if(!dot(s)){
			if(!real_type_suffix(s)){
				if(!exponent_part(s))return false;
				real_type_suffix(s);
				return true;
			}
			return true;
		}
		if(!IntegerLiteral.decimal_digits(s))return false;
		exponent_part(s);
		real_type_suffix(s);
		return true;
	}
	
	public boolean real_type_suffix(Scanner s){
		char c = s.getCur();
		if(IsRealTypeSuffix(Character.toLowerCase(c))){
			s.increment(1);
			return true;
		}
		return false;
	}
	
	public boolean IsRealTypeSuffix(char c){
		return (c=='f'||c=='d'||c=='m');
	}
	
	public boolean exponent_part(Scanner s){
		if(!e(s))return false;
		sign(s);
		if(!IntegerLiteral.decimal_digits(s))return false;
		return true;
	}
	
	public boolean e(Scanner s){
		char c=s.getCur();
		if(Character.toLowerCase(c)==('e')){
			s.increment(1);
			return true;
		}
		return false;
	}
	
	public boolean sign(Scanner s){
		char c = s.getCur();
		if(IsSign(c)){
			s.increment(1);
			return true;
		}
		return false;
	}
	
	public boolean IsSign(char c){
		return (c=='+'||c=='-');
	}
	
	public boolean dot(Scanner s){
		char c = s.getCur();
		if(IsDot(c)){
			s.increment(1);
			return true;
		}
		return false;
	}
	
	public boolean IsDot(char c){
		return c=='.';
	}
}
