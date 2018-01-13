package com.practice;

import java.util.PriorityQueue;
/**
 * Kth smallest element in a row-wise and column-wise sorted 2D array
 * @author apaul
 */
public class SearchElementInSorted2DArray {

	public static void main(String[] args) {
		int [][] array= new int[4][4];
		createArray(array);
		
		int k = 7;
		int temp = 1;
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(array[0][0], 0, 0));
		int row_next = 0;
		int col_next = 0;
		
		while(temp != k) {
			priorityQueue.add(new Node(array[row_next][col_next+1], row_next, col_next+1));
			priorityQueue.add(new Node(array[row_next+1][col_next], row_next+1, col_next));
			
			Node n = priorityQueue.poll();
			row_next = n.row;
			col_next = n.column;
			temp++;
		}
		Node result = null;
		while(!priorityQueue.isEmpty()) {
			result = priorityQueue.poll();
		}
		System.out.println(result.data);

	}
	
	static class Node implements Comparable<Node> {
		int data;
		int row;
		int column;
		
		Node(int data, int row, int column) {
			this.data = data;
			this.row = row;
			this.column = column;
		}
		
		@Override
		public int compareTo(Node node) {
			if(this.data > node.data) {
				return 1;
			} else {
				return 0;
			}
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	private static void createArray(int array[][]) {
		array[0][0] = 10;
		array[0][1] = 20;
		array[0][2] = 30;
		array[0][3] = 40;
		
		array[1][0] = 15;
		array[1][1] = 25;
		array[1][2] = 35;
		array[1][3] = 45;
		
		array[2][0] = 24;
		array[2][1] = 29;
		array[2][2] = 37;
		array[2][3] = 48;
		
		array[3][0] = 32;
		array[3][1] = 33;
		array[3][2] = 39;
		array[3][3] = 50;
	}

}
