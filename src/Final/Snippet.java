package Final;

public class Snippet {
	int id;
	String title, description, language, codeSnippet;
	
	public Snippet(int id, String title, String description, String language, String codeSnippet) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.codeSnippet = codeSnippet;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCodeSnippet() {
		return codeSnippet;
	}

	public void setCodeSnippet(String codeSnippet) {
		this.codeSnippet = codeSnippet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
