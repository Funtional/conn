package springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.WfiNode2bizDao;
import springmvc.model.WfiNode2biz;
import springmvc.service.WfiNode2bizService;

import java.util.List;
import java.util.Map;

@Service
public class WfiNode2bizServiceImpl implements WfiNode2bizService {

    @Autowired
    public WfiNode2bizDao WfiNode2bizDao;

    @Override
    public List<WfiNode2biz> getWfiNode2bizList(Map paraMap) {
        return WfiNode2bizDao.getWfiNode2bizList(paraMap);
    }

    @Override
    public WfiNode2biz getWfiNode2bizDetail(String id) {
        return WfiNode2bizDao.getWfiNode2biz(id);
    }

    @Override
    public boolean updateWfiNode2biz(int id, WfiNode2biz WfiNode2biz) {
        WfiNode2bizDao.updateWfiNode2biz(WfiNode2biz);
        return true;
    }

    @Override
    public boolean addWfiNode2biz(WfiNode2biz WfiNode2biz) {
        WfiNode2bizDao.addWfiNode2biz(WfiNode2biz);
        return true;
    }

    @Override
    public boolean deleteWfiNode2biz(int id) {
        WfiNode2bizDao.deleteWfiNode2biz(id);
        return true;
    }
}
