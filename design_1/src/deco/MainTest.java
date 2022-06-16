package deco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;

/**
 * 데코레이션 패턴은 기본 뼈대(클래스) 유지하되 이후 필요한 기능을 확장 시켜서 사용한다.
 * new Buffered..(new InputStreamReader(new InputStream))
 *
 */

public class MainTest {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		// 가장 기본적인 데코레이션 패턴
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String ln = bf.readLine();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ln);
		bw.flush();

		
		
		
		
		
//		ICar audi = new Audi(10_000_000);	
//		ICar a3 = new Audi_A3(audi, "A3", 30_000_000);
//		a3.showPrice();
//		
	}
	
}
