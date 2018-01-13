package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctPairsWithSomeGivenDiff {

	public static void main(String[] args) {
		int array[] = {8, 12, 16, 4, 3, 0, 20};
		int k = 4;
		countDistinctPairsWhenElementRangeSmall(array, k);
		countDistinctPairsWhenElementRangeLarge(array, k);
	}
	
	// use set.
	private static void countDistinctPairsWhenElementRangeSmall(int array[], int k) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for(int i=0;i<array.length;i++) {
			set.add(array[i]);
		}
		for(int i=0;i<array.length;i++) {
			if(set.contains(array[i] - k)) {
				count ++;
			} 
			if(set.contains(array[i] + k)) {
				count ++;
			}
			set.remove(array[i]);
		}
		System.out.println(count);
	}
	
	// use sorting
	private static void countDistinctPairsWhenElementRangeLarge(int array[], int k) {
		Arrays.sort(array);
		int count = 0;
		int firstIndex = 0;
		int nextIndex = 1;
		while(nextIndex <= array.length-1) {
			if(array[nextIndex] - array[firstIndex] == k) {
				count ++;
				firstIndex ++;
				nextIndex ++;
			} else if (array[nextIndex] - array[firstIndex] < k) {
				nextIndex ++;
			} else if(array[nextIndex] - array[firstIndex] > k) {
				firstIndex ++;
				if(firstIndex == nextIndex) {
					nextIndex++;
				}
			}
		}
		System.out.println(count);
	}
}