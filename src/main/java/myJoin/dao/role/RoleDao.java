package myJoin.dao.role;

import myJoin.domain.role.Role;
/**
 * 角色dao
 * @author x
 *
 */
public interface RoleDao {
	//根据vo查询角色
	public Role findByVo(Role role);
}
