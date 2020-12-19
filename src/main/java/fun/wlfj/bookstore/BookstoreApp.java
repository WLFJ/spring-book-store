package fun.wlfj.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import fun.wlfj.bookstore.exceptionhandler.HandlerExceptionToViewResolver;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@MapperScan("fun.wlfj.bookstore.dao")
@SpringBootApplication
public class BookstoreApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BookstoreApp.class, args);
	}

	@Bean
    HandlerExceptionResolver customExceptionResolver () {
        return new HandlerExceptionToViewResolver();
    }

}
