package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Grammar;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;

/**
 * Created by pixelzerg on 05/02/17.
 */
public class Identifier extends TokenMatcher{
    public Identifier(){
        super.type = Token.TokenType.IDENTIFIER;
    }
    public int Step(Scanner s){
        ScannerSave save = s.saveq();
        if(!available_identifier(s))return 0;
        else if(s.next()=='@'){
            if(!identifier_or_keyword(s))return 0;
        }
        return s.getOffset(save);
    }

    public boolean available_identifier(Scanner s){
        if(new Keyword().StepSafe(s) == 0 && identifier_or_keyword(s)){
            return true;
        }
        return false;
    }

    public boolean identifier_or_keyword(Scanner s){
        if(identifier_start_character(s)){
            identifier_part_characters(s);
            return true;
        }
        return false;
    }

    public boolean identifier_start_character(Scanner s){
        if(Grammar.letter_character(s.getCur()) == 1|| s.getCur()=='\u005f'){
            s.increment(1);
            return true;
        }
        return false;
    }

    public boolean identifier_part_characters(Scanner s){
        if(identifier_part_character(s))return true;
        else if(identifier_part_characters(s)){
            return identifier_part_character(s);
        }
        return false;
    }

    public boolean identifier_part_character(Scanner s){
        char c = s.getCur();
        if(Grammar.letter_character(c)==1||
                Grammar.decimal_digit_character(c)==1||
                Grammar.connecting_character(c)==1||
                Grammar.combining_character(c)==1||
                Grammar.formatting_character(c)==1){
            s.increment(1);
            return true;
        }
        return false;
    }
}
