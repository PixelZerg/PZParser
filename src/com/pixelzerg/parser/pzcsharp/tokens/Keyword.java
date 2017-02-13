package com.pixelzerg.parser.pzcsharp.tokens;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.Token;
import com.pixelzerg.parser.pzcsharp.TokenMatcher;
import com.pixelzerg.parser.pzcsharp.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pixelzerg on 05/02/17.

 2.4.3
 One of list
 */

public class Keyword extends TokenMatcher {
    private static List<String> keywords = null;
    public Keyword(){
        super.type = Token.TokenType.KEYWORD;
        if(keywords == null)Initialise();
    }

    private static void Initialise(){
        keywords = new ArrayList<String>();
        keywords.add("abstract");
        keywords.add("as");
        keywords.add("base");
        keywords.add("bool");
        keywords.add("break");
        keywords.add("byte");
        keywords.add("case");
        keywords.add("catch");
        keywords.add("char");
        keywords.add("checked");
        keywords.add("class");
        keywords.add("const");
        keywords.add("continue");
        keywords.add("decimal");
        keywords.add("default");
        keywords.add("delegate");
        keywords.add("do");
        keywords.add("double");
        keywords.add("else");
        keywords.add("enum");
        keywords.add("event");
        keywords.add("explicit");
        keywords.add("extern");
        keywords.add("false");
        keywords.add("finally");
        keywords.add("fixed");
        keywords.add("float");
        keywords.add("for");
        keywords.add("foreach");
        keywords.add("goto");
        keywords.add("if");
        keywords.add("implicit");
        keywords.add("in");
        keywords.add("int");
        keywords.add("interface");
        keywords.add("internal");
        keywords.add("is");
        keywords.add("lock");
        keywords.add("long");
        keywords.add("namespace");
        keywords.add("new");
        keywords.add("null");
        keywords.add("object");
        keywords.add("operator");
        keywords.add("out");
        keywords.add("override");
        keywords.add("params");
        keywords.add("private");
        keywords.add("protected");
        keywords.add("public");
        keywords.add("readonly");
        keywords.add("ref");
        keywords.add("return");
        keywords.add("sbyte");
        keywords.add("sealed");
        keywords.add("short");
        keywords.add("sizeof");
        keywords.add("stackalloc");
        keywords.add("static");
        keywords.add("string");
        keywords.add("struct");
        keywords.add("switch");
        keywords.add("this");
        keywords.add("throw");
        keywords.add("true");
        keywords.add("try");
        keywords.add("typeof");
        keywords.add("uint");
        keywords.add("ulong");
        keywords.add("unchecked");
        keywords.add("unsafe");
        keywords.add("ushort");
        keywords.add("using");
        keywords.add("virtual");
        keywords.add("void");
        keywords.add("volatile");
        keywords.add("while");
    }

    public int Step(Scanner s){
        return Utils.matchn(s,false,false,keywords.toArray(new String[keywords.size()]));
    }
}
