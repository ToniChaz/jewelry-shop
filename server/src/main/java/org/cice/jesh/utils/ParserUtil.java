package org.cice.jesh.utils;

/**
 * Created by toni on 14/06/16.
 */
public class ParserUtil {

    public ParserUtil() {
    }

    public static Integer stringToInteger(String str) throws Exception {
        Integer result = null;

        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new Exception(e.toString());
        }

        return result;
    }
}
