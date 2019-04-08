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
import myJoin.common.login.UserContext;
import myJoin.common.util.Pager;
import myJoin.common.vo.ResponseInfo;
import myJoin.domain.system.Message;
import myJoin.domain.user.UserRole;
import myJoin.framework.controller.BaseController;
import myJoin.service.system.pub.IMessageService;
/**
 * 信息Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/system/message")
public class MessageController extends BaseController {

	@Autowired
	private IMessageService messageServiceImpl;
	//跳转到信息页面
	@RequestMapping("/toMessage")
	public String toMessage(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.跳转, "页面跳转", "跳转到信息页面");
		return redirect("/views/system/message.jsp");
	}
	//查询信息
	@RequestMapping("/findMessageList")
	public String findMessageList(HttpServletRequest request, HttpServletResponse response,Message message,int rows,int page){
		createLog(request, SysActionTypeEnum.查询, "查询信息", "分页查询信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<Message> pager = new Pager<Message>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(message);
			pager = messageServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//首页消息数量查询
	@RequestMapping("/findListCount")
	@ResponseBody
	public String findListCount(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.查询, "查询信息", "查询首页未读信息数量");
		ResponseInfo<Integer> responseInfo = null;
		UserRole userRole = UserContext.getUserRole();
		Message message = new Message();
		int count = 0;
		try{
			message.setReceiver(userRole.getUserName());
			message.setState("0");
			count = messageServiceImpl.findListCount(message);
			if(count == 0){
				responseInfo = new ResponseInfo<Integer>(ResponseEnum.SYS_SUCCESS.getCode(),"没有未读消息",SysActionTypeEnum.查询.getCode());
				return toResponseJSON(responseInfo);
			}
			responseInfo = new ResponseInfo<Integer>(ResponseEnum.SYS_SUCCESS.getCode(),"查询成功",SysActionTypeEnum.查询.getCode(),count);
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			System.out.println(e.getMessage());
			responseInfo = new ResponseInfo<Integer>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
			return toResponseJSON(responseInfo);
		}
	}
	//修改信息
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response,Message message){
		createLog(request, SysActionTypeEnum.修改, "修改信息", "修改信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Message _message = messageServiceImpl.update(message);
			if(_message==null){
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
	//新增信息
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, HttpServletResponse response,Message message){
		createLog(request, SysActionTypeEnum.新增, "新增信息", "新增信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			Message _message = messageServiceImpl.insert(message);
			if(_message==null){
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
	//删除信息
	@RequestMapping("/delete/{ids}")
	public String delete(@PathVariable String[] ids,HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.删除, "删除信息", "删除信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			messageServiceImpl.delete(ids);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"删除成功",SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
			return toResponseJSON(responseInfo);
		}
	}
}
