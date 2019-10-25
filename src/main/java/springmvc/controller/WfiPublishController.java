package springmvc.controller;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
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
import springmvc.util.SqlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static springmvc.config.SqlConfig.SQL_LINEFEED;
import static springmvc.util.FileUtils.PUBLISH_FILE_PATH;

@Controller
public class WfiPublishController {

    @Autowired
    private WfiWorkflow2bizService wfiWorkflow2bizService;

    @Autowired
    private WfiNode2bizService wfiNode2bizService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value="/wfi_publish")
    @ResponseBody
    public String getWfiPublish(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String appl_type) throws Exception {
        StringBuffer publishSqlSb = new StringBuffer();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        Configuration configuration = sqlSessionFactory.getConfiguration();
        BoundSql boundSql = null;
        String sql = null;

        /** 开始 Wfi_Workflow2biz**/
        WfiWorkflow2biz wfiWorkflow2biz = wfiWorkflow2bizService.getWfiWorkflow2bizDetail(appl_type);
        boundSql = configuration.getMappedStatement("springmvc.dao.WfiWorkflow2bizDao.deleteWfiWorkflow2biz").getBoundSql(wfiWorkflow2biz);
        sql = SqlUtils.getSql(configuration, boundSql);
        publishSqlSb.append("\n").append(sql).append(SQL_LINEFEED);
        boundSql = configuration.getMappedStatement("springmvc.dao.WfiWorkflow2bizDao.addWfiWorkflow2biz").getBoundSql(wfiWorkflow2biz);
        sql = SqlUtils.getSql(configuration, boundSql);
        publishSqlSb.append(sql).append(SQL_LINEFEED);

        /** 开始 Wfi_Node2biz**/
        paramMap.clear();
        paramMap.put("pk1", wfiWorkflow2biz.getPk1());
        List<WfiNode2biz> wfiNode2bizList = wfiNode2bizService.getWfiNode2bizList(paramMap);
        if (wfiNode2bizList.size() > 0){
            boundSql = configuration.getMappedStatement("springmvc.dao.WfiNode2bizDao.deleteWfiNode2biz").getBoundSql(wfiNode2bizList.get(0));
            sql = SqlUtils.getSql(configuration, boundSql);
            publishSqlSb.append(sql).append(SQL_LINEFEED);
            for (WfiNode2biz wfiNode2biz: wfiNode2bizList
                    ) {
                boundSql = configuration.getMappedStatement("springmvc.dao.WfiNode2bizDao.addWfiNode2biz").getBoundSql(wfiNode2biz);
                sql = SqlUtils.getSql(configuration, boundSql);
                publishSqlSb.append(sql).append(SQL_LINEFEED);
            }
        }

        /**写入文件**/
        FileUtils.writeLocalStr(publishSqlSb.toString(), PUBLISH_FILE_PATH + File.separator + appl_type + ".txt");
        return PUBLISH_FILE_PATH + File.separator + appl_type + ".txt";
    }

}
