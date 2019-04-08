package myJoin.service.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.system.AdviceDao;
import myJoin.domain.system.Advice;
import myJoin.service.system.pub.IAdviceService;
/**
 * 建议Service实现接口
 * @author x
 *
 */
@Service
public class AdviceServiceImpl implements IAdviceService {

	@Autowired
	private AdviceDao adviceDao;

	//分页查询建议
	public Pager<Advice> findListByPager(Pager<Advice> pager) {
		int totalCount = adviceDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Advice> adviceList = adviceDao.findListByVo(pager.getT());
		pager.setResultList(adviceList);
		return pager;
	}
	//修改建议
	public Advice update(Advice advice) {
		Advice _advice = adviceDao.findByVo(advice);
		if(_advice == null){
			return null;
		}
		adviceDao.update(_advice);
		return _advice;
	}
	//新增建议
	public Advice insert(Advice advice) {
		Advice _advice = adviceDao.findByVo(advice);
		if(_advice != null){
			return _advice;
		}
		advice.setId("a"+Dates.getDateTime(new Date(), "yyyyMMddHHmmss"));
		advice.setState("0");
		adviceDao.insert(advice);
		return _advice;
	}
	//删除建议
	public void delete(String[] ids) {
		for(String id:ids){
			adviceDao.delete(id);
		}
	}
	//首页查询未读消息数量
	public int findListCount(Advice advice) {
		return adviceDao.findListCountByVo(advice);
	}
}
