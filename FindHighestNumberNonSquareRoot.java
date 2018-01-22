package com.practice;

import java.util.Arrays;

public class FindHighestNumberNonSquareRoot {

	public static void main(String[] args) {
		int array [] = {121, 20, 25, 2, 3, 9, 10};
		int j = 1;
		int maxNonSquare = 0;
		int square = 1;
		Arrays.sort(array);
		for(int i=0; i<array.length; i++) {
			while(square < array[i]) {
				j = j+2;
				square += j;
				if(square + j > array[i]) {
					break;
				}
			}
			if(array[i] != square && maxNonSquare < array[i]) {
				maxNonSquare = array[i];
			}
		}
		System.out.println(maxNonSquare);
	}

}
