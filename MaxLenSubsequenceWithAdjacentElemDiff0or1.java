package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxLenSubsequenceWithAdjacentElemDiff0or1 {

	public static void main(String[] args) {
		//int array[] = {2, 5, 6, 3, 7, 6, 5, 8};
		int array[] = {-2, -1, 5, -1, 4, 0, 3};
		printLongestSubsequenceWithadjacentDiff0or1(array);
	}

	private static void printLongestSubsequenceWithadjacentDiff0or1(int[] array) {
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				int diff = Math.abs(array[i] - array[j]);
				if(diff == 0 || diff ==1) {
					map.put(j, i);
				}
			}
		}
		
		List<Integer> finalResult = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		for(int k = array.length-1; k >= 0;k--) {
			Integer temp = k;
			while(map.containsKey(temp)) {
					tempResult.add(array[temp]);
					temp = map.get(temp);
			}
			tempResult.add(array[temp]);
			if(tempResult.size() > finalResult.size()) {
				finalResult.clear();
				finalResult.addAll(tempResult);
			}
			tempResult.clear();
		}
		
		for(Integer num: finalResult) {
			System.out.print(num + " ");
		}
	}

}
