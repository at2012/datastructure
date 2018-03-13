package com.link;

public class Main {

	public static void main(String[] args) {
		JLinkList list = new JLinkList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		for(int i=0;i<list.size;i++) {
			System.out.println(list.getData(i));
		}
		
		list.delete(0);
		for(int i=0;i<list.size;i++) {
			System.out.println("É¾³ı²âÊÔ£º"+list.getData(i));
		}
		
		list.insert(5, 2);
		
		for(int i=0;i<list.size;i++) {
			System.out.println(list.getData(i));
		}
		
	}
}
