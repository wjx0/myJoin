package myJoin.service.product.pub;

import myJoin.common.util.Pager;
import myJoin.domain.product.Product;

/**
 * 用户Service接口
 * @author user
 *
 */
public interface IProductService{
	
	//分页查询用户列表
	public Pager<Product> findListByPager(Pager<Product> pager);
	//修改用户信息
	public void update(Product userVo);
	//新增用户信息
	public Product insert(Product userVo);
	//删除用户信息
	public void delete(Product user);
}
