package com.test.demo.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class TestRequest {

	private List<Integer> input;

	public List<Integer> getInput() {
		return input;
	}

	public void setInput(List<Integer> input) {
		this.input = input;
	}
	
}
