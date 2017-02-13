package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;

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

public class IntegerLiteral extends TokenMatcher {
    public enum IntegerLiteralType{
        NONE,
        HEX,
        DECIMAL,
    }
    public IntegerLiteral() {
        super.type = Token.TokenType.INTEGER_LITERAL;
    }

    public IntegerLiteralType integerLiteralType = IntegerLiteralType.NONE;

    public int Step(Scanner s) {
        ScannerSave save = s.saveq();
        if(!integer_literal(s))return 0;
        return s.getOffset(save);
    }

    public boolean integer_literal(Scanner s) {
        if (!hexadecimal_integer_literal(s)) {
            if (!decimal_integer_literal(s)) return false;
            this.integerLiteralType = IntegerLiteralType.DECIMAL;
        }
        this.integerLiteralType = IntegerLiteralType.HEX;
        return true;

    }

    public static boolean decimal_integer_literal(Scanner s) {
        if (!decimal_digits(s)) return false;
        integer_type_suffix(s); //optional
        return true;
    }

    public static boolean decimal_digits(Scanner s) {
        if (!decimal_digit(s)) return false;
        while (decimal_digit(s)) {
        }
        return true;
    }

    public static boolean decimal_digit(Scanner s) {
        return Utils.match(s,"0","1","2","3","4","5","6","7","8","9");
    }

    public static boolean hexadecimal_integer_literal(Scanner s) {
        if(!hex_start(s))return false;
        if(!hex_digits(s))return false;
        integer_type_suffix(s);
        return true;
    }

    public static boolean hex_start(Scanner s){
        return Utils.match(s,"0x","0X");
    }

    public static boolean hex_digits(Scanner s){
        if(!hex_digit(s))return false;
        while(hex_digit(s)){}
        return true;
    }

    public static boolean hex_digit(Scanner s){
        if(!decimal_digit(s)){
            return Utils.match(s,true,"a","b","c","d","e","f");
        }
        return true;
    }

    public static boolean integer_type_suffix(Scanner s){
        char c = Character.toLowerCase(s.getCur());
        if(c == 'u'){
            s.increment(1);
            if(Character.toLowerCase(s.getCur())=='l'){
                s.increment(1);
            }
        }
        else if(c == 'l'){
            s.increment(1);
            if(Character.toLowerCase(s.getCur()) == 'u'){
                s.increment(1);
            }
        }else{
            return false;
        }
        return true;
    }
}
