package proxy;

public class Browser implements IBrowser{
	
	private String url;
	
	
	
	
	public Browser(String url) {
		this.url = url;
	}


	@Override
	public Html show() {
		System.out.println("Browser loading html from : " + url);
		return new Html(url);
		// 브라우저에서 어떤 페이즈를 본다라고 할 때 매번 새로운 html 파일을 만들어서 
		// 클라이언트에게 내려주는 형태
	}

}
