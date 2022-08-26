
import java.util.*;
public class MaxDistinctElements {
	static int findMaxDistinctElements(int arr[], int K){
		int distinctCount = 0;
		if(arr.length <= K){
			return distinctCount;
		}

		HashMap<Integer,Integer> freq = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			freq.put(arr[i], freq.getOrDefault(arr[i],0)+1);
		}

		PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1,e2) -> e1.getValue() - e2.getValue());
		for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
			if(entry.getValue() == 1){
				distinctCount++;
			}
			else{
				minHeap.add(entry);
			}
		}

		while(K>0 && !minHeap.isEmpty()){
			Map.Entry<Integer,Integer> entry = minHeap.poll();
			K -= entry.getValue() - 1;	//to make an element distinct, need to remove all occurrences except one
			if(K >= 0){
				distinctCount++;
			}
		}

		//still k>0, need to remove some distinct numbers
		if(K>0){
			distinctCount -= K;
		}

		return distinctCount;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{7,3,5,8,5,3,3};
		System.out.println(findMaxDistinctElements(arr,2));
	}

}



