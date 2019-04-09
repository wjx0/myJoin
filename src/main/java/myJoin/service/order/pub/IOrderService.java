package myJoin.service.order.pub;

import myJoin.common.util.Pager;
import myJoin.domain.order.Order;

/**
 * 用户Service接口
 * @author order
 *
 */
public interface IOrderService{
	
	//分页查询用户列表
	public Pager<Order> findListByPager(Pager<Order> pager);
	//修改用户信息
	public String update(Order order);
	//新增用户信息
	public String insert(Order order);
	//删除用户信息
	public void delete(Order order);
}
