package com.pixelzerg.parser.pzcsharp;

import com.pixelzerg.parser.Scanner;
import com.pixelzerg.parser.ScannerSave;
import com.pixelzerg.parser.pzcsharp.tokens.Identifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pixelzerg on 25/01/17.
 *
 * Spec:
 * X = A B C
 * x(){
 *     if(!a())return false;
 *     if(!b())return false;
 *     if(!c())return false;
 *     return true
 * }
 *
 * P = Q | R;
 * p(){
 *     if(!q()){
 *         if(!r())return false;
 *     }
 *     return true
 * }
 *
 * L = A | L A
 * l(){
 *     if(!a())return false;
 *     while(a()){}
 *     return true;
 * }
 */
public class Utils {

	static {
        Initialise();
    }

    public enum CharacterType {
        Letter,
        DecimalDigit,
        Combining,
        Connecting,
        Formatting,
    }

    public static List<Integer> letterCharacter = null;
    public static List<Integer> decimalDigitCharacter = null;
    public static List<Integer> combiningCharacter = null;
    public static List<Integer> connectingharacter = null;
    public static List<Integer> formattingharacter = null;

    private static boolean _initialised = false;

    public static void Initialise() {
        letterCharacter = new ArrayList<Integer>();
        decimalDigitCharacter = new ArrayList<Integer>();
        combiningCharacter = new ArrayList<Integer>();
        connectingharacter = new ArrayList<Integer>();
        formattingharacter = new ArrayList<Integer>();

        letterCharacter.add(1);//lu
        letterCharacter.add(2);//ll
        letterCharacter.add(3);//lt
        letterCharacter.add(4);//lm
        letterCharacter.add(5);//lo
        letterCharacter.add(10);//nl

        combiningCharacter.add(6);//mn
        combiningCharacter.add(7);//mc

        decimalDigitCharacter.add(9);//nd

        connectingharacter.add(23);//pc

        formattingharacter.add(16);//cf
        _initialised = true;
    }

    public static boolean CheckCharacter(char c, CharacterType testtype) {
        if (!_initialised) Initialise();
        List<Integer> type = null;
        switch (testtype) {
            case Combining:
                type = combiningCharacter;
                break;
            case DecimalDigit:
                type = decimalDigitCharacter;
                break;
            case Connecting:
                type = connectingharacter;
                break;
            case Formatting:
                type = formattingharacter;
                break;
            case Letter:
                type = letterCharacter;
                break;
        }
        int ctype = Character.getType(c);
        for (int i : type) {
            if (ctype == i) return true;
        }
        return false;
    }

    public static boolean CheckCharacter(char c, int type){
        return Character.getType(c)==type;
    }
    
    public static boolean IsWhiteSpace(char c) {
        return (c == ' ' || c == (char) -1 || c == '\t' || c == '\n' || c == '\r');
    }

    public static String readUntilInvalidChar(Scanner s){
        ScannerSave save = s.save();
        int i = 0;
        String ret = "";
        char c = (char) -1;
        while (true) {
            c = s.look(i);
            if(c==(char)-1){
                break;
            }
            if(!Identifier.IsIdentifierPartCharacter(c)){
                break;
            }
            ret+=c;
            i++;
        }
        s.load(save);
        return ret;
    }

    public static boolean match(Scanner s, String matchh, boolean caseInsensitive, boolean allowSubstr){
        String read;
        String match;
        if(caseInsensitive)match = matchh.toLowerCase();
        else match = matchh;
        if(allowSubstr) read = s.read(match.length());
        else read = Utils.readUntilInvalidChar(s);
        if(caseInsensitive)read = read.toLowerCase();

        if(read.equals(match)){
            s.increment(match.length());
            return true;
        }
        return false;
    }

    public static boolean match(Scanner s, String match){
        return match(s,match,false,true);
    }

    public static boolean match(Scanner s, String match, boolean caseInsensitive){
        return match(s,match,caseInsensitive,true);
    }

    public static boolean match(Scanner s, boolean caseInsensitive, boolean allowSubstr, String... matches){
        for(String match : matches){
            if(match(s,match,caseInsensitive,allowSubstr))return true;
        }
        return false;
    }

    public static boolean match(Scanner s, boolean caseInsensitive, String... matches){
        return match(s,caseInsensitive,true,matches);
    }

    public static boolean match(Scanner s, String... matches){
        return match(s,false,true,matches);
    }

    public static int matchn(Scanner s, String matchh, boolean caseInsensitive, boolean allowSubstr){
        String read;
        String match;
        if(caseInsensitive)match = matchh.toLowerCase();
        else match = matchh;
        if(allowSubstr) read = s.read(match.length());
        else read = Utils.readUntilInvalidChar(s);
        if(caseInsensitive)read = read.toLowerCase();

        if(read.equals(match)){
            s.increment(match.length());
            return match.length();
        }
        return 0;
    }

    public static int matchn(Scanner s, String match){
        return matchn(s,match,false,true);
    }

    public static int matchn(Scanner s, String match, boolean caseInsensitive){
        return matchn(s,match,caseInsensitive,true);
    }

    public static int matchn(Scanner s, boolean caseInsensitive, boolean allowSubstr, String... matches){
        for(String match : matches){
            int i = matchn(s,match,caseInsensitive,allowSubstr);
            if(i!=0)return i;
        }
        return 0;
    }

    public static int matchn(Scanner s, boolean caseInsensitive, String... matches){
        return matchn(s,caseInsensitive,true,matches);
    }

    public static int matchn(Scanner s, String... matches){
        return matchn(s,false,true,matches);
    }
}
