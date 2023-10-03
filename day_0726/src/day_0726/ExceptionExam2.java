package day_0726;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam2 {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("poem.txt");
			int c;
			while((c = fileReader.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
			System.out.println("파일 읽기 종료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("파일 없음");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("입출력 오류");
		} finally {
			try {
				if(fileReader != null) fileReader.close();
			} catch (IOException e) {
			}
		}
	}
}
