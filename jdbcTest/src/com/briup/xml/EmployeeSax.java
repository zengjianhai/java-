package com.briup.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeSax {
	static List<Employee> list;
	static MyEmployee myEmployee;

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		myEmployee = new MyEmployee();
		try {
			SAXParser parser = factory.newSAXParser();
			File file = new File("src/com/briup/xml/employee.xml");
			parser.parse(file, myEmployee);
			list = myEmployee.getList();
			for (Employee employee : list) {
				System.out.println("list=================" + employee);
			}
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class MyEmployee extends DefaultHandler {
	private Employee employee;
	private List<Employee> list;
	private String empName;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String strs = new String(ch, start, length);
		System.out.print(strs);
		switch (empName) {
		case "name":
			employee.setName(strs);
			break;
		case "age":
			employee.setAge(Integer.parseInt(strs));
			break;
		case "gender":
			employee.setGender(strs);
			break;
		case "salary":
			employee.setSalary(Integer.parseInt(strs));
			break;
		}
		empName = "";
	}

	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		empName = qName;
		if (qName.equals("employee")) {
			employee = new Employee();
		}
		for (int i = 0; i < attributes.getLength(); i++) {
			String value = attributes.getValue(i);
			switch (attributes.getQName(i)) {
			case "id":
				employee.setId(Integer.parseInt(value));
				break;
			case "depName":
				employee.setDepName(value);
				break;
			}

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (empName != null) {
			if ("employee".equals(qName)) {
				list.add(employee);
			}
		}
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
}
