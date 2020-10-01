package com..rd.java.basic.practice4;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author beskorovajny
 */
public class Part5 {
    public static final Logger LOGGER = Logger.getLogger(Part5.class.getName());

    private static final String BASE_NAME = "resources";
    private static final Pattern PATTERN = Pattern.compile("(\\w+)\\s(\\w+)",
                Pattern.MULTILINE
                    | Pattern.UNICODE_CHARACTER_CLASS
                    | Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        try {
            doResult();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,Demo.ERRORMESSAGE, e);
        }
    }

    public static void doResult() {
        Scanner scanner = new Scanner(System.in, Charset.defaultCharset().name());
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            if ("stop".equalsIgnoreCase(tmp)) {
                break;
            }
            Matcher matcher = PATTERN.matcher(tmp);
            if (matcher.find()) {
                String name = matcher.group(1);
                String lang = matcher.group(2);
                ResourceBundle resource = ResourceBundle.getBundle(BASE_NAME, new Locale(lang));
                Demo.print(resource.getString(name));
            }
        }
    }

}
