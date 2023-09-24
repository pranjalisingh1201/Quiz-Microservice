package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.dao.QuizDao;
import com.boot.data.QuestionWrapper;
import com.boot.data.Quiz;
import com.boot.data.Response;
import com.boot.iface.QuizInterface;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
		// TODO Auto-generated method stub
		try {
		List<Integer> questions = quizInterface.getQuestions(category, noOfQuestions).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new  ResponseEntity<>("FAILED",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
		// TODO Auto-generated method stubn
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> Id = quiz.getQuestions();
		List<QuestionWrapper> question = quizInterface.getQuestions(Id).getBody();
		return new ResponseEntity<>(question,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Integer score = quizInterface.getScore(responses).getBody();
		return new ResponseEntity<>(score,HttpStatus.OK);
	}

}
