package fun.wlfj.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/error1")
	public String showError() throws Exception {
		throw new Error();
	}

}
