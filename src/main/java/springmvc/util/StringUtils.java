package springmvc.util;

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

    public static void main(String[] args) {
        String str = "hello 'shijie'";
        System.out.println(singleQuotesReplacement(str));
    }
}
