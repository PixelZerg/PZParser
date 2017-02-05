package com.pixelzerg.parser.pzcsharp;

/**
 * Created by pixelzerg on 05/02/17.
 */
public class Grammar {
    public static int whitespace(char c){
        if(Utils.CheckCharacter(c,12))return 1; //Zs
        else if(c == '\u0009')return 1;
        else if(c == '\u000B')return 1;
        else if(c == '\u000C')return 1;
        return 0;
    }

    public static int letter_character(char c){
        if(Utils.CheckCharacter(c, Utils.CharacterType.Letter))return 1;
        return 0;
    }

    public static int combining_character(char c){
        if(Utils.CheckCharacter(c, Utils.CharacterType.Combining))return 1;
        return 0;
    }

    public static int decimal_digit_character(char c){
        if(Utils.CheckCharacter(c, Utils.CharacterType.DecimalDigit))return 1;
        return 0;
    }

    public static int connecting_character(char c){
        if(Utils.CheckCharacter(c, Utils.CharacterType.Connecting))return 1;
        return 0;
    }

    public static int formatting_character(char c){
        if(Utils.CheckCharacter(c, Utils.CharacterType.Formatting))return 1;
        return 0;
    }

}
