package myJoin.domain.user;

import myJoin.framework.domain.BaseDomain;
/**
 * 用户，角色关联实体类
 * @author x
 *
 */
public class UserRole extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9142242937778208612L;

	private String id;
	
	private String userId;
	
	private String userName;
	
	private String roleId;
	
	private String roleName;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
