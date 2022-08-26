
import java.util.*;
public class ConnectRopes {

	static int minCostToConnect(int arr[]){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
		for(int i=0;i<arr.length;i++){
			minHeap.add(arr[i]);
		}

		int sum = 0;
		while(minHeap.size() > 1){
			int temp = minHeap.poll() + minHeap.poll();
			sum += temp;
			minHeap.add(temp);
		}
		return sum;
	}

	public static void main(String[] args) {
		int result = minCostToConnect(new int[]{1,3,11,5,2});
		System.out.println(result);
	}

}