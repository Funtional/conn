package springmvc.controller;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.model.WfiNode2biz;
import springmvc.model.WfiWorkflow2biz;
import springmvc.service.WfiNode2bizService;
import springmvc.service.WfiWorkflow2bizService;
import springmvc.util.FileUtils;
import springmvc.util.MyBatisUtil;
import springmvc.util.SqlUtils;
import springmvc.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static springmvc.util.FileUtils.PUBLISH_FILE_PATH;

@Controller
public class WfiToSqlController {
    public static final String PRE_MAPPER_NAMESPACE = "springmvc.dao.ToSqlDao";
    public static final String MAPPER_NAMESPACE_SEPARATOR = ".";

    @Autowired
    private WfiWorkflow2bizService wfiWorkflow2bizService;

    @Autowired
    private WfiNode2bizService wfiNode2bizService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value="/to_sql")
    @ResponseBody
    public String getWfiPublish(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) String sql_name,@RequestParam(required = false) String file_name, @RequestParam Map<String,String> paramMap) throws Exception {
        StringBuffer publishSqlSb = new StringBuffer();

        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.setCallSettersOnNulls(true); //https://www.cnblogs.com/zhengOK/p/10439232.html
        SqlSession session = MyBatisUtil.getSession(sqlSessionFactory);
        String mapperNameSpace = PRE_MAPPER_NAMESPACE + MAPPER_NAMESPACE_SEPARATOR + sql_name;
        List<Map<String, String>> resultList = session.selectList(mapperNameSpace, paramMap);////https://www.cnblogs.com/gongxr/p/10313639.html

        String boundSql = configuration.getMappedStatement(mapperNameSpace).getBoundSql(new HashMap<>()).getSql().toUpperCase();
        String tableName = StringUtils.getTableName(boundSql);


        for (Map<String, String> map: resultList){
            StringBuffer preSqlSb = new StringBuffer();
            StringBuffer postSqlSb = new StringBuffer();
            preSqlSb.append("INSERT INTO ").append(tableName).append(" (");
            postSqlSb.append(") VALUES(");
            for (Map.Entry entry: map.entrySet()){
                preSqlSb.append(entry.getKey()).append(", ");
                postSqlSb.append(StringUtils.addSingleQuotes(entry.getValue())).append(", ");
            }
            preSqlSb.delete(preSqlSb.length()-2, preSqlSb.length());
            postSqlSb.delete(postSqlSb.length()-2, postSqlSb.length()).append(")");
            publishSqlSb.append(preSqlSb).append(postSqlSb).append(";\r\n");
        }

        if (file_name == null || file_name.trim().length()==0){
            file_name = "tosqltest";
        }

        /**写入文件**/
        FileUtils.writeLocalStr(publishSqlSb.toString(), PUBLISH_FILE_PATH + File.separator + file_name + ".txt");

        System.out.println("=================华丽的分隔符============");
       return resultList.toString();
    }

}
