package springmvc.dao;

import springmvc.model.WfiNode2biz;

import java.util.List;
import java.util.Map;

public interface WfiNode2bizDao {
    List<WfiNode2biz> getWfiNode2bizList(Map paramMap);

    WfiNode2biz getWfiNode2biz(String id);

    /**
     * 增删改接口默认返回int型参数，表示影响的行数。
     */
    int updateWfiNode2biz(WfiNode2biz WfiNode2biz);

    int addWfiNode2biz(WfiNode2biz WfiNode2biz);

    int deleteWfiNode2biz(int id);
}
