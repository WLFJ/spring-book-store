package fun.wlfj.bookstore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.entity.User;
import fun.wlfj.bookstore.query.BookQuery;
import fun.wlfj.bookstore.service.BookService;
import fun.wlfj.bookstore.service.TypeService;

@Controller
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private TypeService typeService;
	
	@Value("${yves.upload.path}")
	private String IMG_PATH;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("redirect:details");
		return mv;
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public ModelAndView showBookDetail(Integer wyw1813004316id, ModelAndView mv, HttpSession session) throws Exception{
		Book book = bookService.getBookById(wyw1813004316id);
		mv.addObject("book", book);
		mv.setViewName("detail");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("wyw1813004316id") Integer id, ModelAndView mv) {
		bookService.deleteBook(id);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView showAddBook() {
		ModelAndView wyw1813004316mv = new ModelAndView();
		wyw1813004316mv.setViewName("addBook");
		wyw1813004316mv.addObject("types", typeService.getTypes());
		return wyw1813004316mv;
	}
	
	@PostMapping("/insert")
    public RedirectView insertBook_POST(@RequestParam("name") String name, @RequestParam("price") double price, @RequestParam("img") MultipartFile imgFile, String detail, Integer type){
		String imgName = null;
		if(!imgFile.isEmpty()) {
			imgName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			try {
				FileCopyUtils.copy(imgFile.getInputStream(), new FileOutputStream(IMG_PATH + imgName));
			} catch (Exception e) {

			}
		}

//	public Book(String bookName, BookType bookType, Double bookPrice, String bookCover) {
		Book book = new Book(name, typeService.getTypeById(type), price, imgName, detail);
		bookService.addBook(book);
		return new RedirectView("details");
    }
	
	@RequestMapping("/details")
	public ModelAndView getBooksDetail_JSP(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("wyw1813004316books", bookService.getBooks());
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
		mv.setViewName("booksDetail");
		return mv;
	}
	
	@RequestMapping("/detail/json")
	public Object getDetailsByJson(Integer id) throws Exception {
		Map<String, String> map = new HashMap<>();
		Book book = bookService.getBookById(id);
		map.put("detail", book.getBookDetail());
		return map;
	}
	
	@RequestMapping("/showImg/{fileName}")
	public void showImg(@PathVariable("fileName") String fileName, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment;fileName=" + "awsome");
		File imgFile = new File(IMG_PATH + fileName);
        responseFile(response, imgFile);	
	}
	
	@GetMapping("/modify")
	public ModelAndView showUpdate(@RequestParam("wyw1813004316id") Integer id, ModelAndView mv) throws Exception {
		Book book = bookService.getBookById(id);
		mv.addObject("book", book);
		mv.addObject("types", typeService.getTypes());
		mv.setViewName("updateBook");
		return mv;
	}
	
	@GetMapping("/search")
	public ModelAndView showSearch(ModelAndView mv) {
		mv.setViewName("search");
		return mv;
	}
	
	@PostMapping("/search")
	public ModelAndView search(
			@RequestParam(required=false) String name, 
			@RequestParam(required=false) String type, 
			@RequestParam(required=false) Double price_low, 
			@RequestParam(required=false) Double price_high, 
			@RequestParam(required=false) String detail, 
			ModelAndView mv) throws Exception {
		mv.setViewName("booksDetail");
		BookQuery query = new BookQuery(name, type, detail);
		query.setBookPrice_low(price_low);
		query.setBookPrice_high(price_high);
		mv.addObject("wyw1813004316books", bookService.queryBooks(query));
		return mv;
	}
	
	@PostMapping("/simpleSearch")
	public ModelAndView simpleSearch(@RequestParam(required=false) String keyword, ModelAndView mv) {
		BookQuery query = new BookQuery();
		query.setBookName(keyword);
		mv.addObject("wyw1813004316books", bookService.queryBooks(query));
		mv.setViewName("booksDetail");
		return mv;
	}

	@PostMapping("/modify")
	public ModelAndView updateBook(int id, String name, Double price, @RequestParam("img") MultipartFile imgFile, String detail, ModelAndView mv, int type) throws Exception{
		Book book = bookService.getBookById(id);
		book.setBookName(name);
		book.setBookPrice(price);
		book.setBookDetail(detail);
		book.setBookType(typeService.getTypeById(type));
		if(!imgFile.isEmpty()) {
			String imgName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			try {
				FileCopyUtils.copy(imgFile.getInputStream(), new FileOutputStream(IMG_PATH + imgName));
			} catch (Exception e) {

			}
			book.setBookCover(imgName);
		}
		bookService.updateBook(book);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	/**
     * 响应输出图片文件
     * @param response
     * @param imgFile
     */
    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
