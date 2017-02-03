package com.pixelzerg;

import com.pixelzerg.pzcsharp.Scanner;
import com.pixelzerg.pzcsharp.Token;
import com.pixelzerg.pzcsharp.Utils;
import com.pixelzerg.pzcsharp.matchers.KeywordMatcher;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter source code to analyse");
        String sc =
        /*
                new java.util.Scanner(System.in).next();
	    /*/
                "ab" +
                        "\nc" +
                        "\ndefg" +
                        "\nh" +
                        "\nij";
        //*/
        //System.out.println(com.pixelzerg.pzcsharp.Utils.CheckCharacter('O', com.pixelzerg.pzcsharp.Utils.CharacterType.Letter));
        //com.pixelzerg.pzcsharp.Core.Do(sc);
        try {
            Token t = new KeywordMatcher("moo", Utils.TokenType.Word).Select(new Scanner("moo banan laa"));
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
