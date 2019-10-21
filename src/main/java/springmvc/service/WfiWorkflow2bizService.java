package springmvc.service;

import springmvc.model.WfiWorkflow2biz;

import java.util.List;
import java.util.Map;

public interface WfiWorkflow2bizService {
    List<WfiWorkflow2biz> getWfiWorkflow2bizList(Map paraMap);

    WfiWorkflow2biz getWfiWorkflow2bizDetail(String appl_type);

    boolean updateWfiWorkflow2biz(int id, WfiWorkflow2biz WfiWorkflow2biz);

    boolean addWfiWorkflow2biz(WfiWorkflow2biz WfiWorkflow2biz);

    boolean deleteWfiWorkflow2biz(int id);
}
