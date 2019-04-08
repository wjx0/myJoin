package myJoin.dao.system;

import java.util.List;

import myJoin.domain.system.Notice;

/**
 * 系统公告Dao
 * @author x
 *
 */
public interface NoticeDao {

	//查询集合数量
	int findListCountByVo(Notice t);
	//查询系统公告集合
	List<Notice> findListByVo(Notice t);
	//查询系统公告
	Notice findByVo(Notice notice);
	//修改系统公告
	void update(Notice _notice);
	//新增系统公告
	void insert(Notice notice);
	//删除系统公告
	void delete(String id);
	//首页轮播查询
	List<Notice> findList();

}
