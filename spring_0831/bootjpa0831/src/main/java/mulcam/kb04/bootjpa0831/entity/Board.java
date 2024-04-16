package mulcam.kb04.bootjpa0831.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_SEQ")
    @SequenceGenerator(sequenceName = "board_SEQ", allocationSize = 1, name = "board_SEQ")
	private int no;
	private String title, writer, content;
	private Date regdate;
	
	public Board() {
		
	}

	public Board(int no, String title, String writer, String content, Date regdate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate=" + regdate;
	}
	
}
