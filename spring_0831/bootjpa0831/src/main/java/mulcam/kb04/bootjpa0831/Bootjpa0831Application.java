package mulcam.kb04.bootjpa0831;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;

import mulcam.kb04.bootjpa0831.entity.Board;
import mulcam.kb04.bootjpa0831.ifs.BoardRepository;

@SpringBootApplication
public class Bootjpa0831Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Bootjpa0831Application.class, args);
		context.getBean(Bootjpa0831Application.class).execute();
	}
	
	@Autowired
	private BoardRepository repository;
	
	public void execute() {
//		printCount();
//		insertBoard();
//		printCount();
		printAll();
	}

	private void printAll() {
		List<Board> list = repository.findAll(Sort.by(Sort.Direction.DESC, "no"));
		for(Board board : list) {
			System.out.println(board);
		}
	}

	private void insertBoard() {
		Board board = new Board();
		board.setTitle("부트로 등록");
		board.setWriter("부트01");
		board.setContent("부트로 등록");
		board.setRegdate(new Date());
		repository.save(board);
		System.out.println("등록완료");
	}

	private void printCount() {
		long count = repository.count();
		System.out.println("count : " + count);
	}

}
