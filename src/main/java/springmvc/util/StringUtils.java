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

    /**
     * 传入值不为null，转化为string并在前后加单引号； 值为null，返回的字符串为“null”
     * @param obj 一般为String类型
     * @return
     */
    public static String addSingleQuotes(Object obj){
        if (null == obj || "null".equals(obj.toString().toLowerCase())){
            return "null";
        }
        return "'"+ obj.toString() +"'";
    }

    /**
     * 获取表名
     * @param s sql语句
     * @return
     */
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

    /**
     * 获取传入字符串的子串，规则为from（忽略大小写）开始到结束的子字符串
     * @param s 一般为简单的（只有一个from关键字的）select语句
     * @return
     */
    public static String getPostDeleteSql(String s){
        String regex="\\s*from[\\s\\S]*";
        Pattern p=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m=p.matcher(s);
        if(m.find()){
            return m.group().trim();
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

        str = "select  * froM table_a where a \r\r\naaaa aa";
        System.out.println("|" + getPostDeleteSql(str) + "|");
    }
}
