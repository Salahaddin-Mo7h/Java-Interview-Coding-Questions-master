import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class TaskSchedulingOrder {
	
	static List<Integer> findOrder(int tasks, int[][] prerequisites){
		List<Integer> result = new ArrayList<>();
		if(tasks <= 0){
			return result;
		}

		//Initialize the graph
		HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for(int i=0;i<tasks;i++){
			indegree.put(i,0);
			graph.put(i, new ArrayList<Integer>());
		}

		//Build the graph
		for(int i=0;i<prerequisites.length;i++){
			int parent = prerequisites[i][0];
			int child = prerequisites[i][1];

			graph.get(parent).add(child);
			indegree.put(child, indegree.get(child)+1);
		}

		//find all sources with 0 indegree and add to the queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for(Entry<Integer, Integer> entry : indegree.entrySet()){
			if(entry.getValue() == 0){
				queue.add(entry.getKey());
			}
		}

		while(!queue.isEmpty()){
			int vertex = queue.poll();
			List<Integer> list = graph.get(vertex);
			for(int child : list){
				indegree.put(child, indegree.get(child)-1);
				if(indegree.get(child) == 0){
					queue.add(child);
				}
			}
			result.add(vertex);
		}
		
		//if result list size is not equal to the number of the tasks then there is cyclic dependency
		if(result.size() != tasks){
			return new ArrayList<>();
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = findOrder(6, new int[][] { new int[]{2,5}, new int[]{0,5}, new int[]{0,4}, new int[]{1,4}, new int[]{3,2}, new int[]{1,3}});
		System.out.println(result);
		
		result = findOrder(3, new int[][]{ new int[]{0,1}, new int[]{1,2}, new int[]{2,0}});
		System.out.println(result);
	}

}

//Time complexity - O(V+E) V- number of tasks, E-number of prerequisites
//Space complexity - O(V+E) for storing the prerequisites for each task in the adjacency list

//Output:
//[0, 1, 4, 3, 2, 5]
//[]
