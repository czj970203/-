package ticket.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		Object member = request.getSession().getAttribute("member");
		Object hall = request.getSession().getAttribute("hall");
		Object manager = request.getSession().getAttribute("manager");
		if (member == null && hall == null && manager == null) {
			response.sendRedirect("http://localhost:8080/Tickets/page/user_login.html");
			return false;
		}
		return true;
	}

}
