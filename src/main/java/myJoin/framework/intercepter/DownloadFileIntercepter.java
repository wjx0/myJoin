package myJoin.framework.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

public class DownloadFileIntercepter implements HandlerInterceptor {
	
    protected static Log logger = LogFactory.getLog(DownloadFileIntercepter.class);

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		try {
			if((request.getParameter("isBigFile")+"").equalsIgnoreCase("true")){
				request.getSession().setAttribute(request.getAttribute("htmlDownloadFileToken")+"", true);
			}
		} catch (Exception e) {
			request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			UrlPathHelper urlPathHelper = new UrlPathHelper();
			logger.error("afterCompletion path:"+urlPathHelper.getRequestUri(request),e);
		}
	}

}