package myJoin.service.system.pub;

import myJoin.common.util.Pager;
import myJoin.domain.system.Advice;

/**
 * 建议Service接口
 * @author x
 *
 */
public interface IAdviceService {

	//分页查询建议
	Pager<Advice> findListByPager(Pager<Advice> pager);
	//修改建议
	Advice update(Advice advice);
	//新增建议
	Advice insert(Advice advice);
	//删除建议
	void delete(String[] ids);
	//首页查询未读消息数量
	int findListCount(Advice advice);

}
