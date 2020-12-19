package fun.wlfj.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.entity.User;
import fun.wlfj.bookstore.service.TypeService;

@Controller
@RestController
@RequestMapping("/types")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/{typeId}")
	public ModelAndView showTypeBooks(@PathVariable("typeId") int typeId, ModelAndView mv, HttpSession session) {
		BookType type = typeService.getTypeById(typeId);
		mv.setViewName("booksDetail");
		mv.addObject("wyw1813004316books", type.getBooks());
		mv.addObject("currentType", type);
		mv.addObject("types", typeService.getTypes());
		mv.addObject("types", typeService.getTypes());
		User user = (User)session.getAttribute("user");
		mv.addObject("book_r", user.getUserGroup().isPermissioned(new Book(), "r"));
		mv.addObject("book_w", user.getUserGroup().isPermissioned(new Book(), "w"));
		mv.addObject("book_x", user.getUserGroup().isPermissioned(new Book(), "x"));
		mv.addObject("type_r", user.getUserGroup().isPermissioned(new BookType(), "r"));
		mv.addObject("type_w", user.getUserGroup().isPermissioned(new BookType(), "w"));
		mv.addObject("type_x", user.getUserGroup().isPermissioned(new BookType(), "x"));
		mv.addObject("user_r", user.getUserGroup().isPermissioned(new User(), "r"));
		mv.addObject("user_w", user.getUserGroup().isPermissioned(new User(), "w"));
		mv.addObject("user_x", user.getUserGroup().isPermissioned(new User(), "x"));
		return mv;
	}
	
	@RequestMapping("/manage")
	public ModelAndView showManageTypes(ModelAndView mv) {
		mv.addObject("types", typeService.getTypes());
		mv.setViewName("manage_types");
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addType(String name, String description, ModelAndView mv) {
		typeService.addType(new BookType(name, description));
		mv.setViewName("redirect:manage");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteType(@PathVariable("id") Integer id, ModelAndView mv) {
		typeService.deleteType(id);
		mv.setViewName("redirect:../manage");
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView updateType(Integer id, String name, String description, ModelAndView mv) {
		typeService.updateType(new BookType(id, name, description));
		mv.setViewName("redirect:./manage");
		return mv;
	}

}
