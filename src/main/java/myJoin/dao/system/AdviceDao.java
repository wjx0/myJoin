package myJoin.dao.system;

import java.util.List;

import myJoin.domain.system.Advice;

/**
 * 建议Dao
 * @author x
 *
 */
public interface AdviceDao {

	//查询集合数量
	int findListCountByVo(Advice t);
	//查询建议集合
	List<Advice> findListByVo(Advice t);
	//查询建议
	Advice findByVo(Advice advice);
	//修改建议
	void update(Advice _advice);
	//新增建议
	void insert(Advice advice);
	//删除建议
	void delete(String id);

}
