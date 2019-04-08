package myJoin.controller.user;

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
import myJoin.domain.user.User;
import myJoin.framework.controller.BaseController;
import myJoin.service.user.pub.IUserService;
import myJoin.vo.login.UserVo;
/**
 * 用户管理Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	IUserService userServiceImpl; 

	//查询用户列表
	@RequestMapping("/findUserList")
	@ResponseBody
	public String findUserList(HttpServletRequest request,HttpServletResponse response,
			int rows,int page,UserVo userVo){
		createLog(request, SysActionTypeEnum.查询, "查询用户", "查询用户集合");
		ResponseInfo<Object> responseInfo = null;
		try{
			Pager<UserVo> pager = new Pager<UserVo>();
			pager.setPage(page);
			pager.setRows(rows);
			pager.setSidx("id");
			pager.setSort(Pager.DIRECTION_ASC);
			pager.setT(userVo);
			pager = userServiceImpl.findListByPager(pager);
			return toPGJSON(pager);
		}catch(Exception e){
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//查询用户信息
	@RequestMapping("/findUser/{userName}")
	@ResponseBody
	public ModelAndView findUser(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String userName){
		createLog(request, SysActionTypeEnum.查询, "查询用户", "查询用户个人信息");
		ModelAndView mav = null;
		User user = new User();
		user.setUserName(userName);
		UserVo userVo = new UserVo();
		userVo = userServiceImpl.findVoByUser(user);
		mav = new ModelAndView("user/userDetail");
		mav.addObject("userVo", userVo);
		return mav;
	}
	
	//验证用户名
	@RequestMapping("/validUser/{userName}")
	@ResponseBody
	public String validUser(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String userName) {
		createLog(request, SysActionTypeEnum.查询, "查询用户", "验证用户名");
		ResponseInfo<Object> responseInfo = null;
		User user = new User();
		try {
			user.setUserName(userName);
			User _user = new User();
			_user = userServiceImpl.findByVo(user);
			if (_user == null) {
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(), 
						"用户名可用",SysActionTypeEnum.查询.getCode());
			} else {
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(), 
						"用户名已存在",SysActionTypeEnum.查询.getCode());
			}
		} catch (Exception e) {
			// 系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
		
	//修改用户
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(HttpServletRequest request,HttpServletResponse response,UserVo userVo){
		createLog(request, SysActionTypeEnum.修改, "修改用户", "修改用户信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			userServiceImpl.update(userVo);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),"修改成功",
					SysActionTypeEnum.修改.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.修改.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//新增用户
	@RequestMapping("/insert")
	@ResponseBody
	public String insertUser(HttpServletRequest request,HttpServletResponse response,UserVo userVo){
		createLog(request, SysActionTypeEnum.新增, "新增用户", "新增用户信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			User _user = userServiceImpl.insert(userVo);
			if(_user==null){
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"新增成功",SysActionTypeEnum.新增.getCode());
			}else{
				responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
						"用户名已存在",SysActionTypeEnum.新增.getCode());
			}
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.新增.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//删除用户
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		createLog(request, SysActionTypeEnum.删除, "删除用户", "删除用户信息");
		ResponseInfo<Object> responseInfo = null;
		try{
			User user = new User();
			user.setId(id);
			userServiceImpl.delete(user);
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_SUCCESS.getCode(),
					"删除成功",SysActionTypeEnum.删除.getCode());
		}catch(Exception e){
			//系统忙
			responseInfo = new ResponseInfo<Object>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.删除.getCode());
		}
		return toResponseJSON(responseInfo);
	}
	
	//找回账号
	@RequestMapping("/findBack")
	@ResponseBody
	public String findBack(HttpServletRequest request,HttpServletResponse response,String id){
		createLog(request, SysActionTypeEnum.查询, "查询用户", "账号找回");
		User user = new User();
		user.setId(id);
		ResponseInfo<User> responseInfo = null;
		try{
			User _user = null;
			_user = userServiceImpl.findByVo(user);
			if(_user == null){
				responseInfo = new ResponseInfo<User>(ResponseEnum.SYS_SUCCESS.getCode(),
						"输入标识不存在",SysActionTypeEnum.查询.getCode());
				return toResponseJSON(responseInfo);
			}
			responseInfo = new ResponseInfo<User>(ResponseEnum.SYS_SUCCESS.getCode(),
					"用户名:"+_user.getUserName()+";密码:"+_user.getPassword(),SysActionTypeEnum.查询.getCode());
		}catch(Exception e){
			responseInfo = new ResponseInfo<User>(ResponseEnum.SYS_FAILD.getCode(),
					ResponseEnum.SYS_FAILD.getDesc(),SysActionTypeEnum.查询.getCode());
		}
		return toResponseJSON(responseInfo);
	}
}
