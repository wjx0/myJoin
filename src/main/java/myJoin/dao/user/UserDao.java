package myJoin.dao.user;

import java.util.List;

import myJoin.domain.user.User;
import myJoin.domain.user.UserRole;
import myJoin.vo.login.UserVo;
/**
 * 用户Dao
 * @author x
 *
 */
public interface UserDao {

	//根据用户实体查询用户
	public User findByVo(User user);
	//根据实体查询用户集合
	public List<UserVo> findListByVo(UserVo userVo);
	//根据用户实体查询用户数量
	public int findListCountByVo(User t);
	//修改用户信息
	public void update(User user);
	//修改用户信息
	public void updateUserRole(UserRole userRole);
	//新增用户信息
	public void insert(User user);
	//删除用户信息
	public void delete(User user);
	//根据用户查询角色
	public UserRole findUserRoleByUser(User user);
	//新增用户角色关系
	public void insertUserRole(UserRole userRole);
	//根据用户实体查询vo
	public UserVo findVoByUser(User user);
}
