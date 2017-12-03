package Midterm;

public class Todo {
	int id;
	String Description;
	boolean done;
	public Todo(int id, String description, boolean done) {
		super();
		this.id = id;
		Description = description;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
}
	


