package springmvc.dao;

import springmvc.model.Hero;

import java.util.List;
import java.util.Map;

public interface HeroDao {
    List<Hero> getHeroList(Map paramMap);

    Hero getHero(int id);

    /**
     * 增删改接口默认返回int型参数，表示影响的行数。
     */
    int updateHero(Hero hero);

    int addHero(Hero hero);

    int deleteHero(int id);
}
