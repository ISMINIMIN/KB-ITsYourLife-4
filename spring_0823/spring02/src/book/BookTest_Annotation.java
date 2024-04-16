package book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookTest_Annotation {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BookContext.class);
		BookService bs = context.getBean(BookService.class);
		BookDto dto = new BookDto();
		bs.insert(dto);
	}
}
