package myJoin.service.system.pub;

import java.util.List;

import myJoin.common.util.Pager;
import myJoin.domain.system.Notice;

/**
 * 系统公告Service接口
 * @author x
 *
 */
public interface INoticeService {

	//分页查询系统公告
	Pager<Notice> findListByPager(Pager<Notice> pager);
	//修改系统公告
	Notice update(Notice notice);
	//新增系统公告
	Notice insert(Notice notice);
	//删除系统公告
	void delete(String[] ids);
	//首页轮播查询
	List<Notice> findList();
	//查询系统公告信息
	Notice findByVo(Notice notice);

}
