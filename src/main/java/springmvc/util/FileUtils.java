package springmvc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtils {
    public static final String PUBLISH_FILE_PATH = "C:"+File.separator + "my_conn";

    /**
     * https://blog.csdn.net/qq_37411065/article/details/80996479
     * @param str
     * @param path
     */
    public static void writeLocalStr(String str,String path){
        try {
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if(str != null && !"".equals(str)){
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(str);
                osw.flush();
                osw.close();
                System.out.println("执行完毕!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String appl_type = "LMT_0018";
        writeLocalStr("hello 师姐", PUBLISH_FILE_PATH + File.separator + appl_type + ".txt");
    }

}
