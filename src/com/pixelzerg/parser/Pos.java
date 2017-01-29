package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class Pos implements Cloneable{
    public int lineno = 0;
    public int charno = 0;

    public Pos(int lineno, int charno){
        this.lineno = lineno;
        this.charno = charno;
    }

    public Pos(){}

    public String toString(){
        return "{\"lineno\": "+lineno+", \"charno\": "+charno+"}";
    }

    public Pos clone(){
        return new Pos(lineno, charno);
    }
}
