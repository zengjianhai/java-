package PipeStreamTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.List;



public class PipeTest {

	public static void main(String[] args) {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		try {
			pis.connect(pos);
			PipeOut pipeOut = new PipeOut(pos, "Êä³ö");
			PipeIn pipeIn = new PipeIn(pis, "µÃµ½");
			pipeOut.start();
			pipeIn.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class PipeOut extends Thread{
	PipedOutputStream pos = null;
	public PipeOut(PipedOutputStream pos,String name){
		this.pos = pos;
		this.setName(name);
	}
	@Override
	public void run() {
		List<Student> list = (List<Student>) new GetCollection().gather("src/test");
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(pos);
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class PipeIn extends Thread{
	PipedInputStream pis = null;
	public PipeIn(PipedInputStream pis,String name){
		this.pis = pis;
		this.setName(name);
	}
	@Override
	public void run() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(pis);
			List<Student> list = (List<Student>) ois.readObject();
			for (Student bidr : list) {
				System.out.println(bidr);
			}
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}