package myJoin.service.role.pub;

import myJoin.domain.role.Role;

/**
 * 角色Service接口
 * @author x
 *
 */
public interface IRoleService {
	//根据vo查询角色
	public Role findByVo(Role role);
}
