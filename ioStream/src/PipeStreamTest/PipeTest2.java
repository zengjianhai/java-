package PipeStreamTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * �ܵ������ܵ��������һ���߳���д�����ݣ���������һ���߳��ж�������
 * @author xunfeng
 *
 */
public class PipeTest2 {

	public static void main(String[] args) {
		PipedOutputStream pos=new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();
		try {
			pos.connect(pis);
			new PipeOutTest(pos, "�ܵ������").start();
			new PipeInTest(pis, "�ܵ�������").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
class PipeOutTest extends Thread{
	PipedOutputStream pos=null;
	public PipeOutTest(PipedOutputStream pos,String name) {
		this.pos = pos;
		setName(name);
	}
	@Override
	public void run() {
		BufferedOutputStream bos = new BufferedOutputStream(pos);
		String str = "zengjianhai";
		byte[] bs = str.getBytes();
		try {
			bos.write(bs);
			bos.flush();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class PipeInTest extends Thread{
	PipedInputStream pis = null;
	public PipeInTest(PipedInputStream pis,String name){
		this.pis = pis;
		setName(name);
	}
	
	@Override
	public void run() {
		BufferedInputStream bis = new BufferedInputStream(pis);
		int value = 0;
		try {
			byte[] bs = new byte[bis.available()];
			while ((value = pis.read(bs))!=-1) {
				System.out.println(new String(bs));
			}
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}