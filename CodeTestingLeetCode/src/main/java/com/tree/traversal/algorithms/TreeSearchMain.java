package com.tree.traversal.algorithms;

public class TreeSearchMain {
	
	public static void preorderTraversal(Node n) {
		
		if (n == null) {
			return;
		}
		System.out.println(n.value+" ");
		preorderTraversal(n.left);
		preorderTraversal(n.right);
		
	}
	public static void postorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		postorderTraversal(n.left);
		postorderTraversal(n.right);
		System.out.println(n.value+" ");
	}
	public static void inrderTraversal(Node n) {
		if (n == null) {
			return;
		}
		inrderTraversal(n.left);
		System.out.println(n.value+" ");
		inrderTraversal(n.right);
	}
	
	public static Node createData() {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		
		a.left = b;
		a.right = g;
		b.left = c;
		b.right = d;
		c.left = e;
		e.right = f;
				
				
		return a;
	}
	
	
	public static void main(String[] args) {
		Node data = createData();
		preorderTraversal(data);
		postorderTraversal(data);
		inrderTraversal(data);
	}

}
