package com.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 二叉树的创建，先序、中序、后序、层次序遍历
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


	/**根据数组值创建二叉树*/
	public void createTree(Object[] tree) {//数组按照从上至下、从左至右的顺序存储节点，为null时表示节点不存在
		LinkedList<BiTreeNode> list=new LinkedList<>();
		for(int i=0;i<tree.length;i++) {//将数据生成为节点
			list.add(new BiTreeNode(tree[i]));
		}
		//根据完全二叉树性质，按照层序从0编号，对于序号为i的节点
		//若i>0,i的双亲序号为（i-1）/2;若i=0，无双亲
		//若(2i+1)<n,i的左孩子序号为（2i+1），若(2i+1)>=n,无左孩子
		//若(2i+2)<n,i的右孩子序号为(2i+2),否则无右孩子

		root=list.get(0);
        for(int i=0;i<list.size()/2-1;i++){  
        	list.get(i).lChild=list.get(2*i+1);
        	list.get(i).rChild=list.get(2*i+2);
        }  
        //单独处理最后一个父节点  因为它有可能没有右子节点  
        int i = list.size()/2-1;  
        list.get(i).lChild=list.get(2*i+1);
        if(list.size() % 2 == 1) {
        	list.get(i).rChild=list.get(2*i+2);
        }
	}
	/**访问节点，此处仅简单输出节点数据值*/
	public void visit(BiTreeNode node) {
		System.out.print(node.data+"\t");
	}
	
	/**递归先序遍历*/
	public void preOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		visit(r);
		preOrderTraverse(r.lChild);
		preOrderTraverse(r.rChild);
	}
	
	/**非递归先序遍历*/
	public void preOrder(BiTreeNode r) {

		
		/*由于先被访问的节点的右子树是被后访问的，所以借用栈来实现非递归遍历
		 * 每次访问某个节点之后，将其入栈，然后去寻找它的左孩子，一直添加左孩子到节点为空
		 * 此时，所有左子树的根节点已经入栈
		 * 如果栈非空，则证明有些节点的右孩子还未访问
		 * 那么，依次出栈，找到栈顶元素的右孩子，这又是一棵树的根，
		 * 所以，需要重复刚才左孩子入栈的动作，继续将该节点的所有左孩子入栈，直到孩子为空*/
		Stack<BiTreeNode> stack = new Stack<>();
		BiTreeNode temp = r;
		while( temp != null || !stack.isEmpty() ) {
			while(temp != null) {
				visit(temp);
				stack.push(temp);
				temp=temp.lChild;
			}

			if(!stack.isEmpty()) {
				temp=stack.pop().rChild;
			}
		}
	}
	/**递归中序遍历*/
	public void inOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		inOrderTraverse(r.lChild);
		visit(r);
		inOrderTraverse(r.rChild);
	}
	
	/**递归后序遍历*/
	public void postOrderTraverse(BiTreeNode r) {
		if(r==null) 
			return;
		postOrderTraverse(r.lChild);
		postOrderTraverse(r.rChild);
		visit(r);
	}
	/**层序遍历，借助队列*/
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

	
    public int TreeDepth(BiTreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
        int l=TreeDepth(root.lChild);
        int r=TreeDepth(root.rChild);
        return l>=r?(l+1):(r+1);
      
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
