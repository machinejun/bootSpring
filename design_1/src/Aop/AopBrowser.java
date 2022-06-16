package Aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrowser implements IBrowser {

	// Aop의 특징 중 하나는 전처리, 후처리 이다.

	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;

	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}

	@Override
	public Html show() {
		before.run();

		if (html == null) {
			System.out.println("AopBrowser html loading from :" + url);
			html = new Html(url);
			// 너무 빠르게 처리 된다.
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		after.run();
		System.out.println("AopBrowser html cache : " + url);
		return null;
	}

}
