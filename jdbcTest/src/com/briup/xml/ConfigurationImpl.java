package com.briup.xml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.gather.Gather;
import com.briup.jdbc.DBImple;
import com.briup.socket.ClientImpl;
import com.briup.socket.ServerImpl;


public class ConfigurationImpl implements Configuration {

	private Map<String, WossModuleInit> beans;

	public ConfigurationImpl() {
		this("src/src.xml");
	}

	public static void main(String[] name) {
		new ConfigurationImpl();
	}

	public ConfigurationImpl(String path) {
		/*
		 * 解析配置文件 读取内容放入到map对象中 同时将各自类中的子标签内容放置到properties对象中
		 */
		beans = new HashMap<String, WossModuleInit>();
		SAXReader saxReader = new SAXReader();
		File file = new File(path);
		try {
			Document doc = saxReader.read(file);
			Element element = doc.getRootElement();
			List<Element> list = element.elements();
			for (Element element2 : list) {
				String name = element2.getName();
				String clName = element2.attributeValue("class");
				WossModuleInit cls = (WossModuleInit) Class.forName(clName).newInstance();
				beans.put(name, cls);
				Properties pro = new Properties();
				List<Element> list2= element2.elements();
				for (Element element3 : list2) {
					String eName = element3.getName();
					String value = element3.getText();
					pro.put(eName, value);
					System.out.println(eName);
				}
				cls.init(pro);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ServerImpl getServer() throws Exception {
		// TODO Auto-generated method stub
		return (ServerImpl) beans.get("server");
	}

	@Override
	public DBImple getDbStore() throws Exception {
		// TODO Auto-generated method stub
		return (DBImple) beans.get("dbstore");
	}

	@Override
	public ClientImpl getClient() throws Exception {
		// TODO Auto-generated method stub
		return (ClientImpl) beans.get("client");
	}

	@Override
	public Gather getGather() throws Exception {
		// TODO Auto-generated method stub
		return (Gather) beans.get("gather");
	}

}
