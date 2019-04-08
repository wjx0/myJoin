package myJoin.vo.login;

import myJoin.domain.user.User;

/**
 * 用户Vo类
 * @author x
 *
 */
public class UserVo extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1688635103558276308L;
	
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
