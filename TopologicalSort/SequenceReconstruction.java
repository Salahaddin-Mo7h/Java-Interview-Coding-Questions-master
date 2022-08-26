import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class SequenceReconstruction {

	static boolean canConstructUniquely(int[] originalSeq, int[][] sequences){
		List<Integer> result = new ArrayList<>();
		if(originalSeq.length <= 0){
			return false;
		}

		HashMap<Integer, Integer> indegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for(int[] seq : sequences){
			for(int i=0;i<seq.length;i++){
				indegree.putIfAbsent(seq[i],0);
				graph.putIfAbsent(seq[i], new ArrayList<Integer>());
			}
		}

		for(int[]  seq : sequences){
			for(int i=1;i<seq.length;i++){
				int parent = seq[i-1];
				int child = seq[i];

				graph.get(parent).add(child);
				indegree.put(child, indegree.get(child)+1);
			}
		}

		if(indegree.size() != originalSeq.length){
			return false;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(Entry<Integer, Integer> entry : indegree.entrySet()){
			if(entry.getValue() == 0){
				queue.add(entry.getKey());
			}
		}

		while(!queue.isEmpty()){
			if(queue.size() > 1){
				return false;
			}
			if(originalSeq[result.size()] != queue.peek()){
				return false;
			}

			int vertex = queue.poll();
			result.add(vertex);
			List<Integer> children = graph.get(vertex);
			for(int child : children){
				indegree.put(child, indegree.get(child)-1);
				if(indegree.get(child) == 0){
					queue.add(child);
				}
			}
		}

		return result.size() == originalSeq.length;
	}

	public static void main(String[] args) {
		boolean result = canConstructUniquely(new int[]{3,1,4,2,5}, new int[][] { new int[]{3,1,5}, new int[]{1,4,2,5}});
		System.out.println(result);

		result = canConstructUniquely(new int[]{1,2,3,4}, new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{2,4}});
		System.out.println(result);
	}

}

//Time complexity - O(V+E)
//where ‘V’ is the count of distinct numbers and 
// ‘E’ is the total number of the rules.
//Since, at most, each pair of numbers can give us one rule, we can conclude that the upper bound for the rules is O(N)
//where ‘N’ is the count of numbers in all sequences. 
//So, we can say that the time complexity of our algorithm is O(V+N).

//Space complexity - O(V+N)