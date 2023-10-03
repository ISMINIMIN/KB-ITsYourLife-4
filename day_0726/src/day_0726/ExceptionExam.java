package day_0726;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam {
	public static void main(String[] args) {
		try {
			readFile();
			System.out.println("파일 처리 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("파일 처리 실패");
		}
	}

	private static void readFile() throws IOException {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("poem.txt");
			int c;
			while ((c = fileReader.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();
			System.out.println("파일 읽기 종료");
		} finally {
			if(fileReader != null) fileReader.close();
		}
	}
}
