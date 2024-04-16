package simplecalc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"simplecalc"})
@EnableAspectJAutoProxy
public class SimpleCalcContext {

}
