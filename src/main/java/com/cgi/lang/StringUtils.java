package com.cgi.lang;

import java.util.regex.Pattern;

/**
 * String utility class for some reversing string by
 */
public class StringUtils {
    /**
     * Reverses string using space as delimiter: "a b c d" becomes "d c b a".
     * If string is null, then the result is null, if "" then the result is "".
     * Delimiter can be null, then the result is equal to original string.
     * @param str string to be reversed
     * @return reversed string
     */
    public static String reverseString(String str){
        return reverseString(str, " ");
    }

    /**
     * Reverses string using delimiter: example "a b c d" becomes "d c b a" when using the delimiter " ".
     * Multiple sequential delimiters will be remembered: "_a_b__c_" will return "_c_b__a_" when using delimiter "_"
     * If string is null, then the result is null, if "" then the result is "".
     * Delimiter can be null, then the result is equal to original string.
     * @param str string to be reversed
     * @param delimiter delimiter
     * @return reversed string
     */
    public static String reverseString(String str, String delimiter){

        //test same bad uses
        if(str == null) {
            return  null;
        }
        if(delimiter == null) {
            return new String(str);
        }
        if (str.length() == 0){
            return "";
        }
        if (str.equals(delimiter)){
            return new String(str);
        }

        String[] splitString = split(str, delimiter);

        reverseElementsInArrayExceptTokens(splitString);

        //this will return a new copy of string
        return join(splitString, delimiter);
    }

    /**
     * Splits the string to Array
     * @param str string to be split
     * @param delimiter delimiter
     * @return Array of strings including "" in the place of delimiter
     */
    private static String[] split(String str, String delimiter) {

        //we need to escape regular expression (for using string.split)
        String escapedDelimiter = Pattern.quote(delimiter);

        //split the text to array
        //must have second parameter or else split looses delimiters at end
        return str.split(escapedDelimiter, str.length());
    }


    /**
     * Join Array of strings to string
     * @param splitString Array of string including "" as delimiter placeholder
     * @param delimiter delimiter
     * @return new string
     */
    private static String join(String[] splitString, String delimiter) {

        StringBuilder result = new StringBuilder();

        //we allways inserted the delimiter, we need to remove the first one
        for (String chunk : splitString) {
            if (chunk.equals("")) {
                result.append(delimiter);
            } else {
                result.append(chunk).append(delimiter);
            }
        }

        //we need to remove the last delimiter
        return result.substring(0, result.length()-delimiter.length());
    }

    /**
     * modifies the location of strings in original array (first is switched with last etc)
     * Empty strings are considered to be tokinizers and thus not not switched
     * @param splitString tokenized array
     */
    private static void reverseElementsInArrayExceptTokens(String[] splitString) {
        int lowerIndex = 0, upperIndex = splitString.length-1;
        //
        while (true) {

            while (splitString[lowerIndex].equals("")) {
                lowerIndex++;
            }
            while (splitString[upperIndex].equals("")) {
                upperIndex--;
            }

            //the upper index is less then lower - then we are done
            if (upperIndex <= lowerIndex) {
                return;
            }

            //found two real strings to switch
            String tmp = splitString[lowerIndex];
            splitString[lowerIndex] = splitString[upperIndex];
            splitString[upperIndex] = tmp;

            lowerIndex++;
            upperIndex--;
        }
    }
}
