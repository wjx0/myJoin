package myJoin.domain.role;

import myJoin.framework.domain.BaseDomain;

/**
 * 角色实体类
 * @author x
 *
 */
public class Role extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107005321292720226L;

	private String id;
	
	private String roleName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
