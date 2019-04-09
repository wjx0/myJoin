package myJoin.dao.product;

import java.util.List;

import myJoin.domain.product.Product;
public interface ProductDao {

	//根据用户实体查询用户
	public Product findByVo(Product product);
	//根据实体查询用户集合
	public List<Product> findListByVo(Product product);
	//根据用户实体查询用户数量
	public int findListCountByVo(Product t);
	//修改用户信息
	public void update(Product product);
	//新增用户信息
	public void insert(Product product);
	//删除用户信息
	public void delete(Product product);
	//根据用户实体查询vo
	public Product findVoByProduct(Product product);
	
}
