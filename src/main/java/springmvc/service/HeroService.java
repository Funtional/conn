package springmvc.service;

import springmvc.model.Hero;

import java.util.List;
import java.util.Map;

public interface HeroService {
    List<Hero> getHeroList(Map paraMap);

    Hero getHeroDetail(int id);

    boolean updateHero(int id, Hero hero);

    boolean addHero(Hero hero);

    boolean deleteHero(int id);
}
