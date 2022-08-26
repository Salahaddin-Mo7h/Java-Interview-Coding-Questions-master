import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class MinimumHeightTrees {

	static List<Integer> findTrees(int nodes, int[][] edges){
		List<Integer> result = new ArrayList<>();
		if(nodes <= 0){
			return result;
		}

		if(nodes == 1){
			result.add(0);
			return result;
		}

		HashMap<Integer, Integer> indegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for(int i=0;i<nodes;i++){
			indegree.put(i,0);
			graph.put(i, new ArrayList<Integer>());
		}

		for(int i=0;i<edges.length;i++){
			int n1 = edges[i][0];
			int n2 = edges[i][1];

			graph.get(n1).add(n2);
			graph.get(n2).add(n1);

			indegree.put(n1, indegree.get(n1)+1);
			indegree.put(n2, indegree.get(n2)+1);
		}

		Queue<Integer> leaves = new LinkedList<>();
		for(Entry<Integer, Integer> entry : indegree.entrySet()){
			if(entry.getValue() == 1){
				leaves.add(entry.getKey());
			}
		}

		int totalNodes = nodes;
		while(totalNodes > 2){
			int leavesSize = leaves.size();
			totalNodes = totalNodes - leavesSize;
			for(int i=0;i<leavesSize;i++){
				int vertex = leaves.poll();
				List<Integer> children = graph.get(vertex);
				for(int child : children){
					indegree.put(child, indegree.get(child)-1);
					if(indegree.get(child) == 1){
						leaves.add(child);
					}
				}
			}
		}

		result.addAll(leaves);
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = findTrees(5, new int[][] { new int[]{0,1}, new int[]{1,2}, new int[]{1,3}, new int[]{2,4}});
		System.out.println(result);
	}

}

//Time complexity : O(V+E)
//Space complexity : O(V+E)