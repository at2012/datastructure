package com.tree.binary;

public class Main {

	public static void main(String[] args) {
		Character[] data=new Character[] {'A','B','C','D',null,'E','F',null,'G'};
		
		BiTree tree=new BiTree();
		tree.createTree(data);
		System.out.println("�������");
		tree.preOrderTraverse(tree.getRoot());
		System.out.println();
		System.out.println("����ǵݹ�");
		tree.preOrder(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.inOrderTraverse(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.postOrderTraverse(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.levelOrderTraverse(tree.getRoot());
		
	}
}
