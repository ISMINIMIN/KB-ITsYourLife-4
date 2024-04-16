package mulcam.kb04.boot0831;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mulcam.kb04.boot0831.ifs.Greet;

@SpringBootApplication
public class Boot0831Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot0831Application.class, args).getBean(Boot0831Application.class).execute();
	}
	
	@Autowired
	private Greet greet;
	
	public void execute() {
		System.out.println(greet.greeting());
	}

}
