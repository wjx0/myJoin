package myJoin.controller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myJoin.common.enumx.ResponseEnum;
import myJoin.common.enumx.SysActionTypeEnum;
import myJoin.common.util.Pager;
import myJoin.common.vo.ResponseInfo;
import myJoin.domain.shop.Shop;
import myJoin.framework.controller.BaseController;
import myJoin.service.shop.pub.IShopService;
/**
 * 店铺管理Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {

	@Autowired
	IShopService shopServiceImpl; 

	//查询店铺列表
	@RequestMapping("/findShopList")
	@ResponseBody
	public String findShopList(HttpServletRequest request,HttpServletResponse response,
			int rows,int page,Shop shop){
		createLog(request, SysActionTypeEnum.查询, "查询店铺", "查询店铺集合");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Shop> pager = new Pager<Shop>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(shop);
			pager = shopServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//修改店铺
	@RequestMapping("/update")
	@ResponseBody
	public String updateShop(HttpServletRequest request,HttpServletResponse response,Shop shop){
		createLog(request, SysActionTypeEnum.修改, "修改店铺", "修改店铺信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			shopServiceImpl.update(shop);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改成功",
					SysActionTypeEnum.修改.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.修改.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//新增店铺
	@RequestMapping("/insert")
	@ResponseBody
	public String insertShop(HttpServletRequest request,HttpServletResponse response,Shop shop){
		createLog(request, SysActionTypeEnum.新增, "新增店铺", "新增店铺信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Shop _shop = shopServiceImpl.insert(shop);
			if(_shop==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"新增成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"店铺名已存在",SysActionTypeEnum.新增.getCode());
			}
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//删除店铺
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		createLog(request, SysActionTypeEnum.删除, "删除店铺", "删除店铺信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Shop shop = new Shop();
			shop.setId(id);
			shopServiceImpl.delete(shop);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
					"删除成功",SysActionTypeEnum.删除.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
}
