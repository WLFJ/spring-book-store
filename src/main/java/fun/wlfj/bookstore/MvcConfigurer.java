package fun.wlfj.bookstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.entity.User;
import fun.wlfj.bookstore.interceptor.LoginCheckInterceptor;
import fun.wlfj.bookstore.interceptor.PermissionCheckInterceptor;


@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new LoginCheckInterceptor())
		.addPathPatterns("/detail")
		.addPathPatterns("/details")
		.addPathPatterns("/detail/json")
		.addPathPatterns("/showImg/*")
		.addPathPatterns("/delete")
		.addPathPatterns("/add")
		.addPathPatterns("/insert")
		.addPathPatterns("/modify")
		.addPathPatterns("/search")
		.addPathPatterns("/types/{typeId:[0-9]+}")
		.addPathPatterns("/types/insert")
		.addPathPatterns("/types/modify")
		.addPathPatterns("/types/add")
		.addPathPatterns("/types/delete/{typeId:[0-9]+}")
		.addPathPatterns("/types/update")
		.addPathPatterns("/types/manage")
		.addPathPatterns("/update")
		.addPathPatterns("/delete/{groupId:[0-9]+}")
		.addPathPatterns("/group/add")
		.addPathPatterns("/user/delete/{userId:[0-9]+}")
		.addPathPatterns("/user/update/{userId:[0-9]+}")
		.addPathPatterns("/manage");
		
		registry.addInterceptor(new PermissionCheckInterceptor(new Book(), "r"))
		.addPathPatterns("/detail")
		.addPathPatterns("/details")
		.addPathPatterns("/detail/json")
		.addPathPatterns("/showImg/*");
		registry.addInterceptor(new PermissionCheckInterceptor(new Book(), "w"))
		.addPathPatterns("/delete")
		.addPathPatterns("/add")
		.addPathPatterns("/insert")
		.addPathPatterns("/modify");
		registry.addInterceptor(new PermissionCheckInterceptor(new Book(), "x"))
		.addPathPatterns("/search");
		
		
		registry.addInterceptor(new PermissionCheckInterceptor(new BookType(), "r"))
		.addPathPatterns("/types/{typeId:[0-9]+}")
		.addPathPatterns("/types/insert")
		.addPathPatterns("/types/modify");
		registry.addInterceptor(new PermissionCheckInterceptor(new BookType(), "w"))
		.addPathPatterns("/types/add")
		.addPathPatterns("/types/delete/{typeId:[0-9]+}")
		.addPathPatterns("/types/update");
		registry.addInterceptor(new PermissionCheckInterceptor(new BookType(), "x"))
		.addPathPatterns("/types/manage");

		registry.addInterceptor(new PermissionCheckInterceptor(new User(), "w"))
		.addPathPatterns("/update")
		.addPathPatterns("/delete/{groupId:[0-9]+}")
		.addPathPatterns("/group/add")
		.addPathPatterns("/user/delete/{userId:[0-9]+}")
		.addPathPatterns("/user/update/{userId:[0-9]+}");
		registry.addInterceptor(new PermissionCheckInterceptor(new User(), "x"))
		.addPathPatterns("/manage");
		// 现在我们需要将相关url分类 可是一般就是一个啊
	}
}
