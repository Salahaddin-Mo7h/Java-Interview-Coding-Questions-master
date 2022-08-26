import java.util.PriorityQueue;


public class KthSmallestNumber {

	static int findKthSmallest(int arr[], int K){
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> n2 - n1);
		for(int i=0;i<K;i++){
			maxHeap.add(arr[i]);
		}

		for(int i=K;i<arr.length;i++){
			if(arr[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 5, 12, 2, 11, 5};
		int result = findKthSmallest(arr, 3);
		System.out.println(result);
	}

}
