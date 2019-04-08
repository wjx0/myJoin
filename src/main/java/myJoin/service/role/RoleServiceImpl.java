package myJoin.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.dao.role.RoleDao;
import myJoin.domain.role.Role;
import myJoin.service.role.pub.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleDao roleDao;
	public Role findByVo(Role role) {
		return roleDao.findByVo(role);
	}

}
