package com.boot.data;

public class QuizDto {

	private String category;
	private String title;
	private Integer noOfQuestions;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(Integer noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	
}
