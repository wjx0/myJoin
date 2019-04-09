package myJoin.service.order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.login.UserContext;
import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.order.OrderDao;
import myJoin.domain.order.Order;
import myJoin.service.order.pub.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	OrderDao orderDao;
	
	//分页查询用户列表
	public Pager<Order> findListByPager(Pager<Order> pager) {
		int totalCount = orderDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Order> orderList = orderDao.findListByVo(pager.getT());
		pager.setResultList(orderList);
		return pager;
	}

	//修改用户信息
	public void update(Order order) {
		order.setUpdator(UserContext.getUserRole().getUserName());
		order.setUpdateTime(new Date());
		orderDao.update(order);
	}

	//新增用户信息
	public Order insert(Order order) {
		//设置用户信息
		order.setId(System.currentTimeMillis() + "");
		order.setCreator(UserContext.getUserRole().getUserName());
		order.setCreateTime(Dates.getNow());
		// 插入用户信息
		orderDao.insert(order);
		return order;
	}

	//删除用户
	public void delete(Order order) {
		orderDao.delete(order);
	}
	
}
