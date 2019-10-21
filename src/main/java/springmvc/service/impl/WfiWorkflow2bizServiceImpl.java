package springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.WfiWorkflow2bizDao;
import springmvc.model.WfiWorkflow2biz;
import springmvc.service.WfiWorkflow2bizService;

import java.util.List;
import java.util.Map;

@Service
public class WfiWorkflow2bizServiceImpl implements WfiWorkflow2bizService {

    @Autowired
    public WfiWorkflow2bizDao wfiWorkflow2bizDao;

    @Override
    public List<WfiWorkflow2biz> getWfiWorkflow2bizList(Map paraMap) {
        return wfiWorkflow2bizDao.getWfiWorkflow2bizList(paraMap);
    }

    @Override
    public WfiWorkflow2biz getWfiWorkflow2bizDetail(String id) {
        return wfiWorkflow2bizDao.getWfiWorkflow2biz(id);
    }

    @Override
    public boolean updateWfiWorkflow2biz(int id, WfiWorkflow2biz WfiWorkflow2biz) {
        wfiWorkflow2bizDao.updateWfiWorkflow2biz(WfiWorkflow2biz);
        return true;
    }

    @Override
    public boolean addWfiWorkflow2biz(WfiWorkflow2biz WfiWorkflow2biz) {
        wfiWorkflow2bizDao.addWfiWorkflow2biz(WfiWorkflow2biz);
        return true;
    }

    @Override
    public boolean deleteWfiWorkflow2biz(int id) {
        wfiWorkflow2bizDao.deleteWfiWorkflow2biz(id);
        return true;
    }
}
