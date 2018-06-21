package com.briup.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class DiskSax {
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			SAXParser parser = factory.newSAXParser();
			File file = new File("src/com/briup/xml/disk.xml");
			parser.parse(file, new MyHandler());
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class MyHandler extends DefaultHandler {
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String strs = new String(ch,start,length);
		System.out.print(strs);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName);
		for(int i = 0;i<attributes.getLength();i++){
			String name = attributes.getQName(i);
			String value = attributes.getValue(i);
			System.out.print(" "+name+"='"+value+ "'");
		}
		System.out.print(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</"+qName+">");
	}
}