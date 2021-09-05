package com.test.demo.payload.response;

import lombok.Data;

@Data
public class ResultResponse {

	private int sum;
	
	private int average;
	
	private int greaterThanAverage;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getGreaterThanAverage() {
		return greaterThanAverage;
	}

	public void setGreaterThanAverage(int greaterThanAverage) {
		this.greaterThanAverage = greaterThanAverage;
	}
	
	
}
