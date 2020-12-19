package fun.wlfj.bookstore.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class HandlerExceptionToViewResolver implements HandlerExceptionResolver {
	
	@Autowired
	private ExceptionChinesesHelper helper;

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
    	Throwable exception = ex;
    	while(exception.getCause() != null) {
    		exception = exception.getCause();
    	}
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("error_page");
    	//mv.addObject("error_cause", helper.getMsg(exception.getClass().toString()));
    	mv.addObject("error_cause", ex.toString());
    	return mv;
    }
}
