package myJoin.controller.product;

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
import myJoin.domain.product.Product;
import myJoin.framework.controller.BaseController;
import myJoin.service.product.pub.IProductService;
/**
 * 产品管理Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	IProductService productServiceImpl; 

	//查询产品列表
	@RequestMapping("/findProductList")
	@ResponseBody
	public String findProductList(HttpServletRequest request,HttpServletResponse response,
			int rows,int page,Product product){
		createLog(request, SysActionTypeEnum.查询, "查询产品", "查询产品集合");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Product> pager = new Pager<Product>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(product);
			pager = productServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//修改产品
	@RequestMapping("/update")
	@ResponseBody
	public String updateProduct(HttpServletRequest request,HttpServletResponse response,Product product){
		createLog(request, SysActionTypeEnum.修改, "修改产品", "修改产品信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			productServiceImpl.update(product);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改成功",
					SysActionTypeEnum.修改.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.修改.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//新增产品
	@RequestMapping("/insert")
	@ResponseBody
	public String insertProduct(HttpServletRequest request,HttpServletResponse response,Product product){
		createLog(request, SysActionTypeEnum.新增, "新增产品", "新增产品信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Product _product = productServiceImpl.insert(product);
			if(_product==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"新增成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"产品名已存在",SysActionTypeEnum.新增.getCode());
			}
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//删除产品
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		createLog(request, SysActionTypeEnum.删除, "删除产品", "删除产品信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Product product = new Product();
			product.setId(id);
			productServiceImpl.delete(product);
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
