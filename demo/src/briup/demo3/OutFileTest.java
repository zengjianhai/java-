package briup.demo3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutFileTest {

	public static void main(String[] args) {
		PrintWriter printWriter = null;
		FileWriter fileWriter = null;
		String string = "src/briup/demo3/q.txt";
		
		try {
			fileWriter = new FileWriter(string);
			printWriter = new PrintWriter(fileWriter);
			for(int i = 0;i<10;i++){
				printWriter.println("i:\t"+i);
			}
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(printWriter!=null)
				printWriter.close();
		}
	}

}
