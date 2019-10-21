package springmvc.dao;

import springmvc.model.WfiWorkflow2biz;

import java.util.List;
import java.util.Map;

public interface WfiWorkflow2bizDao {
    List<WfiWorkflow2biz> getWfiWorkflow2bizList(Map paramMap);

    WfiWorkflow2biz getWfiWorkflow2biz(String id);

    /**
     * 增删改接口默认返回int型参数，表示影响的行数。
     */
    int updateWfiWorkflow2biz(WfiWorkflow2biz WfiWorkflow2biz);

    int addWfiWorkflow2biz(WfiWorkflow2biz WfiWorkflow2biz);

    int deleteWfiWorkflow2biz(int id);
}
