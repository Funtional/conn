package springmvc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String singleQuotesReplacement(String s) {
        if ((s.indexOf('\'') == -1))
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\'') {
                sb.append('\'').append('\'');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String addSingleQuotes(Object obj){
        if (null == obj || "null".equals(obj.toString().toLowerCase())){
            return "null";
        }
        return "'"+ obj.toString() +"'";
    }

    public static String getTableName(String s){
        s = s.toUpperCase();
        String regex="\\bFROM\\s*\\S*";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(s);
        if(m.find()){
            return m.group().replace("FROM","").trim();
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        String str = "hello 'shijie'";
        System.out.println(singleQuotesReplacement(str));

        StringBuilder sb = new StringBuilder();
        sb.append("delelkt  , dsafdfdsa,  .,  dcba,;");
        System.out.println(sb.delete(sb.length() -2,  sb.length()));
    }
}
