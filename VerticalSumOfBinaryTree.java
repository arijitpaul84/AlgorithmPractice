package com.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalSumOfBinaryTree {

	public static void main(String[] args) {
		Node root = createTree();
		Queue<Node> queue = new LinkedList<>();
		Map<Integer,Integer> verticalOrderToNodes = new TreeMap<>();
		Map<Node,Integer> nodeToVerticalValue = new HashMap<>();
		queue.add(root);
		nodeToVerticalValue.put(root, 0); // setting the root most node vertical value as 0; 
		verticalOrderToNodes.put(0, root.data);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.left != null) {
				calculateVerticalSum(queue, verticalOrderToNodes, nodeToVerticalValue, n.left, nodeToVerticalValue.get(n) - 1);
			} 
			if(n.right != null) {
				calculateVerticalSum(queue, verticalOrderToNodes, nodeToVerticalValue, n.right, nodeToVerticalValue.get(n) + 1);
			}
		}
		
		for(Integer key : verticalOrderToNodes.keySet()) {
			System.out.println(verticalOrderToNodes.get(key));
		}

	}

	private static void calculateVerticalSum(Queue<Node> queue, Map<Integer, Integer> verticalOrderToNodes,
			Map<Node, Integer> nodeToVerticalValue, Node temp, Integer verticalValue) {
		if(temp != null) {
			nodeToVerticalValue.put(temp, verticalValue);
			Integer sum = verticalOrderToNodes.get(verticalValue);
			if(sum == null) {
				verticalOrderToNodes.put(verticalValue, temp.data);
			} else {
				verticalOrderToNodes.put(verticalValue, (sum+temp.data));
			}
			queue.add(temp);
		}
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
	}
	
	private static Node createTree() {
		Node root = new Node();
		root.data = 1;
		Node child1 = new Node();
		Node child2 = new Node();
		child1.data = 2;
		child2.data = 3;
		root.left = child1;
		root.right = child2;
		
		Node child3 = new Node();
		Node child4 = new Node();
		child3.data = 4;
		child4.data = 5;
		
		Node child5 = new Node();
		Node child6 = new Node();
		child5.data = 6;
		child6.data = 7;
		
		child1.left = child3;
		child1.right = child4;
		
		child2.left = child5;
		child2.right = child6;
		
		return root;
	}
}