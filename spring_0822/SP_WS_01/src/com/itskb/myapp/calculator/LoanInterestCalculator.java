package com.itskb.myapp.calculator;

import org.springframework.stereotype.Component;

@Component("loanCalc")
public class LoanInterestCalculator implements InterestCalculator {

	@Override
	public double calculate(int amount) {
		System.out.println("LoanInterestCalculator - calculate()");
		return amount * 0.0525;
	}

}
