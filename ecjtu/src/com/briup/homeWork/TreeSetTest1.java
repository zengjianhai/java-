package com.briup.homeWork;

import java.util.Comparator;
import java.util.TreeSet;


public class TreeSetTest1 {

	public static void main(String[] args) {
		StringComparator sc = new StringComparator();
		TreeSet<String> strs = new TreeSet<String>(sc);
		strs.add("HashSet");
		strs.add("ArrayList");
		strs.add("TreeMap");
		strs.add("HashMap");
		strs.add("TreeSet");
		strs.add("LinkedList");
		for (String string : strs) {
			System.out.println(string);
		}
	}

}
class StringComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String str1 = (String) o1;
		String str2 = (String) o2;
		if(str1.compareTo(str2)>0)return 1;
		else if(str1.compareTo(str2)<0)return -1;
		else return 0;
	}
}