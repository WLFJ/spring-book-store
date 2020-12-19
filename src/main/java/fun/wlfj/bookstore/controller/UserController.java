package fun.wlfj.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fun.wlfj.bookstore.entity.User;
import fun.wlfj.bookstore.entity.UserGroup;
import fun.wlfj.bookstore.service.UserGroupService;
import fun.wlfj.bookstore.service.UserService;

/**
 * 用户登陆的相关控制类
 * @author yves
 *
 */
@Controller
public class UserController {
	
	@Value("${yves.new-user-group}")
	private int newUserGroupId;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserGroupService userGroupService;

	@GetMapping("/login")
	public ModelAndView userLogin(@RequestParam(defaultValue="/") String from) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("from", from);
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping("/login")
	public RedirectView login(String username, String password, @RequestParam(defaultValue="/") String from, HttpServletRequest request) {
		User user = null;
		if((user = userService.userLogin(username, password)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogined", (Boolean)true);
			session.setAttribute("user", user);
			// 我们要支持跳转，这就需要参数支持了
			return new RedirectView(from);
		}else {
			return new RedirectView("login");
		}
	}
	
	@RequestMapping("/logout")
	public RedirectView logout(HttpServletRequest request) {
		request.getSession().setAttribute("isLogined", null);
		request.getSession().setAttribute("user", null);
		return new RedirectView("details");
	}
	
	@GetMapping("/register")
	public ModelAndView showRegister(ModelAndView mv) {
		mv.setViewName("register");
		return mv;
	}
	
	@PostMapping("/register")
	public RedirectView register(String username, String password) {
		User user = new User(username, password, userGroupService.getUserGroupById(newUserGroupId));
		userService.addUser(user);
		return new RedirectView("login");
	}
	
	@GetMapping("/manage")
	public ModelAndView showManage(ModelAndView mv) {
		mv.addObject("user_groups", userGroupService.getUserGroups());
		mv.setViewName("manage_users");
		return mv;
	}
	
	@PostMapping("/update")
	public RedirectView updateUserGroup(int id, String name, int bookp, int typep, int userp, HttpSession session) {
		User user = (User)session.getAttribute("user");
		UserGroup group = new UserGroup(id, name, bookp, typep, userp);
		userGroupService.updateUserGroup(group);
		session.setAttribute("user", userService.getUserById(user.getUserId()));
		return new RedirectView("manage");
	}
	
	@RequestMapping("/delete/{id}")
	public RedirectView deleteUserGroup(@PathVariable("id") Integer id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		userGroupService.deleteUserGroup(id);
		session.setAttribute("user", userService.getUserById(user.getUserId()));
		return new RedirectView("../manage");
	}

	@PostMapping("/group/add")
	public RedirectView addUserGroup(String name, int bookp, int typep, int userp) {
		UserGroup group = new UserGroup(name, bookp, typep, userp);
		userGroupService.addUserGroup(group);
		return new RedirectView("../manage");
	}
	
	@GetMapping("/user/delete/{id}")
	public RedirectView deleteUser(@PathVariable("id")int id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		userService.deleteUser(id);
		session.setAttribute("user", userService.getUserById(user.getUserId()));
		return new RedirectView("../../manage");
	}
	
	@GetMapping("/user/update/{id}")
	public ModelAndView showUpdateUser(@PathVariable("id") int id, ModelAndView mv) {
		mv.addObject("user", userService.getUserById(id));
		mv.addObject("groups", userGroupService.getUserGroups());
		mv.setViewName("update_user");
		return mv;
	}
	
	@PostMapping("/user/update/{id}")
	public RedirectView updateUser(@PathVariable("id") int id, String username, String password, int group, HttpSession session) {
		User user = (User)session.getAttribute("user");
		User newUser = new User(id, username, password, userGroupService.getUserGroupById(group));
		userService.updateUser(newUser);
		session.setAttribute("user", userService.getUserById(user.getUserId()));
		return new RedirectView("../../manage");
	}
}
