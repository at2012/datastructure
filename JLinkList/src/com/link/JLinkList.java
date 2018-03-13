package com.link;
/**
 * 链表的增删改查（未处理任何异常）
 * @author Jing*/
public class JLinkList {
	LinkNode head;
	LinkNode current;
	int size;
	
	public JLinkList() {
		head=current=new LinkNode(null);
		size=0;
	}
	/**
	 * 查看第i个节点处data*/
	public Object getData(int i) {
		this.index(i);
		return current.getData();
	}
	/**
	 * 修改第i个节点处data*/
	public void setDate(Object obj, int i) {
		index(i);
		current.setData(obj);
	}
	
	/**在链表末尾添加*/
	public void add(Object obj) {
		LinkNode temp=new LinkNode(obj);
		this.index(size-1);
		current.setNext(temp);
		size++;
	}
	/**在指定位置插入
	 * @param i 插入位置*/
	public void insert(Object obj,int i) {
		LinkNode temp=new LinkNode(obj);
		index(i-1);
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
	/**
	 * 在指定位置删除*/
	public void delete(int i) {
		index(i-1);
		current.setNext(current.getNext().getNext());
		size--;
	}
	
	
	/**用于检索链表，作用类似数组下标，由于链表的很多操作都需要定位，写成一个函数是很有必要的*/
	public void index(int i) {//i从0开始
		int j=0;
		current=head;
		while(j<=i && current!=null) {//如果i从1开始计数则判断j<i
			current=current.getNext();
			j++;
		}
	}
}

class LinkNode{
	private Object data;
	//如果这里不加private修饰符（使用默认），那么就可以不写get set 方法，在JLinkList类里面直接访问这里的成员变量
	private LinkNode next;
	
	public LinkNode(Object obj) {
		data=obj;
		next=null;
	}
	public LinkNode() {
		data=null;
		next=null;
	}
	
	public LinkNode getNext() {
		return next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
	
	
	
	
}