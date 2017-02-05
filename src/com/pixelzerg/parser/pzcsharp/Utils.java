package com.pixelzerg.parser.pzcsharp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pixelzerg on 25/01/17.
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

}
