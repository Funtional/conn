package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.dao.WfiWorkflow2bizDao;
import springmvc.model.WfiWorkflow2biz;
import springmvc.service.WfiWorkflow2bizService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WfiWorkflow2bizController {

    @Autowired
    WfiWorkflow2bizService wfiWorkflow2bizService;

    @RequestMapping(value="/WfiWorkflow2biz")
    @ResponseBody
    public WfiWorkflow2biz getWfiWorkflow2biz(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String appl_type) throws Exception {
        WfiWorkflow2biz wfiWorkflow2biz = wfiWorkflow2bizService.getWfiWorkflow2bizDetail(appl_type);
        return wfiWorkflow2biz;
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
