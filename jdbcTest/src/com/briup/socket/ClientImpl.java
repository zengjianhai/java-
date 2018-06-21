package com.briup.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

import com.briup.bean.BIDR;
import com.briup.gather.Gather;
import com.briup.xml.ConfigurationImpl;
import com.briup.xml.WossModuleInit;

public class ClientImpl implements WossModuleInit{

	private String ip;
	private int post;
	private static ConfigurationImpl con;
	static{
		con = new ConfigurationImpl();
	}
	@Override
	public void init(Properties properties) {
		ip=properties.getProperty("ip");
		post=Integer.parseInt(properties.getProperty("port"));
	}
	public  void send() {
		try {
			System.out.println("等待客户端连接");
			Socket socket=new Socket(ip,post);
			OutputStream out = socket.getOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(out);
            List<BIDR> list=(List<BIDR>)new Gather().gather();
            oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args){
		try {
			con.getClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
