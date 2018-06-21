package com.briup.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		/**
		 * 
		Set<Object> set = new HashSet<Object>();
		set.add(3);
		set.add(true);
		set.add(Math.random());
		set.add("hello world");
		for (Object object : set) {
			System.out.println(object);
		}
		 */
		/*List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("hello world");
		list.add("hello");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "¼«ÐÇ");
		map.put(2, "hello");
		map.put(3, "jiyuan");
		Set<Entry<Integer, String>> set = map.entrySet();
		for (Object entry : set) {
			System.out.println(entry);
		}
	}
}
