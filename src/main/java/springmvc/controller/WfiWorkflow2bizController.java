package springmvc.controller;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.dao.WfiWorkflow2bizDao;
import springmvc.model.WfiWorkflow2biz;
import springmvc.service.WfiWorkflow2bizService;
import springmvc.util.SqlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WfiWorkflow2bizController {

    @Autowired
    WfiWorkflow2bizService wfiWorkflow2bizService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value="/WfiWorkflow2biz")
    @ResponseBody
    public String getWfiWorkflow2biz(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String appl_type) throws Exception {
        WfiWorkflow2biz wfiWorkflow2biz = wfiWorkflow2bizService.getWfiWorkflow2bizDetail(appl_type);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        BoundSql boundSql = sqlSessionFactory.getConfiguration()
                .getMappedStatement("springmvc.dao.WfiWorkflow2bizDao.addWfiWorkflow2biz").getBoundSql(wfiWorkflow2biz);
        String sql = SqlUtils.getSql(configuration, boundSql, "addWfiWorkflow2biz");
        System.out.println(sql);
        return sql;
    }

    @RequestMapping(value="/WfiWorkflow2bizes")
    @ResponseBody
    public List<WfiWorkflow2biz> getWfiWorkflow2bizes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<WfiWorkflow2biz> list = new ArrayList<>();
        WfiWorkflow2biz WfiWorkflow2biz = new WfiWorkflow2biz();
        WfiWorkflow2biz WfiWorkflow2biz2 = new WfiWorkflow2biz();
        list.add(WfiWorkflow2biz);
        list.add(WfiWorkflow2biz2);
        return list;
    }
}
