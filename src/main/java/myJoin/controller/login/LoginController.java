package myJoin.controller.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myJoin.common.enumx.ResponseEnum;
import myJoin.common.enumx.SysActionTypeEnum;
import myJoin.common.vo.ResponseInfo;
import myJoin.domain.user.User;
import myJoin.framework.controller.BaseController;
import myJoin.service.user.pub.IUserService;
/**
 * 登录Controller
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@Autowired
	IUserService userServiceImpl;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String userName,String password,HttpServletRequest request,HttpServletResponse response) throws IOException{
		ResponseInfo<Object> responseInfo = new ResponseInfo<Object>();
		userName = userName.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, password);
		try {
			Authentication authentication = myAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername
			SecurityContextHolder.getContext().setAuthentication(authentication);
			HttpSession session = request.getSession();
			session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
			createLog(request, SysActionTypeEnum.登录, "用户登录", "用户自主登陆系统");
			responseInfo.setFlowId(SysActionTypeEnum.登录.getCode());
			responseInfo.setResCode(ResponseEnum.LOGIN_SUCC.getCode());
			responseInfo.setResMsg(ResponseEnum.LOGIN_SUCC.getDesc());
			return toResponseJSON(responseInfo);
		} catch (AuthenticationException ex) {
			responseInfo.setFlowId(SysActionTypeEnum.登录.getCode());
			responseInfo.setResCode(ResponseEnum.LOGIN_FAIL.getCode());
			responseInfo.setResMsg(ResponseEnum.LOGIN_FAIL.getDesc());
			return toResponseJSON(responseInfo);
		}
	}
	@RequestMapping("/validUserName/{userName}")
	public String validUserName(@PathVariable String userName,HttpServletRequest request,HttpServletResponse response){
		createLog(request, SysActionTypeEnum.查询, "验证用户名", "验证用户名是否存在");
		ResponseInfo<Object> responseInfo = new ResponseInfo<Object>();
		User user = null;
		try{
			user = userServiceImpl.findByVo(user);
			if(user == null){
				responseInfo.setFlowId(SysActionTypeEnum.查询.getCode());
				responseInfo.setResCode(ResponseEnum.VALIDATE_ISNULL.getCode());
				responseInfo.setResMsg(ResponseEnum.VALIDATE_ISNULL.getDesc());
				return toResponseJSON(responseInfo);
			}
			responseInfo.setFlowId(SysActionTypeEnum.查询.getCode());
			responseInfo.setResCode(ResponseEnum.SYS_SUCCESS.getCode());
			responseInfo.setResMsg(ResponseEnum.SYS_SUCCESS.getDesc());
			return toResponseJSON(responseInfo);
		}catch (Exception ex) {
			responseInfo.setFlowId(SysActionTypeEnum.查询.getCode());
			responseInfo.setResCode(ResponseEnum.SYS_FAILD.getCode());
			responseInfo.setResMsg(ResponseEnum.SYS_FAILD.getDesc());
			return toResponseJSON(responseInfo);
		}
	}
}
