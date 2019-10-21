package springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.HeroDao;
import springmvc.model.Hero;
import springmvc.service.HeroService;

import java.util.List;
import java.util.Map;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    public HeroDao heroDao;

    @Override
    public List<Hero> getHeroList(Map paraMap) {
        return heroDao.getHeroList(paraMap);
    }

    @Override
    public Hero getHeroDetail(int id) {
        return heroDao.getHero(id);
    }

    @Override
    public boolean updateHero(int id, Hero hero) {
        heroDao.updateHero(hero);
        return true;
    }

    @Override
    public boolean addHero(Hero hero) {
        heroDao.addHero(hero);
        return true;
    }

    @Override
    public boolean deleteHero(int id) {
        heroDao.deleteHero(id);
        return true;
    }
}
