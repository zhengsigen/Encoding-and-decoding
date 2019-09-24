package prepare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class PrepareTest {

	public static void main(String[] args) throws IOException {
		
		//Ԥϰ  InputStreamReader  and   OutputStreamWriter
		
		InputStream in = new FileInputStream("newTheme.txt");
		
		Charset charset = Charset.forName("UTF-8");
		
		InputStreamReader isr= new InputStreamReader(in,charset);	
		
		char []cha = new char[1024];
		
		int len = isr.read(cha);
		
		System.out.println(new String(cha,0,len));
		
		String data = new String(cha,0,len);
		
		Charset charset1 = Charset.forName("GBK");
		
		OutputStream ou = new FileOutputStream("OutputStreamWrite.txt");
		
		OutputStreamWriter osw = new OutputStreamWriter(ou, charset1);
		
		osw.write(data);
		
		osw.close();
		
		isr.close();
		

		

	}
}
