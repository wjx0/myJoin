package myJoin.dao.shop;

import java.util.List;

import myJoin.domain.shop.Shop;
public interface ShopDao {

	//根据用户实体查询用户
	public Shop findByVo(Shop shop);
	//根据实体查询用户集合
	public List<Shop> findListByVo(Shop shop);
	//根据用户实体查询用户数量
	public int findListCountByVo(Shop t);
	//修改用户信息
	public void update(Shop shop);
	//新增用户信息
	public void insert(Shop shop);
	//删除用户信息
	public void delete(Shop shop);
	//根据用户实体查询vo
	public Shop findVoByShop(Shop shop);
	
}
