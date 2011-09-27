package org.bandhu.util;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bandhu.core.rest.oauth.OAuthConstants;

public class BandhuUtil {
    public static String[] stringSplitter(String string, String regex) {
        String[] info = new String[] {};
        if (string != null && string.indexOf(regex) > -1) {
            info = string.split(regex);
        }
        return info;
    }

    public static boolean exists(Object obj) {
        return obj != null;
    }

    public static boolean hasText(String string) {
        return string != null && string.trim().length() > 0;
    }

    public static boolean hasValue(Object object) {
        if (object == null)
            return false;
        if (object instanceof Collection)
            return ((Collection<?>) object).size() > 0;
        return object != null;
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

    public static String encodeEndpoint(String endpoint) {
        if (endpoint.indexOf("?") == -1
                || endpoint.length() == endpoint.indexOf("?") + 1) {
            return endpoint;
        }

        String url = endpoint.substring(0, endpoint.indexOf("?") + 1);
        String query = endpoint.substring(endpoint.indexOf("?") + 1);

        String[] info = null;

        if (query.contains(OAuthConstants.PARAMETER_DELIMITER)) {
            info = BandhuUtil.stringSplitter(query,
                    OAuthConstants.PARAMETER_DELIMITER);
        } else {
            info = new String[] { query };
        }

        Map<String, String> param = new HashMap<String, String>();

        for (String string2 : info) {
            String[] keyVal = BandhuUtil.stringSplitter(string2,
                    OAuthConstants.KEY_VAL_DELIMITER);
            if (keyVal.length == 1)
                param.put(keyVal[0], "");
            if (keyVal.length == 2)
                param.put(keyVal[0], keyVal[1]);
        }

        for (String key : param.keySet()) {
            url += key + "=" + URLEncoder.encode(param.get(key)) + "&";
        }
        return url;
    }

    public enum Method {
        HEAD("HEAD"), OPTIONS("OPTIONS"), GET("GET"), PUT("PUT"), POST("POST"), DELETE(
                "DELETE");
        private String text;

        private Method(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public enum Protocol {
        HTTP("http"), HTTPS("https");
        private String text;

        private Protocol(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public static String encodeURL(String scope) {
        return encodeURL(scope, "UTF-8");
    }

    public static String encodeURL(String scope, String enc) {
        try {
            return URLEncoder.encode(scope, enc);
        } catch (Exception e) {
            try {
                return URLEncoder.encode(scope);
            } catch (Exception ex) {
                return scope;
            }
        }
    }
}
