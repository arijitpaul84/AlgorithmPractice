package com.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaximumSumLeafToRootPath {

	public static void main(String[] args) {
		Node root = createTree();
		if(root != null) {
			calculateMaxSumIteratively(root);
			System.out.println(calculateMaxSumRecursively(root, root.data, 0));
		}
	}
	
	private static int calculateMaxSumRecursively(Node root, int sum, int maxSum) {
		if(root.left == null && root.right == null) {
			if(maxSum < sum) {
				maxSum = sum;
			}
			sum -= root.data;
			return maxSum;
		}
		maxSum = calculateMaxSumRecursively(root.left, sum+root.left.data, maxSum);
		maxSum = calculateMaxSumRecursively(root.right, sum+root.right.data, maxSum);
		return maxSum;
	}

	private static void calculateMaxSumIteratively(Node root) {
		Integer maxSum = 0;
		Integer sum = root.data;
		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();
		stack.push(root);
		Node temp = null;
		set.add(temp);
		while(!stack.isEmpty()) {
			temp = stack.peek();
			while(temp.left != null && set.add(temp.left)) {
				temp = temp.left;
				stack.push(temp);
				sum += temp.data;
			}
			if(temp.right == null) {
				if(maxSum < sum) {
					maxSum = sum;
				}
				sum -= stack.pop().data;
			} else if(temp.right != null && set.add(temp.right)) {
				stack.push(temp.right);
				sum += temp.right.data;
			} else {
				sum -= stack.pop().data;
			}
		}
		System.out.println(maxSum);
	}
	
	private static Node createTree() {
		Node root = new Node();
		root.data = 10;
		Node child1 = new Node();
		Node child2 = new Node();
		child1.data = -2;
		child2.data = 7;
		root.left = child1;
		root.right = child2;
		
		Node child3 = new Node();
		Node child4 = new Node();
		child3.data = 8;
		child4.data = -4;
		
		child1.left = child3;
		child1.right = child4;
		
		return root;
	}
	
	static class Node {
		Node left;
		Node right;
		Integer data;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			return true;
		}
		
		public String toString() {
			return this.data.toString();
		}
	}
}