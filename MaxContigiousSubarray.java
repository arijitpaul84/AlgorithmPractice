package com.practice;

public class MaxContigiousSubarray {

	public static void main(String[] args) {
		int array [] = {2,9,3,4,6,7,8,10,11,12};
		int start = 0;
		int end = 0;
		int temp = 0;
		int len = 0;
		int maxLen = 0;
		
		for(int i=0;i<array.length;i++) {
			if(i+1 != array.length && array[i+1] - array[i] == 1) {
				if(start == end) {
					start = i;
				}
				temp = i;
				end = i+1;
			} else {
				len = end - start + 1;
				if(len > maxLen) {
					maxLen = len;
				}
				start = 0;
				end = 0;
				temp = 0;
			}
		}
		System.out.println("max len = "+maxLen);

	}
}
