package com.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
/**
 * �������Ĵ������������򡢺��򡢲�������
 * @author Jing*/
public class BiTree {
	private BiTreeNode root;
	
	public BiTree() {
		root=new BiTreeNode();
		//root=null;
	}
	
	
	public BiTreeNode getRoot() {
		return root;
	}


	/**��������ֵ����������*/
	public void createTree(Object[] tree) {//���鰴�մ������¡��������ҵ�˳��洢�ڵ㣬Ϊnullʱ��ʾ�ڵ㲻����
		LinkedList<BiTreeNode> list=new LinkedList<>();
		for(int i=0;i<tree.length;i++) {//����������Ϊ�ڵ�
			list.add(new BiTreeNode(tree[i]));
		}
		//������ȫ���������ʣ����ղ����0��ţ��������Ϊi�Ľڵ�
		//��i>0,i��˫�����Ϊ��i-1��/2;��i=0����˫��
		//��(2i+1)<n,i���������Ϊ��2i+1������(2i+1)>=n,������
		//��(2i+2)<n,i���Һ������Ϊ(2i+2),�������Һ���

		root=list.get(0);
        for(int i=0;i<list.size()/2-1;i++){  
        	list.get(i).lChild=list.get(2*i+1);
        	list.get(i).rChild=list.get(2*i+2);
        }  
        //�����������һ�����ڵ�  ��Ϊ���п���û�����ӽڵ�  
        int i = list.size()/2-1;  
        list.get(i).lChild=list.get(2*i+1);
        if(list.size() % 2 == 1) {
        	list.get(i).rChild=list.get(2*i+2);
        }
	}
	/**���ʽڵ㣬�˴���������ڵ�����ֵ*/
	public void visit(BiTreeNode node) {
		System.out.print(node.data+"\t");
	}
	
	/**�ݹ��������*/
	public void preOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		visit(r);
		preOrderTraverse(r.lChild);
		preOrderTraverse(r.rChild);
	}
	/**�ݹ��������*/
	public void inOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		inOrderTraverse(r.lChild);
		visit(r);
		inOrderTraverse(r.rChild);
	}
	
	/**�ݹ�������*/
	public void postOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		postOrderTraverse(r.lChild);
		postOrderTraverse(r.rChild);
		visit(r);
	}
	/**�����������������*/
	public void levelOrderTraverse(BiTreeNode root) {
		
		BiTreeNode temp=null;
		if(root==null)
			return;
		Queue<BiTreeNode> biQueue=new LinkedList<>();
		biQueue.offer(root);
		while(!biQueue.isEmpty()) {
			temp=biQueue.poll();
			visit(temp);
			if(temp.lChild!=null) {
				biQueue.offer(temp.lChild);
			}
			if(temp.rChild!=null) {
				biQueue.offer(temp.rChild);
			}
		}
		
	}
}

class BiTreeNode{
	Object data;
	BiTreeNode lChild,rChild;
	
	public BiTreeNode() {
		// TODO Auto-generated constructor stub
		lChild=null;
		rChild=null;
		data=null;
	}
	public BiTreeNode(Object data,BiTreeNode left,BiTreeNode right) {
		lChild=left;
		rChild=right;
		this.data=data;
	}
	public BiTreeNode(Object data) {
		this.data=data;
		lChild=null;
		rChild=null;
	}
}
