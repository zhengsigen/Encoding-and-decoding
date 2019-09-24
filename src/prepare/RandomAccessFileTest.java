package prepare;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("OutputStreamWrite.txt","r");
		
		raf.seek(2);

		byte []buffer=new byte[1000]; 
		
        int len=0; 
        
        while((len=raf.read(buffer, 0, 1000))!=-1){ 
        	
            System.out.println(new String(buffer,0,len)); 
            
            
            
        } 
		
		raf.close();
	}
}
