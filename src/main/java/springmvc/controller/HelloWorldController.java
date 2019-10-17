package springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 添加模型数据
        mv.addObject("message", "Hello World!");
        // 设置逻辑视图名,最终视图地址=前缀+逻辑视图名+后缀
        mv.setViewName("hello");
        System.out.print("haha");
        return mv;
    }
}