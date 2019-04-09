package myJoin.controller.order;

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
import myJoin.domain.order.Order;
import myJoin.framework.controller.BaseController;
import myJoin.service.order.pub.IOrderService;
/**
 * 订单管理Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	IOrderService orderServiceImpl; 
	
	//查询订单列表
	@RequestMapping("/findOrderList")
	@ResponseBody
	public String findOrderList(HttpServletRequest request,HttpServletResponse response,
			int rows,int page,Order order){
		createLog(request, SysActionTypeEnum.查询, "查询订单", "查询订单集合");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Order> pager = new Pager<Order>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(order);
			pager = orderServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//修改订单
	@RequestMapping("/update")
	@ResponseBody
	public String updateOrder(HttpServletRequest request,HttpServletResponse response,Order order){
		createLog(request, SysActionTypeEnum.修改, "修改订单", "修改订单信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			orderServiceImpl.update(order);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改成功",
					SysActionTypeEnum.修改.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.修改.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//新增订单
	@RequestMapping("/insert")
	@ResponseBody
	public String insertOrder(HttpServletRequest request,HttpServletResponse response,Order order){
		createLog(request, SysActionTypeEnum.新增, "新增订单", "新增订单信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Order _order = orderServiceImpl.insert(order);
			if(_order==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"新增成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"订单名已存在",SysActionTypeEnum.新增.getCode());
			}
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//删除订单
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		createLog(request, SysActionTypeEnum.删除, "删除订单", "删除订单信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Order order = new Order();
			order.setId(id);
			orderServiceImpl.delete(order);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
					"删除成功",SysActionTypeEnum.删除.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//删除订单
		@RequestMapping("/pass/{id}")
		@ResponseBody
		public String pass(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
			createLog(request, SysActionTypeEnum.通过, "通过订单", "通过订单信息");
			ResponseInfo<Object> responseInfo = null;
			try{
				Order order = new Order();
				order.setId(id);
				order.setStatus("通过");
				orderServiceImpl.update(order);
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"通过成功",SysActionTypeEnum.通过.getCode());
			}catch(Exception e){
				//系统忙
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
						ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.通过.getCode());
			}
			return toResponseJSON(responseInfo);
		}
		
		//删除订单
		@RequestMapping("/lose/{id}")
		@ResponseBody
		public String lose(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
			createLog(request, SysActionTypeEnum.退回, "退回订单", "退回订单信息");
			ResponseInfo<Object> responseInfo = null;
			try{
				Order order = new Order();
				order.setId(id);
				order.setStatus("退回");
				orderServiceImpl.update(order);
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"退回成功",SysActionTypeEnum.退回.getCode());
			}catch(Exception e){
				//系统忙
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
						ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.退回.getCode());
			}
			return toResponseJSON(responseInfo);
		}
	
}
