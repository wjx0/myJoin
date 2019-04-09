package myJoin.service.shop;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.common.login.UserContext;
import myJoin.common.util.Dates;
import myJoin.common.util.Pager;
import myJoin.dao.shop.ShopDao;
import myJoin.domain.role.Role;
import myJoin.domain.shop.Shop;
import myJoin.service.shop.pub.IShopService;
@Service
public class ShopServiceImpl implements IShopService{

	@Autowired
	ShopDao shopDao;
	
	//分页查询用户列表
	public Pager<Shop> findListByPager(Pager<Shop> pager) {
		int totalCount = shopDao.findListCountByVo(pager.getT());
		pager.setTotalCount(totalCount);
		List<Shop> shopList = shopDao.findListByVo(pager.getT());
		pager.setResultList(shopList);
		return pager;
	}

	//修改用户信息
	public void update(Shop shop) {
		shop.setUpdator(UserContext.getUserRole().getUserName());
		shop.setUpdateTime(new Date());
		shopDao.update(shop);
	}

	//新增用户信息
	public Shop insert(Shop shop) {
		//判断用户是否已经存在
		Shop _shop = shopDao.findByVo(shop);
		if(_shop != null){
			return _shop;
		}
		//设置用户信息
		shop.setId(System.currentTimeMillis() + "");
		shop.setCreator(UserContext.getUserRole().getUserName());
		shop.setCreateTime(Dates.getNow());
		// 插入用户信息
		shopDao.insert(shop);
		return _shop;
	}

	//删除用户
	public void delete(Shop shop) {
		shopDao.delete(shop);
	}
	
}
