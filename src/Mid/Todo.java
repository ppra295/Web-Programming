package Mid;



public class Todo {
	
	static int count = 0;
	
	int id;
	String description;
	boolean isDone;
	
	public Todo(String description) {
		super();
		this.id = count++;
		this.description = description;
		this.isDone = false;
	}

	public int getId() {
		return id;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
