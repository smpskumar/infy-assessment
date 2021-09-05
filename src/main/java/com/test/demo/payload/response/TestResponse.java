package com.test.demo.payload.response;

import lombok.Data;

@Data
public class TestResponse {

	private String status;
	
	private ResultResponse results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResultResponse getResults() {
		return results;
	}

	public void setResults(ResultResponse results) {
		this.results = results;
	}
	
	
}
