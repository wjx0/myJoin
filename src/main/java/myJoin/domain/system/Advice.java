package myJoin.domain.system;

import myJoin.framework.domain.BaseDomain;

public class Advice extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515013919823528161L;
	
	private String id;
	
	private String content;
	
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
