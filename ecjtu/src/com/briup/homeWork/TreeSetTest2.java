package com.briup.homeWork;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {

	public static void main(String[] args) {
		IntComparator ic = new IntComparator();
		TreeSet<Integer> ts = new TreeSet<Integer>(ic);
		for(int i =1;i<=10;i++){
			ts.add(i);
		}
		for (Integer integer : ts) {
			System.out.println(integer);
		}
	}

}

class IntComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Integer itg1 = (Integer) o1;
		Integer itg2 = (Integer) o2;
		if(itg1%2!=0&&itg2%2!=0){
			//奇数按升序排
			if(itg1<itg2)return -1;
			else if(itg1>itg2)return 1;
			else return 0;
		}else if(itg1%2==0&&itg2%2==0){
			//偶数按降序排
			if(itg1<itg2)return 1;
			else if(itg1>itg2)return -1;
			else return 0;
		}else if(itg1%2!=0&&itg2%2==0){
			//偶数放下
			if(itg1<itg2)return 1;
			else if(itg1>itg2)return -1;
			else return 0;
		}else{
			//奇数放上
			if(itg1<itg2)return -1;
			else if(itg1>itg2)return 1;
			else return 0;
		}

	}
}