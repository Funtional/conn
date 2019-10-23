package springmvc.model;

import com.yucheng.cmis.pub.CMISDomain;
import java.util.Map;
import com.yucheng.cmis.pub.annotation.CMISDomainAnnotation;

/**
 * <p>流程引擎 DOMAIN类:$createInfo.profile</p>
 * <p>$createInfo.description</p>
 * @author 作者
 * @createDate 2016-9-5 14:31:22
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WfiWorkflow2biz extends CMISDomain               
 {
	
    private static final long serialVersionUID = 1L;

	/**
	 * 构造函数
	 */
	public WfiWorkflow2biz(){
       init();
	}
	/**
	 * 构造函数
	 */	 
	public WfiWorkflow2biz(Map initData){
	   init();
	   this.dataPool.putAll(initData);
	}
		/**
	 * 构造函数，初始化表名和主键字段名
	 */
	public void init(){
		this.tableName = "wfi_workflow2biz";
		this.primaryKey = new String[]{  "pk1"   };
	}
	
 	/**
	 * <p>获取配置主键的值</p>
	 * @return 返回String 配置主键
	 */
	public String getPk1(){ 
		return this.dataPool.get("pk1") ==  null ? null:(String)this.dataPool.get("pk1");
	}
	/**
	 * <p>设置配置主键的值</p>
	 * @param Pk1 String 配置主键
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setPk1(String Pk1){
		this.dataPool.put("pk1", Pk1);
	}
 	/**
	 * <p>获取申请类型（ZB_BIZ_CATE）的值</p>
	 * @return 返回String 申请类型（ZB_BIZ_CATE）
	 */
	public String getApplType(){ 
		return this.dataPool.get("appl_type") ==  null ? null:(String)this.dataPool.get("appl_type");
	}
	/**
	 * <p>设置申请类型（ZB_BIZ_CATE）的值</p>
	 * @param ApplType String 申请类型（ZB_BIZ_CATE）
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setApplType(String ApplType){
		this.dataPool.put("appl_type", ApplType);
	}
 	/**
	 * <p>获取流程标识的值</p>
	 * @return 返回String 流程标识
	 */
	public String getWfsign(){ 
		return this.dataPool.get("wfsign") ==  null ? null:(String)this.dataPool.get("wfsign");
	}
	/**
	 * <p>设置流程标识的值</p>
	 * @param Wfsign String 流程标识
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setWfsign(String Wfsign){
		this.dataPool.put("wfsign", Wfsign);
	}
 	/**
	 * <p>获取流程名称的值</p>
	 * @return 返回String 流程名称
	 */
	public String getWfname(){ 
		return this.dataPool.get("wfname") ==  null ? null:(String)this.dataPool.get("wfname");
	}
	/**
	 * <p>设置流程名称的值</p>
	 * @param Wfname String 流程名称
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setWfname(String Wfname){
		this.dataPool.put("wfname", Wfname);
	}
 	/**
	 * <p>获取全局申请业务信息页面(.do/jsp)的值</p>
	 * @return 返回String 全局申请业务信息页面(.do/jsp)
	 */
	public String getAppUrl(){ 
		return this.dataPool.get("app_url") ==  null ? null:(String)this.dataPool.get("app_url");
	}
	/**
	 * <p>设置全局申请业务信息页面(.do/jsp)的值</p>
	 * @param AppUrl String 全局申请业务信息页面(.do/jsp)
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setAppUrl(String AppUrl){
		this.dataPool.put("app_url", AppUrl);
	}
 	/**
	 * <p>获取全局业务要素修改页面的值</p>
	 * @return 返回String 全局业务要素修改页面
	 */
	public String getBizUrl(){ 
		return this.dataPool.get("biz_url") ==  null ? null:(String)this.dataPool.get("biz_url");
	}
	/**
	 * <p>设置全局业务要素修改页面的值</p>
	 * @param BizUrl String 全局业务要素修改页面
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setBizUrl(String BizUrl){
		this.dataPool.put("biz_url", BizUrl);
	}
 	/**
	 * <p>获取风险拦截的值</p>
	 * @return 返回String 风险拦截
	 */
	public String getPreventList(){ 
		return this.dataPool.get("prevent_list") ==  null ? null:(String)this.dataPool.get("prevent_list");
	}
	/**
	 * <p>设置风险拦截的值</p>
	 * @param PreventList String 风险拦截
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setPreventList(String PreventList){
		this.dataPool.put("prevent_list", PreventList);
	}
 	/**
	 * <p>获取配置适用范围（999所有、111审批中、997通过、998否决）WFI_2BIZ_SCOPE的值</p>
	 * @return 返回String 配置适用范围（999所有、111审批中、997通过、998否决）WFI_2BIZ_SCOPE
	 */
	public String getSceneScope(){ 
		return this.dataPool.get("scene_scope") ==  null ? null:(String)this.dataPool.get("scene_scope");
	}
	/**
	 * <p>设置配置适用范围（999所有、111审批中、997通过、998否决）WFI_2BIZ_SCOPE的值</p>
	 * @param SceneScope String 配置适用范围（999所有、111审批中、997通过、998否决）WFI_2BIZ_SCOPE
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setSceneScope(String SceneScope){
		this.dataPool.put("scene_scope", SceneScope);
	}
 	/**
	 * <p>获取备注的值</p>
	 * @return 返回String 备注
	 */
	public String getRemark(){ 
		return this.dataPool.get("remark") ==  null ? null:(String)this.dataPool.get("remark");
	}
	/**
	 * <p>设置备注的值</p>
	 * @param Remark String 备注
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setRemark(String Remark){
		this.dataPool.put("remark", Remark);
	}
 	/**
	 * <p>获取流程处理页面的值</p>
	 * @return 返回String 流程处理页面
	 */
	public String getDealUrl(){ 
		return this.dataPool.get("deal_url") ==  null ? null:(String)this.dataPool.get("deal_url");
	}
	/**
	 * <p>设置流程处理页面的值</p>
	 * @param DealUrl String 流程处理页面
	 */
	@CMISDomainAnnotation(parameterType="1")
	public void setDealUrl(String DealUrl){
		this.dataPool.put("deal_url", DealUrl);
	}
    @Override
    public Object clone() throws CloneNotSupportedException {
		super.clone();
		WfiWorkflow2biz cloneObj = new WfiWorkflow2biz();
		Map data = super.getDataMap();
		return cloneObj;
	}
}

/**
 * 由模板domain.java.vm 针对wfi_workflow2biz表自动生成
 */
