package myJoin.dao.system;

import java.util.List;

import myJoin.domain.system.Message;

/**
 * 信息Dao
 * @author x
 *
 */
public interface MessageDao {

	//查询集合数量
	int findListCountByVo(Message t);
	//查询信息集合
	List<Message> findListByVo(Message t);
	//查询信息
	Message findByVo(Message message);
	//修改信息
	void update(Message _message);
	//新增信息
	void insert(Message message);
	//删除信息
	void delete(String id);

}
