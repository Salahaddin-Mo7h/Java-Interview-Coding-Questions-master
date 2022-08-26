import java.util.*;
public class SumOfElements {
	static int sum(int arr[], int K1, int K2){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
		for(int i=0;i<arr.length;i++){
		    minHeap.add(arr[i]);
		}

		for(int i=0;i<K1;i++){
			minHeap.poll();
		}

		int sum = 0;
		int i=0;
		while(i < K2-K1-1){
		    sum += minHeap.poll();
		    i++;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,3,12,5,15,11};
		System.out.println(sum(arr,3,6));
	}

}
