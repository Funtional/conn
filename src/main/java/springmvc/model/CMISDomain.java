package springmvc.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.yucheng.cmis.pub.util.StringUtil;

/**
 * CMISDomain 抽象类
 * @Classname com.yucheng.cmis.pub.CMISDomain.java
 * @author wqgang
 * @Since 2009-3-24 上午09:24:08 
 * @Copyright yuchengtech
 * @version 1.0
 */
public abstract class CMISDomain implements Cloneable, Serializable   {
	
	/** 实体对象中实际存储数据的MAP结构 */
	protected Map dataPool = new HashMap(128);	
	
	protected String tableName ;
	
	protected String[] primaryKey;
	
	
	/**
	 * 构造函数
	 */
	public CMISDomain(){
	
	}
	
	/**
	 * 构造函数，初始化表名称和主键字段名
	 * @param tableName
	 * @param primaryKey
	 */
//	public CMISDomain(String tableName,String primaryKey){
//		this.tableName = tableName;
//		if ( primaryKey != null )
//			this.primaryKey =  primaryKey.split(",");
//	}
	
	/**
	 * 克隆方法
	 * @return 被克隆对象的实例
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	/**
	 * 将MAP数据加入至实体对象中
	 * @param data 待加入的数据
	 */
	public void putData(Map data){
		if(data == null){
			return ;
		}
		if(this.dataPool == null){
			dataPool = new HashMap(128);
		}
		this.dataPool.putAll(data);
	}

	/**
	 * 返回内置的MAP结构
	 * @return
	 */
	public Map getDataMap(){
		return this.dataPool;
	}
	

	/**
	 * 返回内置的物理表名
	 * @return
	 */
	public String getTableName(){
		return this.tableName;
	}
	
	/**
	 * 得到对应的表模型ID
	 * @return
	 */
	public String getModuleId(){
		String moduleId = null;
		if(this.tableName != null){
			moduleId = StringUtil.transDBField2MethodNm(this.tableName);
		}
		return moduleId;
	}

	/**
	 * 返回内置的主键字段名数组
	 * @return
	 */
	public String[] getPrimaryKey(){
		return this.primaryKey;
	}
}
