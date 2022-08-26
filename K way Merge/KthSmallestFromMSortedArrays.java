import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestFromMSortedArrays {
	static class Node{
		int elementIndex;
		int arrayIndex;
		Node(int elementIndex, int arrayIndex){
			this.elementIndex = elementIndex;
			this.arrayIndex = arrayIndex;
		}
	}

	static int findKthSmallest(List<int[]> lists, int K){
		PriorityQueue<Node> queue = new PriorityQueue<Node>((n1,n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

		for(int i=0;i<lists.size();i++){
			if(lists.get(i) != null){
				queue.add(new Node(0,i));
			}
		}

		int count=0, result=0;
		while(!queue.isEmpty()){
			Node node = queue.poll();
			result = lists.get(node.arrayIndex)[node.elementIndex];
			count++;
			
			if(count == K){
				break;
			}

			node.elementIndex++;
			if(lists.get(node.arrayIndex).length > node.elementIndex){
				queue.add(node);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] l1 = new int[]{2,6,8};
		int[] l2 = new int[]{3,6,7};
		int[] l3 = new int[]{1,3,4};

		List<int[]> lists = new ArrayList<int[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		int result = findKthSmallest(lists,5);
		System.out.println(result);
	}

}
