package myJoin.service.system.pub;

import myJoin.common.util.Pager;
import myJoin.domain.system.Message;

/**
 * 系统公告Service接口
 * @author x
 *
 */
public interface IMessageService {

	//分页查询系统公告
	Pager<Message> findListByPager(Pager<Message> pager);
	//修改系统公告
	Message update(Message message);
	//新增系统公告
	Message insert(Message message);
	//删除系统公告
	void delete(String[] ids);
	//首页查询未读消息数量
	int findListCount(Message message);

}
