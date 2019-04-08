package myJoin.framework.domain;

import java.io.Serializable;
import java.util.Date;

import myJoin.common.util.Pager;

import com.alibaba.fastjson.annotation.JSONType;
/**
 * 实体基类
 * @author x
 *
 */
@JSONType(ignores={"pager"})
public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3198836876617779231L;

	/** 创建人 **/
	private String creator;
	/** 更新人 **/
	private String updator;
	/** 创建时间 **/
	private Date createTime;
	/** 更新时间 **/
	private Date updateTime;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
