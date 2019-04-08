package myJoin.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myJoin.common.login.UserContext;
import myJoin.common.login.UserCoreDetails;
import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.user.UserDao;
import myJoin.domain.role.Role;
import myJoin.domain.user.User;
import myJoin.domain.user.UserRole;
import myJoin.service.role.pub.IRoleService;
import myJoin.service.user.pub.IUserService;
import myJoin.vo.login.UserVo;
@Service
public class UserServiceImpl implements IUserService,UserDetailsService{

	@Autowired
	UserDao userDao;
	@Autowired
	IRoleService roleServiceImpl;
	
	public User findByVo(User user) {
		return userDao.findByVo(user);
	}

	public UserDetails loadUserByUsername(String userName) {
		UserCoreDetails details = null;
		User user = new User();
		user.setUserName(userName);
		UserRole ur = new UserRole();
		try {
			user = this.findByVo(user);
			ur = userDao.findUserRoleByUser(user);
			details =  new UserCoreDetails(user.getUserName(),user.getPassword(),
					true,true,true,true,AuthorityUtils.createAuthorityList(ur.getRoleName()),ur);
		} catch (UsernameNotFoundException usernameNotFoundException) {
			usernameNotFoundException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	//分页查询用户列表
	public Pager<UserVo> findListByPager(Pager<UserVo> pager) {
		int totalCount = userDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<UserVo> userList = userDao.findListByVo(pager.getT());
		pager.setResultList(userList);
		return pager;
	}

	//修改用户信息
	public void update(UserVo userVo) {
		updateUserRole(userVo);
		updateUser(userVo);
	}

	//用户信息修改
	private void updateUser(UserVo userVo) {
		User user = new User();
		user.setUserName(userVo.getUserName());
		user.setPassword(userVo.getPassword());
		user.setName(userVo.getName());
		user.setTel(userVo.getTel());
		user.setMail(userVo.getMail());
		user.setUpdator(UserContext.getUserRole().getUserName());
		user.setUpdateTime(new Date());
		userDao.update(user);
	}

	//用户角色对应信息修改
	private void updateUserRole(UserVo userVo) {
		User user = new User();
		user.setUserName(userVo.getUserName());
		user = userDao.findByVo(user);
		
		if(!userVo.getRoleName().isEmpty()){//有角色名
			//用户角色信息查询
			UserRole userRoleSerach = new UserRole();
			userRoleSerach = userDao.findUserRoleByUser(user);
			UserRole userRole = new UserRole();
			Role role = new Role();
			role.setRoleName(userVo.getRoleName());
			role = roleServiceImpl.findByVo(role);
			//用户角色信息设置
			userRole.setRoleId(role.getId());
			userRole.setRoleName(userVo.getRoleName());
			userRole.setUserId(user.getId());
			userRole.setUserName(userVo.getUserName());
			userRole.setName(userVo.getName());
			if(userRoleSerach == null){//无对应角色
				//用户角色对应信息新增
				userRole.setId(System.currentTimeMillis()+"");
				userRole.setCreateTime(new Date());
				userRole.setCreator(UserContext.getUserRole().getUserName());
				userDao.insertUserRole(userRole);
			}else{//有对应角色
				//用户角色对应信息修改
				userRole.setUpdator(UserContext.getUserRole().getUserName());
				userRole.setUpdateTime(new Date());
				userDao.updateUserRole(userRole);
			}
		}
	}

	//新增用户信息
	public User insert(UserVo userVo) {
		//判断用户是否已经存在
		User user = new User();
		user.setUserName(userVo.getUserName());
		User _user = userDao.findByVo(user);
		if(_user != null){
			return _user;
		}
		//设置用户信息
		user.setId(System.currentTimeMillis() + "");
		user.setPassword(userVo.getPassword());
		user.setName(userVo.getName());
		user.setMail(userVo.getMail());
		user.setTel(userVo.getTel());
		user.setCreator(UserContext.getUserRole().getUserName());
		user.setCreateTime(Dates.getNow());
		// 插入用户信息
		userDao.insert(user);
		if(!userVo.getRoleName().isEmpty()){
			//查询角色信息
			Role role = new Role();
			role.setRoleName(userVo.getRoleName());
			role=roleServiceImpl.findByVo(role);
			//设置用户角色
			UserRole userRole = new UserRole();
			userRole.setId(System.currentTimeMillis()+"");
			userRole.setUserId(user.getId());
			userRole.setRoleId(role.getId());
			userRole.setName(userVo.getName());
			userRole.setRoleName(userVo.getRoleName());
			userRole.setUserName(userVo.getUserName());
			userRole.setCreator(UserContext.getUserRole().getUserName());
			userRole.setCreateTime(Dates.getNow());
			userDao.insertUserRole(userRole);
		}
		return _user;
	}

	//删除用户
	public void delete(User user) {
		userDao.delete(user);
	}
	//查询用户vo
	public UserVo findVoByUser(User user) {
		return userDao.findVoByUser(user);
	}
	
	
}
