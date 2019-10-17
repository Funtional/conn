package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.model.Hero;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HeroController {

    @RequestMapping(value="/hero.action")
    @ResponseBody
    public Hero getHero(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("test");
        return hero;
    }

    @RequestMapping(value="/heroes.action")
    @ResponseBody
    public List<Hero> getHeroes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Hero> list = new ArrayList<>();
        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("test1");
        Hero hero2 = new Hero();
        hero2.setId(2);
        hero2.setName("test2");
        list.add(hero);
        list.add(hero2);
        return list;
    }
}
