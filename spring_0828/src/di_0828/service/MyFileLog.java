package di_0828.service;

import org.springframework.stereotype.Component;

@Component
public class MyFileLog extends MyLog {

	public void log(String string) {
		System.out.println("ÆÄÀÏ:" + string);
	}

}
