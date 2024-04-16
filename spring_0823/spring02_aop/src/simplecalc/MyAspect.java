package simplecalc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Before("execution(* SimpleCalc.*(..))")
	public void printBefore() {
		System.out.println("계산 전");
	}
}
