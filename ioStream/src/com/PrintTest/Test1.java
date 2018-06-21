package com.PrintTest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test1 {

	public static void main(String[] args) {
		FileWriter fWriter = null;
		PrintWriter pWriter = null;
		try {
			fWriter = new FileWriter("src/test3",true);
			pWriter = new PrintWriter(fWriter,true);
			pWriter.println("love you");
			pWriter.write("√Ùer");
			pWriter.println("love you");
//			pWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
