package Laba1;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class task2 {
    public static void isRegex(String regex, String string)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches())
            System.out.println("Выражение является регулярным");
        else
            System.out.println("Выражение не является регулярным");
    }

    public static void main(String args[]) throws IOException {
        String regexData     = "(0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[0-2])-(19|20|21)[0-9]{2}";
        String regexDataTime = "(0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[0-2])-(19|20|21)[0-9]{2}T(0[0-9]|1[0-9]|2[0-4])(:([0-5][0-9])){2}";
        String regexMail     = "([\\S]{1,20})@([a-zA-Z]{1,20}).(com|ru|org)";

        String string1       = "20-12-2133";
        String string2       = "dsf 01-12-2012 sdfpfdzsxgvjlgdfzftreweq2356786redxcvb 20-12-2133T18:50:50";
        String string3       = "ddcdfkjg___fdf.hjklj@drom.com";

        isRegex(regexData, string1);
        isRegex(regexDataTime, string2);
        isRegex(regexMail, string3);
    }


}
