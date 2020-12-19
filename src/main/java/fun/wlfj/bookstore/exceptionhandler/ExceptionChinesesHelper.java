package fun.wlfj.bookstore.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class ExceptionChinesesHelper {
	
	private static final Map<String, String> db = new HashMap<String, String>() {{
		put("class java.lang.NumberFormatException", "数值转换错误。请检查是否有字段填入非数字内容或没有填写。");
		put("class java.io.EOFException", "数据库连接异常中断。");
		put("class java.net.ConnectException", "数据库连接异常。");
		put("class java.sql.SQLNonTransientConnectionException", "服务出现严重错误，请联系管理员。");
		put("class java.sql.SQLIntegrityConstraintViolationException", "有字段没有填写，请检查！");
		put("class java.lang.NullPointerException", "无法查询到对象。");
	}};

	public static String getMsg(String errorMsg) {
		return db.getOrDefault(errorMsg, errorMsg);
	}
	
}
