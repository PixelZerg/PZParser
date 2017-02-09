package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Grammar;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 05/02/17.

 2.4.2
 identifier:
        available-identifier
        @   identifier-or-keyword
 available-identifier:
        An identifier-or-keyword that is not a keyword
 identifier-or-keyword:
        identifier-start-character   identifier-part-charactersopt
 identifier-start-character:
        letter-character
        _ (the underscore character U+005F)
 identifier-part-characters:
        identifier-part-character
        identifier-part-characters   identifier-part-character
 identifier-part-character:
        letter-character
        decimal-digit-character
        connecting-character
        combining-character
        formatting-character
 */

public class Identifier extends TokenMatcher{
    public Identifier(){
        super.type = Token.TokenType.IDENTIFIER;
    }
    public boolean usesAt = false;
    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        if(!available_identifier(s)){
            if(!(s.getCur()=='@'))return 0;
            s.increment(1);
            if(!identifier_or_keyword(s))return 0;
            usesAt=true;
        }
        return s.getOffset(save);
    }

    public static boolean available_identifier(Scanner s){
        if(new Keyword().StepSafe(s) == 0 && identifier_or_keyword(s)){
            return true;
        }
        return false;
    }

    public static boolean identifier_or_keyword(Scanner s){
        if(!identifier_start_character(s))return false;
        if(!identifier_part_characters(s)){
            return true;
        }
        return true;
    }

    public static boolean identifier_start_character(Scanner s){
        if(Grammar.letter_character(s.getCur()) == 1|| s.getCur()=='\u005f'){
            s.increment(1);
            return true;
        }
        return false;
    }

    public static boolean identifier_part_characters(Scanner s){
        if(!identifier_part_character(s))return false;
        while(identifier_part_character(s)){}
        return true;
    }

    public static boolean identifier_part_character(Scanner s){
        char c = s.getCur();
        if(IsIdentifierPartCharacter(c)){
            s.increment(1);
            return true;
        }
        return false;
    }

    public static boolean IsIdentifierPartCharacter(char c){
        return (Grammar.letter_character(c)==1||
                Grammar.decimal_digit_character(c)==1||
                Grammar.connecting_character(c)==1||
                Grammar.combining_character(c)==1||
                Grammar.formatting_character(c)==1);
    }
}
