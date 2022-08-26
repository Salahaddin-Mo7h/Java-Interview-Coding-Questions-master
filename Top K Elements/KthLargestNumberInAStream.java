import java.util.*;
public class KthLargestNumberInAStream {

	static class KthLargestNumber{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
		int K;

		public KthLargestNumber(int[] arr, int K){
			this.K = K;
			for(int i=0;i<arr.length;i++){
				add(arr[i]);
			}
		}

		public int add(int num){
			minHeap.add(num);
			if(minHeap.size() > this.K){
				minHeap.poll();
			}
			return minHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,1,5,12,2,11};
		KthLargestNumber obj = new KthLargestNumber(arr,4);
		System.out.println(obj.add(6));
		System.out.println(obj.add(13));
		System.out.println(obj.add(4));
	}

}