package helper.api.vk.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladislav on 15.08.14.
 */
public class BaseUtil {
    /**
     * @param queryString string to explode
     * @return map of param-value
     */
    public static Map<String, String> explodeQueryString(String queryString){
        String[] paramValue = queryString.split("&");
        HashMap<String, String> params = new HashMap<String, String>(paramValue.length);

        for (String paramValueStr : paramValue) {
            String[] paramArr = paramValueStr.split("=");
            params.put(paramArr[0], paramArr[1]);
        }
        return params;
    }

    /**
     * @param path path to file
     * @return contents of file
     * @throws java.io.IOException
     */
    public static String fileToString(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder builder = new StringBuilder();
        String line;

        while ( (line = reader.readLine()) != null ) {
            builder.append(line);
        }
        reader.close();

        return builder.toString();
    }

    /**
     * @param path path to file
     * @param strData string to save
     */
    public static void stringToFile(String path, String strData) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(strData);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }

    /**
     * Will take a url such as http://www.stackoverflow.com and return www.stackoverflow.com
     * Author: aioobe http://stackoverflow.com/a/4826122/1271424
     *
     * @param url url to host
     * @return host name
     */
    public static String getHost(String url){
        if(url == null || url.length() == 0)
            return "";
        int doubleslash = url.indexOf("//");
        if(doubleslash == -1)
            doubleslash = 0;
        else
            doubleslash += 2;
        int end = url.indexOf('/', doubleslash);
        end = end >= 0 ? end : url.length();
        int port = url.indexOf(':', doubleslash);
        end = (port > 0 && port < end) ? port : end;
        return url.substring(doubleslash, end);
    }

    /**
     * Based on : http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/2.3.3_r1/android/webkit/CookieManager.java#CookieManager.getBaseDomain%28java.lang.String%29
     * Get the base domain for a given host or url. E.g. mail.google.com will return google.com
     * Author: aioobe http://stackoverflow.com/a/4826122/1271424
     * @param url
     * @return
     */
    public static String getBaseDomain(String url) {
        String host = getHost(url);

        int startIndex = 0;
        int nextIndex = host.indexOf('.');
        int lastIndex = host.lastIndexOf('.');
        while (nextIndex < lastIndex) {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf('.', startIndex);
        }
        if (startIndex > 0) {
            return host.substring(startIndex);
        } else {
            return host;
        }
    }

    public static String extractPattern(String str, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if (!m.find()){
            return null;
        }
        return m.toMatchResult().group(1);
    }

}
