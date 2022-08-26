import java.io.*;
import java.util.*;

import java.util.PriorityQueue;

public class KLargestNumbers {
	
	static List<Integer> findKLargestNumbers(int arr[],int K){
		int N = arr.length;
		if(N < K){
		    return new ArrayList<Integer>();
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);

		for(int i=0;i<K;i++){
			minHeap.add(arr[i]);
		}

		for(int i=K;i<N;i++){
			if(arr[i] > minHeap.peek()){
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		
		return new ArrayList<Integer>(minHeap);
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 1, 5, 12, 2, 11};
		List<Integer> result = findKLargestNumbers(arr,3);
        System.out.println(result);
	}

}

//Time complexity - O(K log K + (N-K)logK) ~ O(NlogK)
//Space complexity - O(K)