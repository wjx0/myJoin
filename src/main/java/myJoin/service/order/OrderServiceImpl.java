package myJoin.service.order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myJoin.common.login.UserContext;
import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.order.OrderDao;
import myJoin.dao.product.ProductDao;
import myJoin.domain.order.Order;
import myJoin.domain.product.Product;
import myJoin.service.order.pub.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	//分页查询用户列表
	public Pager<Order> findListByPager(Pager<Order> pager) {
		int totalCount = orderDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Order> orderList = orderDao.findListByVo(pager.getT());
		pager.setResultList(orderList);
		return pager;
	}

	//修改用户信息
	@Transactional
	public String update(Order order) {
		String msg = "";
		if(order.getStatus().equals("通过")) {
			Product product = new Product();
			product.setId(order.getProductId());
			product = productDao.findByVo(product);
			if(product.getQuantity() < order.getQuantity()) {
				msg = "库存不足";
				return msg;
			}
			product.setQuantity(product.getQuantity() - order.getQuantity());
			productDao.update(product);
		}
		order.setUpdator(UserContext.getUserRole().getUserName());
		order.setUpdateTime(new Date());
		orderDao.update(order);
		return msg;
	}

	//新增用户信息
	@Transactional
	public String insert(Order order) {
		String msg = "";
		Product product = new Product();
		product.setId(order.getProductId());
		product = productDao.findByVo(product);
		if(product.getQuantity() < order.getQuantity()) {
			msg = "库存不足";
			return msg;
		}
		order.setId(System.currentTimeMillis() + "");
		order.setCreator(UserContext.getUserRole().getUserName());
		order.setCreateTime(Dates.getNow());
		// 插入用户信息
		orderDao.insert(order);
		return msg;
	}

	//删除用户
	public void delete(Order order) {
		orderDao.delete(order);
	}
	
}
