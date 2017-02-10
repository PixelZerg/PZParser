package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.CharUtils;
import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Grammar;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.errorhandling.CompilerException;

/**
 * Created by pixelzerg on 06/02/17.

 2.3.3
 */
//TODO
public class Comment extends TokenMatcher {
    public enum CommentType{
        NONE,
        SINGLE_LINE,
        DELIMITED
    }
    public CommentType commentType = CommentType.NONE;
    public Comment(){ super.type = Token.TokenType.COMMENT; }

    public int Step(Scanner s) throws CompilerException {
        ScannerSave save = s.saveq();
        if(!single_line_comment(s)){
            if(!delimited_comment(s))return 0;
            this.commentType = CommentType.DELIMITED;
        }
        this.commentType = CommentType.SINGLE_LINE;
        return s.getOffset(save);
    }

    public static boolean delimited_comment(Scanner s) throws CompilerException {
        if(!lit_comment_start(s))return false;
        delimited_comment_characters(s); //optional
        //if(!lit_comment_end(s))return false;
        //handled already in previous statement.
        return true;
    }

    public static boolean delimited_comment_characters(Scanner s) throws CompilerException {
        if(!delimited_comment_character(s))return false;
        while(delimited_comment_character(s)){}
        return true;
    }

    public static boolean delimited_comment_character(Scanner s) throws CompilerException {
        if(!not_asterisk(s)){
            if(!asterisk(s))return false;
            if(!not_slash(s)) {
                //i.e: did match */
                s.increment(1);//implement for later
                return false;
            }else{
                throw new CompilerException(false, s.filepath, s.getPos().lineno,s.getPos().charno-1, CompilerException.ErrorType.UnexpectedCharacter, "Unexpected \""+ CharUtils.Expand(s.getCur())+"\" - was expecting \"/\"");
            }
        }
        return true;
    }

    public static boolean asterisk(Scanner s){
        char c = s.getCur();
//        if(c==(char)-1)return false;
        if(c!='*')return false;
        s.increment(1);
        return true;
    }

    public static boolean not_asterisk(Scanner s){
        char c = s.getCur();
        if(c==(char)-1)return false;
        if(c=='*')return false;
        s.increment(1);
        return true;
    }

    public static boolean not_slash(Scanner s){
        char c = s.getCur();
//        if(c==(char)-1)return false;
        if(c=='/')return false;
        s.increment(1);
        return true;
    }

    public static boolean single_line_comment(Scanner s){
        if(!lit_double_slash(s))return false;
        input_characters(s); //optional
        return true;
    }

    public static boolean lit_double_slash(Scanner s){
        if(s.read(2).equals("//")){
            s.increment(2);
            return true;
        }
        return false;
    }

    public static boolean lit_comment_start(Scanner s){
        if(s.read(2).equals("/*")){
            s.increment(2);
            return true;
        }
        return false;
    }

    public static boolean lit_comment_end(Scanner s){
        if(s.read(2).equals("*/")){
            s.increment(2);
            return true;
        }
        return false;
    }

    public static boolean input_characters(Scanner s){
        if(!input_character(s)) return false;
        while(input_character(s)){}
        return true;
    }

    public static boolean input_character(Scanner s){
        char c = s.getCur();
//        if(c==(char)-1)return false;
        if(Grammar.new_line_character(c)==1)return false;
        s.increment(1);
        return true;
    }

}
