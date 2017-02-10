package com.pixelzerg.parser.pzcsharp.errorhandling;

import com.pixelzerg.parser.Pos;

/**
 * Created by pixelzerg on 28/01/17.
 */

//TODO replace filepath with scanner object
//Error(line 5, char 6): PZ_W023 - UnexpectedEOL: blah blah -- Exception: blah
public class CompilerException extends PZCSharpException {
    public enum ErrorType {
        None,
        InternalError,
        UnexpectedEOL,
        UnexpectedEOF,
        UnexpectedCharacter,
        UnrecognisedToken,
    }

    public boolean Warning = false;
    public int ln = -1;
    public int cn = -1;
    public ErrorType type = ErrorType.None;
    public String extraInfo = null;
    public Throwable cause = null;

    public CompilerException(boolean warning, String filepath, int ln, int cn, ErrorType et, String extraInfo, Throwable cause) {
        super(filepath + "(line " + ln + ", char " + cn + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name() + ": " + extraInfo + " -- Exception: " + cause);
        this.Warning = warning;
        this.ln = ln;
        this.cn = cn;
        this.type = et;
        this.extraInfo = extraInfo;
        this.cause = cause;
    }

    public CompilerException(boolean warning, String filepath, int ln, int cn, ErrorType et, String extraInfo) {
        super(filepath + "(line " + ln + ", char " + cn + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name() + ": " + extraInfo);
        this.Warning = warning;
        this.ln = ln;
        this.cn = cn;
        this.type = et;
        this.extraInfo = extraInfo;
    }

    public CompilerException(boolean warning, String filepath, int ln, int cn, ErrorType et) {
        super(filepath + "(line " + ln + ", char " + cn + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name());
        this.Warning = warning;
        this.ln = ln;
        this.cn = cn;
        this.type = et;
    }

    public CompilerException(boolean warning, String filepath, Pos p, ErrorType et, String extraInfo, Throwable cause) {
        super(filepath + "(line " + p.lineno + ", char " + p.charno + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name() + ": " + extraInfo + " -- Exception: " + cause);
        this.Warning = warning;
        this.ln = p.lineno;
        this.cn = p.charno;
        this.type = et;
        this.extraInfo = extraInfo;
        this.cause = cause;
    }

    public CompilerException(boolean warning, String filepath, Pos p, ErrorType et, String extraInfo) {
        super(filepath + "(line " + p.lineno + ", char " + p.charno + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name() + ": " + extraInfo);
        this.Warning = warning;
        this.ln = p.lineno;
        this.cn = p.charno;
        this.type = et;
        this.extraInfo = extraInfo;
    }

    public CompilerException(boolean warning, String filepath, Pos p, ErrorType et) {
        super(filepath + "(line " + p.lineno + ", char " + p.charno + "): PZ_" + ((warning) ? "W" : "E") + String.format("%04d", et.ordinal()) + " - " + et.name());
        this.Warning = warning;
        this.ln = p.lineno;
        this.cn = p.charno;
        this.type = et;
    }

    //TODO add bool string pos throwable constructor + more
}