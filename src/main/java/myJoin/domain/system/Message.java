package myJoin.domain.system;

import myJoin.framework.domain.BaseDomain;

public class Message extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 516696229589921727L;

	private String id;
	
	private String sender;
	
	private String receiver;
	
	private String title;
	
	private String content;

	private String state;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
