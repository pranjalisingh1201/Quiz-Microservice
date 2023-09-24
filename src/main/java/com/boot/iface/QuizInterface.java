package com.boot.iface;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.data.QuestionWrapper;
import com.boot.data.Response;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestions(@RequestParam("category") String category, @RequestParam("noOfQuestions") int noOfQuestions);
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> Id);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
