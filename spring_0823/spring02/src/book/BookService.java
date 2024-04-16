package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired // Annotation
	BookDao dao;
	
	public BookService() {

	}
	
	public BookService(BookDao dao) { // XML - 생성자 주입
		this.dao = dao;
	}
	
	public void setDao(BookDao dao) { // XML - Setter 주입
		this.dao = dao;
	}
	
	public void insert(BookDto dto) {
		dao.insert(dto);
	}
}
