package myJoin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myJoin.common.enumx.SysActionTypeEnum;
import myJoin.framework.controller.BaseController;
/**
 * 系统Controller
 * @author x
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {

	//转到主页
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest request, HttpServletResponse response){
		createLog(request, SysActionTypeEnum.跳转, "页面跳转", "跳转到主页");
		return redirect("/views/index.jsp");
	}
	
}
