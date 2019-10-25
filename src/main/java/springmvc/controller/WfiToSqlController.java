package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.service.impl.ToSqlServiceImpl;
import springmvc.util.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

import static springmvc.config.SqlConfig.DEFAULT_PATH;
import static springmvc.util.FileUtils.PUBLISH_FILE_PATH;

@Controller
public class WfiToSqlController {


    @Autowired
    private ToSqlServiceImpl toSqlServiceImpl;

    @RequestMapping(value="/to_sql")
    @ResponseBody
    public String getWfiPublish(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) String sql_name,
                                @RequestParam(required = false) String file_name, @RequestParam Map<String,String> paramMap) throws Exception {
        /**获取需要发布的sql**/
        StringBuffer publishSqlSb = toSqlServiceImpl.getPublishSql(sql_name, paramMap);
        /**把sql写入文件**/
        String filePath = this.getFilePath(file_name);
        FileUtils.writeLocalStr(publishSqlSb.toString(), filePath);
        return filePath;
    }

    /**
     * 获取存放发布sql的文件名
     * @param file_name 自定义的文件名
     * @return
     */
    private String getFilePath(String file_name){
        if (file_name == null || file_name.trim().length()==0){
            file_name = DEFAULT_PATH;
        }
        return PUBLISH_FILE_PATH + File.separator + file_name + ".txt";
    }

}
