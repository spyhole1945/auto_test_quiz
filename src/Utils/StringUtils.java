package Utils;

//import snapChat.ChatLogToMysql;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String planetDic(String str) {

         if (str.equals("sun")) {

            return "太阳";
        }
        else if (str.equals("moon")) {

            return "月亮";
        }
        else if (str.equals("mercury")) {

            return "水星";
        }
        else if (str.equals("venus")) {

            return "金星";
        }
        else if (str.equals("mars")) {

            return "火星";
        }
        else if (str.equals("jupiter")) {

            return "木星";
        }
        else if (str.equals("saturn")) {

            return "土星";
        }
        else if (str.equals("uranus")) {

            return "天王星";
        }
         else if (str.equals("neptune")) {

             return "海王星";
         }
         else if (str.equals("pluto")) {

             return "冥王星";
         }

        return str;
    }
    public static String aspectDic(String str) {


        if (str.equals("PlantAspect0")) {

            return "合";
        }
        else if (str.equals("PlantAspect60")) {

            return "六合";
        }
        else if (str.equals("PlantAspect0")) {

            return "";
        }
        else if (str.equals("PlantAspect90")) {

            return "拱";
        }
        else if (str.equals("PlantAspect120")) {

            return "刑";
        }else if (str.equals("PlantAspect180")) {

            return "冲";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }
        else if (str.equals("")) {

            return "";
        }

        return str;
    }

    public static char[] toCharArray(String str)
    {
        char[] dest = str.toCharArray();
        return dest;
    }

    public static String getStarNum(String str) {


        int dest = Integer.parseInt(str.replaceAll("[^0-9]",""))/16;

        return String.valueOf(dest);
    }
    public static String getnum(String str) {
        String dest = "";
        if (str != null) {
            dest = str.replaceAll("[^0-9|]","");
        }
        return dest;
    }
    public static String getDateStr(String str) {
        String dest = "";
        if (str != null) {
            dest = str.replaceAll("[^0-9|-]","");
        }
        return dest;
    }
    public static int  getInt(String str) {
        String dest = "";
        if (str != null) {
            dest = str.replaceAll("[^0-9]","");
        }
        return Integer.parseInt(dest);
    }
    public static String getWan(String str) {
        long dest = 0;

        if (str.contains("K")) {
            dest = Long.parseLong(str.replaceAll("[^0-9|]",""));
            if(str.contains("."))
            {
                return String.valueOf(dest*100);
            }
            return String.valueOf(dest*1000);
        }
        else if (str.contains("M")) {
            dest = Long.parseLong(str.replaceAll("[^0-9|]",""));
            if(str.contains("."))
            {
                return String.valueOf(dest*100000);
            }
            return String.valueOf(dest*1000000);
        }

       /* try {
            dest=Long.parseLong(str.replaceAll("[^0-9|]",""));
        }catch (NumberFormatException e)
        {
            e.printStackTrace();
        }*/
        return str;
    }
    public static String getChatUserName(String str) {

        String[] splitResult=str.split("\n");
        /*System.out.println(splitResult[splitResult.length-1]);*/
       // System.out.println(splitResult[0]);
        //System.out.println(splitResult[3]);
        if(splitResult[0].equals("\uD83D\uDC9B"))
        {
            System.out.println("包含爱心");
            return splitResult[1];
        }
        return splitResult[0];
    }
    public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex ="((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }
    public static String extractUrl(String text)
    {
        String urlreturn=null;
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex ="((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

       // List<String> extractedUrls=extractUrls(text);
        for (String url : containedUrls)
        {
            //System.out.println(url);
            urlreturn=url;
        }

        return urlreturn;
    }
    public static String removeLastChars(String str, int numChars) {
        if (str == null) {
            return null;
        }
        if (str.length() <= numChars) {
            return ""; // 或者可以抛出异常
        }
        return str.substring(0, str.length() - numChars);
    }


    public static void main(String[] args) {
      /*  String str="sdkweiosl";
        char[] array=StringUtils.toCharArray(str);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }*/
        String clip="健康指数：69%" ;

        /*List<String> extractedUrls=extractUrls(clip);
        for (String url : extractedUrls)
        {
            System.out.println(url);
        }*/
        System.out.println(clip.split("：")[1]);
    }
}
