package com.briup.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	private static int N = 50000;
	private static List<Integer> val;
	static{
		Integer[] iarray = new Integer[N];
		val = Arrays.asList(iarray);
		for(int i = 0,count = 0;i<N;i++){
			iarray[i] = count;
			count += (int)(Math.random()*100)+1; 
		}
	}
	public static Long getTime(List list){
		Long start = System.currentTimeMillis();
//		for(int i = 0;i<list.size();i++){
//			list.get(i);
//		}
		Object o = new Object();
		for (int i = 0; i < N; i++) {
			list.add(0,o);
		}
 		return System.currentTimeMillis()-start;
	}
	public static void main(String[] args) {
		System.out.println(new ListTest().getTime(new ArrayList<Integer>(val)));
		System.out.println(new ListTest().getTime(new LinkedList<Integer>(val)));

	}

}
