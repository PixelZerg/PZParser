package com.pixelzerg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pixelzerg on 18/01/17.
 */
public class Utils {
    public static List<String> SplitLines(String result) throws IOException {
        BufferedReader rdr = new BufferedReader(new StringReader(result));
        List<String> lines = new ArrayList<String>();
        for (String line = rdr.readLine(); line != null; line = rdr.readLine()) {
            lines.add(line);
        }
        rdr.close();
        return lines;
    }

}
