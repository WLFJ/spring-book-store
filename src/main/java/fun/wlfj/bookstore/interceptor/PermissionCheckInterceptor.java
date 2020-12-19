package fun.wlfj.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import fun.wlfj.bookstore.entity.PermissionableEntity;
import fun.wlfj.bookstore.entity.User;

public class PermissionCheckInterceptor implements HandlerInterceptor {
	
	private PermissionableEntity entity;
	private String opr;
	
	public PermissionCheckInterceptor(PermissionableEntity permissionableEntity, String opr) {
		this.entity = permissionableEntity;
		this.opr = opr;
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		boolean res =user.getUserGroup().isPermissioned(entity, opr); 
		return res;
	}

}
