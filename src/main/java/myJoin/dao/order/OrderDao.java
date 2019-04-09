package myJoin.dao.order;

import java.util.List;

import myJoin.domain.order.Order;
public interface OrderDao {

	//根据用户实体查询用户
	public Order findByVo(Order order);
	//根据实体查询用户集合
	public List<Order> findListByVo(Order order);
	//根据用户实体查询用户数量
	public int findListCountByVo(Order t);
	//修改用户信息
	public void update(Order order);
	//新增用户信息
	public void insert(Order order);
	//删除用户信息
	public void delete(Order order);
	//根据用户实体查询vo
	public Order findVoByOrder(Order order);
	
}
