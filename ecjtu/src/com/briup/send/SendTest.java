package com.briup.send;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.List;

import com.briup.bean.BIDR;
import com.briup.gather.Gather;

public class SendTest {

	public static void main(String[] args){
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();
		try {
			//管道流要进行连接
			pis.connect(pipedOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Sender(pipedOutputStream, "输入成功").start();;
		new Fecher(pis, "接收成功").start();;
	}
}

class Sender extends Thread {
	PipedOutputStream pos = null;

	public Sender(PipedOutputStream pos, String name) {
		this.pos = pos;
		setName(name);
	}

	@Override
	public void run() {
		System.out.println("========="+getName());
		List<BIDR> list = (List<BIDR>) new Gather().gather("src/radwtmp_test");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(pos);
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (IOException e) {
		}
	}
}

class Fecher extends Thread {
	PipedInputStream pis = null;

	public Fecher(PipedInputStream pis, String name) {
		this.pis = pis;
		setName(name);
	}

	@Override
	public void run() {
		System.out.println(""+getName());
		try {
			ObjectInputStream ois = new ObjectInputStream(pis);
			List<BIDR> list = (List<BIDR>) ois.readObject();
			for (BIDR bidr : list) {
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