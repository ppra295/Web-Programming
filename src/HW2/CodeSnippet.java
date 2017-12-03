package HW2;

public class CodeSnippet {
	int id;
	String title,languages,code;
	public CodeSnippet(int id,String title, String languages, String code) {
		super();
		this.id =id;
		this.title = title;
		this.languages = languages;
		this.code = code;
		id++;
		
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
