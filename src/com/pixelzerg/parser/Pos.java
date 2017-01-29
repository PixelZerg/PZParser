package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class Pos {
    public int lineno = 0;
    public int charno = 0;

    public Pos(int lineno, int charno){
        this.lineno = lineno;
        this.charno = charno;
    }

    public Pos(){}
}
