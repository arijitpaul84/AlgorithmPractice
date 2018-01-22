package com.practice;

import java.util.ArrayList;
import java.util.List;

public class MaxIncreasingSubsequene {

	public static void main(String[] args) {
		int array[] = { 10, 22, 8, 9, 33, 21, 50, 41, 60};
		List<Integer> finalList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		
		for(int i=0; i < array.length; i++) {
			int lastElement = !finalList.isEmpty() ? finalList.get(finalList.size()-1) : -1;
			if(array[i] > lastElement) {
				finalList.add(array[i]);
			} else if(array[i] < finalList.get(0)) {
				tempList.add(array[i]);
				resizefinalArray(finalList, tempList);
			} else {
				int mid = getIndexToReplace(finalList,array[i]);
				tempList.addAll(finalList.subList(0, mid+1));
				tempList.add(array[i]);
				resizefinalArray(finalList, tempList);
			}
		}
		
		System.out.println(finalList.toString());

	}

	private static void resizefinalArray(List<Integer> finalList, List<Integer> tempList) {
		if(tempList.size() == finalList.size()) {
			finalList.clear();
			finalList.addAll(tempList);
			tempList.clear();
		}
	}

	private static int getIndexToReplace(List<Integer> finalList, int number) {
		int low = 0;
		int high = finalList.size()-1;
		int mid = 0;
		while(low < high && high < finalList.size()) {
			mid = ((low+high) + 1)/2;
			if(finalList.get(mid) < number) {
				low = mid;
			} else if(finalList.get(mid) > number) {
				high = mid+1;
				return low;
			}
		}
		return mid;
	}
}
