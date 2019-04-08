package myJoin.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import myJoin.common.enumx.ResponseEnum;
import myJoin.common.enumx.SysActionTypeEnum;
import myJoin.common.util.Pager;
import myJoin.common.vo.ResponseInfo;
import myJoin.domain.system.Notice;
import myJoin.framework.controller.BaseController;
import myJoin.service.system.pub.INoticeService;
/**
 * 系统公告Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/system/notice")
public class NoticeController extends BaseController {

	@Autowired
	private INoticeService noticeServiceImpl;
	//跳转到系统公告页面
	@RequestMapping("/toNotice")
	public String toNotice(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.跳转, "页面跳转", "跳转到系统公告页面");
		return redirect("/views/system/notice.jsp");
	}
	//查询系统公告
	@RequestMapping("/findNoticeList")
	public String findNoticeList(HttpServletRequest request, HttpServletResponse response,Notice notice,int rows,int page){
		createLog(request, SysActionTypeEnum.查询, "查询系统公告", "分页查询系统公告");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Notice> pager = new Pager<Notice>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(notice);
			pager = noticeServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//首页轮播查询系统公告
	@RequestMapping("/findList")
	@ResponseBody
	public String findList(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.查询, "查询系统公告", "首页轮播查询系统公告");
		ResponseInfo<Object> responseInfo = null;
		try{
			List<Notice> noticeList = null;
			noticeList = noticeServiceImpl.findList();
			if(noticeList == null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"查询失败",SysActionTypeEnum.查询.getCode());
				return toResponseJSON(responseInfo);
			}
			Pager<Notice> pager = new Pager<Notice>();
			pager.setResultList(noticeList);
			return toPGJSON(pager);
		}catch(Exception e){
			System.out.println(e.getMessage());
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//查询系统公告信息
		@RequestMapping("/findNotice/{title}")
		@ResponseBody
		public ModelAndView findNotice(HttpServletRequest request,HttpServletResponse response,@PathVariable String title){
			createLog(request, SysActionTypeEnum.查询, "查询系统公告", "查询系统公告信息");
			ModelAndView mav = null;
			ResponseInfo<Notice> responseInfo = null;
			Notice notice = new Notice();
			try{
				notice.setTitle(title);
				Notice _notice = new Notice();
				_notice = noticeServiceImpl.findByVo(notice);
				mav = new ModelAndView("system/notice/noticeDetail");
				mav.addObject("notice", _notice);
			}catch(Exception e){
				//系统忙
				responseInfo = new ResponseInfo<Notice>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
				mav = new ModelAndView("/views/index.jsp");
				mav.addObject("ResponseInfo", responseInfo);
			}
			return mav;
		}
	//修改系统公告
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response,Notice notice){
		createLog(request, SysActionTypeEnum.修改, "修改系统公告", "修改系统公告信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Notice _notice = noticeServiceImpl.update(notice);
			if(_notice==null){
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
	//新增系统公告
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, HttpServletResponse response,Notice notice){
		createLog(request, SysActionTypeEnum.新增, "新增系统公告", "新增系统公告信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Notice _notice = noticeServiceImpl.insert(notice);
			if(_notice==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"新增成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"已有该数据",SysActionTypeEnum.新增.getCode());
			}
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//删除系统公告
	@RequestMapping("/delete/{ids}")
	public String delete(@PathVariable String[] ids,HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.删除, "删除系统公告", "删除系统公告信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			noticeServiceImpl.delete(ids);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"删除成功",SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}
	}
}
