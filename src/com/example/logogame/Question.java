package com.example.logogame;

public class Question {
	String filename, answer2, answer, hint;

	public Question(String an, String an2, String file, String h) {
		this.filename = file;
		this.answer2 = an2;
		this.answer = an;
		this.hint = h;
	}
}
