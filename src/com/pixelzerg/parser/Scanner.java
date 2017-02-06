package com.pixelzerg.parser;

/**
 * Created by pixelzerg on 29/01/17.
 */
public class Scanner {
    public String filepath = "";
    public String source = null;
    private int curindex = 0;
    private Pos lpos = new Pos();
    private int lindex = 0;

    public Scanner(String source) {
        setSource(source);
    }

    public Scanner(String filepath, String source) {

        this.filepath = filepath;
        setSource(source);
    }

    public void setSource(String sc) {
        this.source = sc;
        this.source = this.source.replace("\r\n", "\n");
        this.source = this.source.replace("\r", "\n");
        this.source = this.source.replace("\u2028", "\n");
        this.source = this.source.replace("\u2029", "\n");
        //2.3.1
        if (source.endsWith("\u001A")) {
            source = source.substring(0, source.length() - 1 - 1);
        }
        if (!source.isEmpty()) {
            if (!CharUtils.IsNewline(source.charAt(source.length() - 1))) {
                source += '\r';
            }
        }
    }

    public char getCur() {
        return this.charAt(curindex);
    }

    public char charAt(int index) {
        if (curindex >= source.length()) return (char) -1;
        return source.charAt(index);
    }

    public char next() {
        char ret = getCur();
        curindex++;
        return ret;
    }

    public char look(int off) {
        if (curindex + off >= source.length()) return (char) -1;
        return source.charAt(curindex + off);
    }

    public int increment(int x) {
        curindex += x;
        return x;
    }

    public Pos getPos() {
        Pos ret = lpos.clone();
        int i;
        for (i = lindex; i <= curindex; i++) {
            if (this.charAt(i) == '\n') {
                ret.lineno++;
                ret.charno = 0;
            } else {
                ret.charno++;
            }
        }
        lindex = i;
        lpos = ret;
        return ret;
    }

    public Pos getPos(int lookahead) {
        Pos ret = lpos;
        int i;
        for (i = lindex; i < curindex + lookahead; i++) {
            if (this.charAt(i) == '\n') {
                ret.lineno++;
                ret.charno = 0;
            } else {
                ret.charno++;
            }
        }
        return ret;
    }

    public ScannerSave save() {
        ScannerSave s = new ScannerSave();
        s.curIndex = this.curindex;
        s.lindex=this.lindex;
        s.lpos=this.lpos;
        return s;
    }

    public ScannerSave saveq() {
        ScannerSave s = new ScannerSave();
        s.curIndex = this.curindex;
        return s;
    }

    public void load(ScannerSave save) {
        this.curindex = save.curIndex;
        this.lpos = save.lpos;
        this.lindex = save.lindex;
    }

    public int getOffset(ScannerSave save){
        return this.curindex-save.curIndex;
    }

    public String read(int length){
        int i = 0;
        String ret = "";
        char c = (char) -1;
        while (true) {
            if(i >= length){
                break;
            }
            c = this.look(i);
            if(c==(char)-1){
                return null;
            }
            ret+=c;
            i++;
        }
        return ret;
    }

    public String toString(){
        return this.curindex+", "+this.getCur();
    }

}
