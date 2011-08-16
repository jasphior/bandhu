package org.bandhu.core.rest.oauth;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bandhu.util.BandhuException;

import com.sun.jersey.api.client.ClientResponse;

public class OAuthUtil {
    public static boolean hasErrorResponse(ClientResponse response) {
        int statusCode = response.getStatus();
        switch (statusCode / 100) {

        case 1:
            // Family.INFORMATIONAL;
            return false;
        case 2:
            // Family.SUCCESSFUL;
            return false;
        case 3:
            // Family.REDIRECTION;
            return false;
        case 4:
            // Family.CLIENT_ERROR;
            return true;
        case 5:
            // Family.SERVER_ERROR;
            return true;
        default:
            // Family.OTHER;
            return false;
        }
    }

    public static String getError(ClientResponse response) {
        return response.getEntity(String.class);
    }

    public static String[] stringSplitter(String string, String regex) {
        String[] info = new String[] {};
        if (string != null && string.indexOf(regex) > -1) {
            info = string.split(regex);
        }
        return info;
    }

    public static boolean hasText(String string) {
        return string != null && string.trim().length() > 0;
    }

    public static <T> T createInstance(Class<? extends T> clazz)
            throws BandhuException {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new BandhuException("Unable to instantiate the class... "
                    + clazz
                    + ", does this class have a public default constructor?");
        } catch (IllegalAccessException e) {
            throw new BandhuException("Unable to instantiate the class... "
                    + clazz + ", does this class public a default constructor?");
        }
    }

    public static Map<String, String> convertToKeyValue(String... strings) {
        Map<String, String> replacements = new HashMap<String, String>();

        if (strings == null) {
            return replacements;
        }

        for (int count = 0; count < strings.length; count++) {
            replacements.put(String.valueOf(count), strings[count]);
        }

        return replacements;
    }

    public static String replaceTokens(String text,
            Map<String, String> replacements) {
        Pattern pattern = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher = pattern.matcher(text);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            String replacement = replacements.get(matcher.group(1));
            builder.append(text.substring(i, matcher.start()));
            if (replacement == null)
                builder.append(matcher.group(0));
            else
                builder.append(replacement);
            i = matcher.end();
        }
        builder.append(text.substring(i, text.length()));
        return builder.toString();

    }

}
