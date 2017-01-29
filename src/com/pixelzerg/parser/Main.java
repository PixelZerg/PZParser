package com.pixelzerg.parser;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner("moo\nyoo");
        char c = (char) -1;
        while (true) {
            c = s.getCur();
            System.out.println(Expand(c)+"\t"+s.getPos());
            if(c==(char)-1){
                break;
            }
            s.increment(1);
        }
    }

    public static String Expand(char c) {
        if (c == (char) -1) {
            return "-1";
        } else if (c == '\n') {
            return "NEWLINE";
        }
        return "" + c;
    }
}
