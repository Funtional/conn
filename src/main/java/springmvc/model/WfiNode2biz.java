package springmvc.model;

import com.yucheng.cmis.pub.CMISDomain;
import java.util.Map;
import com.yucheng.cmis.pub.annotation.CMISDomainAnnotation;

/**
 * <p>流程引擎 DOMAIN类:$createInfo.profile</p>
 * <p>$createInfo.description</p>
 * @author 作者
 * @createDate 2016-9-5 14:48:19
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WfiNode2biz extends CMISDomain               
 {
	
    private static final long serialVersionUID = 1L;

	/**
	 * 构造函数
	 */
	public WfiNode2biz(){
       init();
	}
	/**
	 * 构造函数
	 */	 
	public WfiNode2biz(Map initData){
	   init();
	   this.dataPool.putAll(initData);
	}
		/**
	 * 构造函数，初始化表名和主键字段名
	 */
	public void init(){
		this.tableName = "wfi_node2biz";
		this.primaryKey = new String[]{  "pk1"    ,"nodeid"   };
	}
	
 	/**
	 * <p>获取关联配置主键的值</p>
	 * @return 返回String 关联配置主键
	 */
	public String getPk1(){ 
		return this.dataPool.get("pk1") ==  null ? null:(String)this.dataPool.get("pk1");
	}
	/**
	 * <p>设置关联配置主键的值</p>
	 * @param Pk1 String 关联配置主键
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setPk1(String Pk1){
		this.dataPool.put("pk1", Pk1);
	}
 	/**
	 * <p>获取节点ID的值</p>
	 * @return 返回String 节点ID
	 */
	public String getNodeid(){ 
		return this.dataPool.get("nodeid") ==  null ? null:(String)this.dataPool.get("nodeid");
	}
	/**
	 * <p>设置节点ID的值</p>
	 * @param Nodeid String 节点ID
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setNodeid(String Nodeid){
		this.dataPool.put("nodeid", Nodeid);
	}
 	/**
	 * <p>获取节点名称的值</p>
	 * @return 返回String 节点名称
	 */
	public String getNodename(){ 
		return this.dataPool.get("nodename") ==  null ? null:(String)this.dataPool.get("nodename");
	}
	/**
	 * <p>设置节点名称的值</p>
	 * @param Nodename String 节点名称
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setNodename(String Nodename){
		this.dataPool.put("nodename", Nodename);
	}
 	/**
	 * <p>获取节点自定义申请信息页面的值</p>
	 * @return 返回String 节点自定义申请信息页面
	 */
	public String getNodeAppUrl(){ 
		return this.dataPool.get("node_app_url") ==  null ? null:(String)this.dataPool.get("node_app_url");
	}
	/**
	 * <p>设置节点自定义申请信息页面的值</p>
	 * @param NodeAppUrl String 节点自定义申请信息页面
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setNodeAppUrl(String NodeAppUrl){
		this.dataPool.put("node_app_url", NodeAppUrl);
	}
 	/**
	 * <p>获取节点自定义业务要素修改页面的值</p>
	 * @return 返回String 节点自定义业务要素修改页面
	 */
	public String getNodeBizUrl(){ 
		return this.dataPool.get("node_biz_url") ==  null ? null:(String)this.dataPool.get("node_biz_url");
	}
	/**
	 * <p>设置节点自定义业务要素修改页面的值</p>
	 * @param NodeBizUrl String 节点自定义业务要素修改页面
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setNodeBizUrl(String NodeBizUrl){
		this.dataPool.put("node_biz_url", NodeBizUrl);
	}
 	/**
	 * <p>获取流程处理页面的值</p>
	 * @return 返回String 流程处理页面
	 */
	public String getNodeDealUrl(){ 
		return this.dataPool.get("node_deal_url") ==  null ? null:(String)this.dataPool.get("node_deal_url");
	}
	/**
	 * <p>设置流程处理页面的值</p>
	 * @param NodeDealUrl String 流程处理页面
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setNodeDealUrl(String NodeDealUrl){
		this.dataPool.put("node_deal_url", NodeDealUrl);
	}
    @Override
    public Object clone() throws CloneNotSupportedException {
		super.clone();
		WfiNode2biz cloneObj = new WfiNode2biz();
		Map data = super.getDataMap();
        cloneObj.putData(data);
		return cloneObj;
	}
}

/**
 * 由模板domain.java.vm 针对wfi_node2biz表自动生成
 */
