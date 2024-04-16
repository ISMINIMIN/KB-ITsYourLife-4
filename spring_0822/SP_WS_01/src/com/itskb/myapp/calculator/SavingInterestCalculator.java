package com.itskb.myapp.calculator;

import org.springframework.stereotype.Component;

@Component("savingCalc")
public class SavingInterestCalculator implements InterestCalculator {

	@Override
	public double calculate(int amount) {
		System.out.println("SavingInterestCalculator - calculate()");
		return amount * 0.0334;
	}

}
