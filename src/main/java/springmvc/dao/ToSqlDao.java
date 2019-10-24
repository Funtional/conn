package springmvc.dao;

import java.util.List;
import java.util.Map;

public interface ToSqlDao {

    Integer insert(String statement);

    Integer delete(String statement);

    Integer update(String statement);

    List<Map<String, Object>> selectList(String statement);

    String selectOne(String statement);
}