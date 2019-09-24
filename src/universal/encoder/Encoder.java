package universal.encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Encoder {

	public static void main(String[] args) throws IOException {
		
		System.out.println("第一种方法效果如下：");
		
		FileInputStream  fis = new FileInputStream("newTheme.txt");
		
		Charset charset= Charset.forName("UTF-8");
		
		byte[]b = new byte[1024];
		
		int length = -1;
		
		while((length = fis.read(b))!=-1) {
			
			System.out.println(new String(b,0,length,charset));
		}
		
		fis.close();
		
		
		System.out.println("\n第二种方法效果如下：");
		
		FileReader fr = new FileReader("newTheme.txt");
		
		char[] chars = new char[1024];
		
		int length1 = -1;
		
		while((length1 = fr.read(chars)) != -1){
			
			String string= new String(chars, 0, length1);
			
			byte[]b1 = string.getBytes();
			
			System.out.println(new String(b1,0,b1.length,charset));
		}
		
		fr.close();
		
		System.out.println("\n第三种方法效果如下：");
		
		File file  = new File("newTheme.txt");
		
		URI uri = file.toURI();
		
		Path path = Paths.get(uri);
		
		List<String>s1 = Files.readAllLines(path,charset);
		
		for(String s:s1) {
			
			System.out.println(s);
		}
		
		
		
		System.out.println("\n第四种方法如下：");
		
		InputStream in = new FileInputStream("newTheme.txt");
		
		InputStreamReader isr= new InputStreamReader(in,charset);	
		
		char []cha = new char[1024];
		
		int len = isr.read(cha);
		
		System.out.println(new String(cha,0,len));
		
		isr.close();
	}
}
