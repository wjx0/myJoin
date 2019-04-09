package myJoin.service.shop.pub;

import myJoin.common.util.Pager;
import myJoin.domain.shop.Shop;

/**
 * 用户Service接口
 * @author user
 *
 */
public interface IShopService{
	
	//分页查询用户列表
	public Pager<Shop> findListByPager(Pager<Shop> pager);
	//修改用户信息
	public void update(Shop userVo);
	//新增用户信息
	public Shop insert(Shop userVo);
	//删除用户信息
	public void delete(Shop user);
}
