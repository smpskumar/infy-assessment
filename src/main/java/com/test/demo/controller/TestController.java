package com.test.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.payload.request.TestRequest;
import com.test.demo.payload.response.ResultResponse;
import com.test.demo.payload.response.TestResponse;

@RestController
@RequestMapping("/api")
public class TestController {

	@PostMapping("/numberoperations")
	public ResponseEntity<?> numberOperations(@RequestBody TestRequest testRequest){	
		int sum=0,avg=0,avgOfGe=0;
		for(Integer in : testRequest.getInput()) {
			sum+=in;
		}		
		avg = sum / (testRequest.getInput().size());
		for(Integer in : testRequest.getInput()) {
			if(avg < in)
				avgOfGe = in;
		}
		TestResponse res = new TestResponse();			
		res.setStatus("SUCCESS");
		ResultResponse resultRes = new ResultResponse();
		resultRes.setSum(sum);
		resultRes.setAverage(avg);
		resultRes.setGreaterThanAverage(avgOfGe);
		res.setResults(resultRes);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
}
