package myJoin.common.login;

import java.util.Collection;

import myJoin.domain.user.UserRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 * 
 * @author x
 *
 */

public class UserCoreDetails extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5145310464617365662L;
	
	private UserRole userRole;
	
	public UserCoreDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities,
			UserRole userRole) {
		super(username, password, true, true, true,true, authorities);
		this.setUserRole(userRole);
	}
	
	public UserCoreDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			UserRole userRole) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.setUserRole(userRole);
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	
}
