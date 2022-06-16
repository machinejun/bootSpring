package proxy;

public class BrowserProxy implements IBrowser{
	
	private String url;
	private Html html;
	
	
	
	
	public BrowserProxy(String url) {
		this.url = url;
	}




	@Override
	public Html show() {
		// 여기에 캐싱 기능을 만들어 보자
		if(html == null) {
			System.out.println("Browser Proxy Loading html from : " + url);
			html = new Html(url);
		}
		System.out.println("Browser proxy use cache html : " + url);
		return html;
	}

}
