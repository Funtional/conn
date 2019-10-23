package springmvc.dao.interceptor;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import springmvc.util.SqlUtils;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;

/**
 * https://www.cnblogs.com/leavescy/p/7642113.html
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
        MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "insert", args = {
                MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "add", args = {
                MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }) })
@SuppressWarnings({"unchecked", "rawtypes"})
public class MybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try{
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];  // 获取xml中的一个select/update/insert/delete节点，主要描述的是一条SQL语句
            Object parameter = null;
            // 获取参数，if语句成立，表示sql语句有参数，参数格式是map形式
            if (invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
                System.out.println("parameter = " + parameter);
            }
            String sqlId = mappedStatement.getId(); // 获取到节点的id,即sql语句的id
            System.out.println("sqlId = " + sqlId);
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);  // BoundSql就是封装myBatis最终产生的sql类
            Configuration configuration = mappedStatement.getConfiguration();  // 获取节点的配置
            String sql = SqlUtils.getSql(configuration, boundSql); // 获取到最终的sql语句
            System.out.println("sql = " + sql);
            //log.debug(sql);
        }catch(Exception e){
            // log.error(e.getMessage(), e);
        }
        return invocation.proceed();  // 执行完上面的任务后，不改变原有的sql执行过程
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
