package myJoin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.util.Pager;
import myJoin.dao.system.MessageDao;
import myJoin.domain.system.Message;
import myJoin.service.system.pub.IMessageService;
/**
 * 信息Service实现接口
 * @author x
 *
 */
@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageDao messageDao;

	//分页查询信息
	public Pager<Message> findListByPager(Pager<Message> pager) {
		int totalCount = messageDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Message> messageList = messageDao.findListByVo(pager.getT());
		pager.setResultList(messageList);
		return pager;
	}
	//修改信息
	public Message update(Message message) {
		Message _message = messageDao.findByVo(message);
		if(_message == null){
			return null;
		}
		messageDao.update(_message);
		return _message;
	}
	//新增信息
	public Message insert(Message message) {
		Message _message = messageDao.findByVo(message);
		if(_message != null){
			return _message;
		}
		messageDao.insert(message);
		return _message;
	}
	//删除信息
	public void delete(String[] ids) {
		for(String id:ids){
			messageDao.delete(id);
		}
	}
	//首页查询未读消息数量
	public int findListCount(Message message) {
		return messageDao.findListCountByVo(message);
	}
}
