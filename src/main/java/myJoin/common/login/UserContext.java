package myJoin.common.login;

import myJoin.domain.user.UserRole;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * 登录者信息操作
 * @author x
 *
 */
public class UserContext {

		private static final ThreadLocal<UserRole> session = new ThreadLocal<UserRole>();

		/**
		 * 获取登陆者信息
		 * 
		 * @return
		 */
		public static UserRole getUserRole() {
			/** 获取登陆者信息 **/
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				/**
				 * Spring Security 容器不存在已认证的员工 从本地线程获取 一般发起HttpClient请求时，通过此方法获取员工信息
				 **/
				return session.get();
			}
			Object curUser = authentication.getPrincipal();
			if (curUser != null && curUser instanceof UserCoreDetails) {
				UserCoreDetails userCoreDetails = (UserCoreDetails) curUser;
				if (userCoreDetails != null) {
					return userCoreDetails.getUserRole();
				}
			} else {
				/** anonymous 代表匿名身份 **/

			}
			return null;
		}

		/**
		 * 绑定登陆者信息
		 * 
		 * @param user
		 */
		public static void setUser(UserRole userRole) {
			session.set(userRole);
		}

		/**
		 * 清空登陆者信息
		 */
		public static void clear() {
			session.set(null);
		}
	}
