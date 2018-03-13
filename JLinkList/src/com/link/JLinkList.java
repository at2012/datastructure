package com.link;
/**
 * �������ɾ�Ĳ飨δ�����κ��쳣��
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
	 * �鿴��i���ڵ㴦data*/
	public Object getData(int i) {
		this.index(i);
		return current.getData();
	}
	/**
	 * �޸ĵ�i���ڵ㴦data*/
	public void setDate(Object obj, int i) {
		index(i);
		current.setData(obj);
	}
	
	/**������ĩβ���*/
	public void add(Object obj) {
		LinkNode temp=new LinkNode(obj);
		this.index(size-1);
		current.setNext(temp);
		size++;
	}
	/**��ָ��λ�ò���
	 * @param i ����λ��*/
	public void insert(Object obj,int i) {
		LinkNode temp=new LinkNode(obj);
		index(i-1);
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
	/**
	 * ��ָ��λ��ɾ��*/
	public void delete(int i) {
		index(i-1);
		current.setNext(current.getNext().getNext());
		size--;
	}
	
	
	/**���ڼ��������������������±꣬��������ĺܶ��������Ҫ��λ��д��һ�������Ǻ��б�Ҫ��*/
	public void index(int i) {//i��0��ʼ
		int j=0;
		current=head;
		while(j<=i && current!=null) {//���i��1��ʼ�������ж�j<i
			current=current.getNext();
			j++;
		}
	}
}

class LinkNode{
	private Object data;
	//������ﲻ��private���η���ʹ��Ĭ�ϣ�����ô�Ϳ��Բ�дget set ��������JLinkList������ֱ�ӷ�������ĳ�Ա����
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