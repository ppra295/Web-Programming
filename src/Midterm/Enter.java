package Midterm;

public class Enter {
	
	int id;
	String info;
	boolean done;
	public Enter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enter(int id, String info, boolean done) {
		super();
		this.id = id;
		this.info = info;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	

}
