package myJoin.domain.system;

import myJoin.framework.domain.BaseDomain;

/**
 * 系统公告实体类
 * @author x
 *
 */
public class Notice extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1414493820652956639L;

	private String id;
	
	private String title;
	
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
