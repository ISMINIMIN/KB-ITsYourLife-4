package book;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	public void insert(BookDto dto) {
		System.out.println("BookDao.insert() !!!");
	}

}
