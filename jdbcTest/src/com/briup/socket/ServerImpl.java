package com.briup.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

import com.briup.gather.Gather;
import com.briup.bean.BIDR;
import com.briup.xml.ConfigurationImpl;
import com.briup.xml.WossModuleInit;

public class ServerImpl implements WossModuleInit{

	private static int port;
	private static ConfigurationImpl con;
	static{
		con = new ConfigurationImpl();
	}
	@Override
	public void init(Properties properties) {

		port=Integer.parseInt(properties.getProperty("port"));
	}
	public void revice() {
		try {
			ServerSocket  ss=new ServerSocket(port);
			System.out.println("服务器已经打开");
			Socket socket=ss.accept();
			System.out.println("连接成功"+socket.getPort());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			List<BIDR> list=(List<BIDR>)ois.readObject();
			con.getDbStore().demo();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			con.getServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
