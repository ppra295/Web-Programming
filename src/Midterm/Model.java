package Midterm;

public class Model {
	
	
	
	String name;
	int question, correct, incorrect;
	
	
	public Model(String name) {
		super();
		this.name = name;
	}
	
	public void incrementCorrect(){
		this.correct++;
		this.question++;
	}
	
	public void incrementInCorrect(){
		this.incorrect++;
		this.question++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	
	
}
