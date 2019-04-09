package myJoin.domain.shop;

import myJoin.framework.domain.BaseDomain;

public class Shop extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6455823158895354806L;

	private String id;
	
	private String name;
	
	private String address;
	
	private String user_id;
	
	private String user_name;
	
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
