package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;
import com.pixelzerg.parser.pzcsharp.errorhandling.CompilerException;

/**
 * Created by pixelzerg on 06/02/17.

 2.3.3
 */

public class Comment extends TokenMatcher {
    public enum CommentType{
        NONE,
        SINGLE_LINE,
        DELIMITED
    }
    public CommentType commentType = CommentType.NONE;
    public Comment(){ super.type = Token.TokenType.COMMENT; }

    public int Step(Scanner s) throws CompilerException {
        if(!lit_double_slash(s)){
            if(lit_comment_start(s)){
                commentType = CommentType.DELIMITED;
                return Utils.firstIndexOf(s,"*/")+4;//4={*/}+{/*}
            }
            return 0;
        }
        commentType=CommentType.SINGLE_LINE;
        return Utils.firstIndexOf(s,"\n")+2;//2={//}
    }

    public static boolean lit_double_slash(Scanner s){
        return Utils.match(s,"//");
    }

    public static boolean lit_comment_start(Scanner s){
        return Utils.match(s,"/*");
    }

}
