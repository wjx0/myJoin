package myJoin.service.product;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.login.UserContext;
import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.product.ProductDao;
import myJoin.domain.product.Product;
import myJoin.service.product.pub.IProductService;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductDao productDao;
	
	//分页查询用户列表
	public Pager<Product> findListByPager(Pager<Product> pager) {
		int totalCount = productDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Product> productList = productDao.findListByVo(pager.getT());
		pager.setResultList(productList);
		return pager;
	}

	//修改用户信息
	public void update(Product product) {
		product.setUpdator(UserContext.getUserRole().getUserName());
		product.setUpdateTime(new Date());
		productDao.update(product);
	}

	//新增用户信息
	public Product insert(Product product) {
		//判断用户是否已经存在
		Product _product = productDao.findByVo(product);
		if(_product != null){
			return _product;
		}
		//设置用户信息
		product.setId(System.currentTimeMillis() + "");
		product.setCreator(UserContext.getUserRole().getUserName());
		product.setCreateTime(Dates.getNow());
		// 插入用户信息
		productDao.insert(product);
		return _product;
	}

	//删除用户
	public void delete(Product product) {
		productDao.delete(product);
	}
	
}
