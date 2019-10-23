package springmvc.service;

import springmvc.model.WfiNode2biz;

import java.util.List;
import java.util.Map;

public interface WfiNode2bizService {
    List<WfiNode2biz> getWfiNode2bizList(Map paraMap);

    WfiNode2biz getWfiNode2bizDetail(String appl_type);

    boolean updateWfiNode2biz(int id, WfiNode2biz WfiNode2biz);

    boolean addWfiNode2biz(WfiNode2biz WfiNode2biz);

    boolean deleteWfiNode2biz(int id);
}
