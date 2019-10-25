package springmvc.service.impl;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.service.IToSqlService;
import springmvc.util.MyBatisUtil;
import springmvc.util.SqlUtils;
import springmvc.util.StringUtils;

import java.util.List;
import java.util.Map;

import static springmvc.config.SqlConfig.*;

@Service
public class ToSqlServiceImpl implements IToSqlService {


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public StringBuffer getPublishSql(String sql_name, Map<String,String> paramMap){
        String mapperNameSpace = PRE_MAPPER_NAMESPACE + MAPPER_NAMESPACE_SEPARATOR + sql_name; // select语句的标识
        StringBuffer publishSqlSb = new StringBuffer(); //用于返回拼接好的delete和insert语句

        Configuration configuration = sqlSessionFactory.getConfiguration();
        BoundSql boundSql = configuration.getMappedStatement(mapperNameSpace).getBoundSql(paramMap);
        String selectSql = SqlUtils.getSql(configuration, boundSql);//获取到的select语句带参数

        /** 拼接delete语句 **/
        publishSqlSb.append(this.getDeleteSqlSb(selectSql)).append(SQL_LINEFEED);

        /** 开始获取数据，并拼接insert语句**/
        String tableName = StringUtils.getTableName(selectSql.toUpperCase()); //获取表明，用于后面拼接insert语句
        configuration.setCallSettersOnNulls(true); //查询时，值为null，也要取出来 https://www.cnblogs.com/zhengOK/p/10439232.html
        SqlSession session = MyBatisUtil.getSession(sqlSessionFactory);
        List<Map<String, String>> resultList = session.selectList(mapperNameSpace, paramMap);//获取数据 https://www.cnblogs.com/gongxr/p/10313639.html
        for (Map<String, String> map: resultList){
            publishSqlSb.append(this.getInsertSqlSb(tableName, map)).append(SQL_LINEFEED);
        }
        return publishSqlSb;
    }

    /**
     * 拼接insert语句
     * @param tableName 表名
     * @param map 数据库中的字段名和对应的值；值不为null的key，转化为string并在前后加单引号； 值为null的key，值拼接为null
     * @return  StringBuffer : INSERT INTO tableName (k1, k2, k3) VALUES(v1, v2, v3)
     */
    private StringBuffer getInsertSqlSb(String tableName, Map<String, String> map){
        StringBuffer preSqlSb = new StringBuffer();
        StringBuffer postSqlSb = new StringBuffer();
        preSqlSb.append("INSERT INTO ").append(tableName).append(" (");
        postSqlSb.append(") VALUES(");
        for (Map.Entry entry: map.entrySet()){
            preSqlSb.append(entry.getKey()).append(", ");
            postSqlSb.append(StringUtils.addSingleQuotes(entry.getValue())).append(", ");
        }
        preSqlSb.delete(preSqlSb.length()-2, preSqlSb.length()); //删除最后多余的逗号和空格
        postSqlSb.delete(postSqlSb.length()-2, postSqlSb.length()).append(")");
        return preSqlSb.append(postSqlSb);
    }

    private String getDeleteSqlSb(String sql){
       return "DELETE " + StringUtils.getPostDeleteSql(sql);
    }

}
