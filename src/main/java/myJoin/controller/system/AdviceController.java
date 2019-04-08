package myJoin.controller.system;

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
import myJoin.domain.system.Advice;
import myJoin.framework.controller.BaseController;
import myJoin.service.system.pub.IAdviceService;
/**
 * 建议Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/system/advice")
public class AdviceController extends BaseController {

	@Autowired
	private IAdviceService adviceServiceImpl;
	//跳转到建议页面
	@RequestMapping("/toAdvice")
	public String toAdvice(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.跳转, "页面跳转", "跳转到建议页面");
		return redirect("/views/system/advice.jsp");
	}
	//查询建议
	@RequestMapping("/findAdviceList")
	public String findAdviceList(HttpServletRequest request, HttpServletResponse response,Advice advice,int rows,int page){
		createLog(request, SysActionTypeEnum.查询, "查询建议", "分页查询建议");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Advice> pager = new Pager<Advice>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(advice);
			pager = adviceServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	
	//修改建议
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response,Advice advice){
		createLog(request, SysActionTypeEnum.修改, "修改建议", "修改建议建议");
		ResponseInfo<Object> responseInfo = null;
		try{
			Advice _advice = adviceServiceImpl.update(advice);
			if(_advice==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改失败",SysActionTypeEnum.修改.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改成功",SysActionTypeEnum.修改.getCode());
			}
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.修改.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//新增建议
	@RequestMapping("/insert/{content}")
	@ResponseBody
	public String insert(HttpServletRequest request, HttpServletResponse response,@PathVariable String content){
		createLog(request, SysActionTypeEnum.新增, "新增建议", "新增建议");
		ResponseInfo<Object> responseInfo = null;
		Advice advice = new Advice();
		advice.setContent(content);
		try{
			Advice _advice = adviceServiceImpl.insert(advice);
			if(_advice==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"新增建议成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"已存在此建议",SysActionTypeEnum.新增.getCode());
			}
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	//删除建议
	@RequestMapping("/delete/{ids}")
	public String delete(@PathVariable String[] ids,HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.删除, "删除建议", "删除建议建议");
		ResponseInfo<Object> responseInfo = null;
		try{
			adviceServiceImpl.delete(ids);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"删除成功",SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}
	}
}
