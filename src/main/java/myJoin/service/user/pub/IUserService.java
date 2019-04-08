package myJoin.service.user.pub;

import myJoin.common.util.Pager;
import myJoin.domain.user.User;
import myJoin.vo.login.UserVo;

/**
 * 用户Service接口
 * @author user
 *
 */
public interface IUserService{
	
	//根据用户实体查询用户信息
	public User findByVo(User user);
	//分页查询用户列表
	public Pager<UserVo> findListByPager(Pager<UserVo> pager);
	//修改用户信息
	public void update(UserVo userVo);
	//新增用户信息
	public User insert(UserVo userVo);
	//删除用户信息
	public void delete(User user);
	//根据用户实体查询vo
	public UserVo findVoByUser(User user);
}
