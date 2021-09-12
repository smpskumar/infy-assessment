package com.test.demo.controller;

import java.util.stream.Collectors;

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
//		int sum=0,avg=0,avgOfGe=0;
//		for(Integer in : testRequest.getInput()) {
//			sum+=in;
//		}	
//		testRequest.getInput().stream().
//		testRequest.getInput().forEach(in->{
//			sum+=in;
//		});
		Long sum = testRequest.getInput().stream().collect(Collectors.summarizingInt(in->in)).getSum();
		Long avg = sum / (testRequest.getInput().size());
		Long avgOfGe=0L;
		for(Integer in : testRequest.getInput()) {
			if(avg < in)
				avgOfGe = in.longValue();
		}
		TestResponse res = new TestResponse();			
		res.setStatus("SUCCESS");
		ResultResponse resultRes = new ResultResponse();
		resultRes.setSum(sum.intValue());
		resultRes.setAverage(avg.intValue());
		resultRes.setGreaterThanAverage(avgOfGe.intValue());
		res.setResults(resultRes);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
//	studList.stream().collect(Collectors.maxBy(s->s.getAge())).getMax();
//	
//	studList.stream().map(s->s.getName()+" , ").collect(Collectors.toString());
//	
//	studdList.stream().supplier(s:: s.getName().toUpperCase()).collect(Collectors.toList());
	
//	studList.stream().filter(s->s.getName().equals("jaish")).findFirst().collect(Collectors.toList());
//	
//	studList.stream().filter(s->s.getAge()>30).collect(Collectors.toList());
//	
//	studList.stream().sorted(Comparator.comparing(s->s.getAge()).reversed()).collect(Collectors.toList())
	
//	studList.stream().collect(Collectors.groupingBy(s->s.getAge())).summarizedInt(s->s.getAge()).collect(Collectors.toLong());
}
