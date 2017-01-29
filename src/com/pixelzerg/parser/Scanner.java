package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class Scanner {
    public String filepath = "";
    public String source = null;
    public int curindex = 0;
    private Pos lpos = new Pos();
    private int lindex = 0;

    public char getCur(){
        return source.charAt(curindex);
    }

    public char look(int off){
       return source.charAt(curindex+off);
    }

    public void increment(int x){
        curindex+=x;
    }

    public Pos getPos() {
        Pos ret = lpos;
        int i;
        for (i = lindex; i < curindex; i++) {
            if(source.charAt(i)=='\n'){
                ret.lineno++;
                ret.charno=0;
            }else{
                ret.charno++;
            }
        }
        lindex=i+1;
        lpos=ret;
        return ret;
    }

    public Pos getPos(int lookahead) {
        Pos ret = lpos;
        int i;
        for (i = lindex; i < curindex+lookahead; i++) {
            if(source.charAt(i)=='\n'){
                ret.lineno++;
                ret.charno=0;
            }else{
                ret.charno++;
            }
        }
        return ret;
    }
}
