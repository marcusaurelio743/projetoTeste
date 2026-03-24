package projetoTeste.model;

public class Greetening {
	private Long id;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Greetening() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greetening(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

}
