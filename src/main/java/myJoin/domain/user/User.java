package myJoin.domain.user;

import myJoin.framework.domain.BaseDomain;
/**
 * 用户实体类
 * @author x
 *
 */
public class User extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6455823158895354806L;

	private String id;
	
	private String userName;
	
	private String password;
	
	private String name;
	
	private String mail;
	
	private String tel;
	
	private String roleId;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	


	
}
