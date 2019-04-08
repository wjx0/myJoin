package myJoin.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.util.Pager;
import myJoin.dao.system.NoticeDao;
import myJoin.domain.system.Notice;
import myJoin.service.system.pub.INoticeService;
/**
 * 系统公告Service实现接口
 * @author x
 *
 */
@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	private NoticeDao noticeDao;

	//分页查询系统公告
	public Pager<Notice> findListByPager(Pager<Notice> pager) {
		int totalCount = noticeDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Notice> noticeList = noticeDao.findListByVo(pager.getT());
		pager.setResultList(noticeList);
		return pager;
	}
	//修改系统公告
	public Notice update(Notice notice) {
		Notice _notice = noticeDao.findByVo(notice);
		if(_notice == null){
			return null;
		}
		noticeDao.update(_notice);
		return _notice;
	}
	//新增系统公告
	public Notice insert(Notice notice) {
		Notice _notice = noticeDao.findByVo(notice);
		if(_notice != null){
			return _notice;
		}
		noticeDao.insert(notice);
		return _notice;
	}
	//删除系统公告
	public void delete(String[] ids) {
		for(String id:ids){
			noticeDao.delete(id);
		}
	}
	//首页轮播查询
	public List<Notice> findList() {
		return noticeDao.findList();
	}
	//查询系统公告信息
	public Notice findByVo(Notice notice) {
		return noticeDao.findByVo(notice);
	}
}
