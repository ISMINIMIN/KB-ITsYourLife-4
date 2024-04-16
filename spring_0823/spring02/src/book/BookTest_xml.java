package book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest_xml {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookService bs = context.getBean(BookService.class);
		BookDto dto = new BookDto();
		bs.insert(dto);
	}
}
