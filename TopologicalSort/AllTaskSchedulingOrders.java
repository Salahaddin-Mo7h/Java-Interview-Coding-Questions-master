import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;


public class AllTaskSchedulingOrders {

	static void findOrder(int tasks, int[][] prerequisites){
		List<Integer> result = new ArrayList<>();
		if(tasks <= 0){
			return;
		}

		//Initialize the graph
		HashMap<Integer, Integer> indegree = new HashMap<>();
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

		Queue<Integer> queue = new LinkedList<>();
		for(Entry<Integer, Integer> entry : indegree.entrySet()){
			if(entry.getValue() == 0){
				queue.add(entry.getKey());
			}
		}

		printAllTaskSchedulingOrders(graph, indegree, queue, result);
	}

	static void printAllTaskSchedulingOrders(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> indegree, Queue<Integer> queue, List<Integer> result){
		if(!queue.isEmpty()){
			for(Integer vertex : queue){
				result.add(vertex);
				Queue<Integer> queueForNextCall = cloneQueue(queue);
				queueForNextCall.remove(vertex);
				List<Integer> children = graph.get(vertex);
				for(int child : children){
					indegree.put(child, indegree.get(child)-1);
					if(indegree.get(child) == 0){
						queueForNextCall.add(child);
					}
				}

				printAllTaskSchedulingOrders(graph,indegree,queueForNextCall,result);

				result.remove(vertex);
				for(int child: children){
					indegree.put(child, indegree.get(child)+1);
				}
			}
		}

		if(result.size() == indegree.size()){
			System.out.println(result);
		}
	}

	static Queue<Integer> cloneQueue(Queue<Integer> queue){
		Queue<Integer> clone = new LinkedList<>();
		for(int num : queue){
			clone.add(num);
		}
		return clone;
	}

	public static void main(String[] args) {
		findOrder(6, new int[][] { new int[]{2,5}, new int[]{0,5}, new int[]{0,4}, new int[]{1,4}, new int[]{3,2}, new int[]{1,3}});
		System.out.println();
		
		findOrder(3, new int[][]{ new int[]{0,1}, new int[]{1,2}, new int[]{2,0}});
		System.out.println();
	}

}

//Time complexity - O(V! * E)
//where ‘V’ is the total number of tasks and ‘E’ is the total prerequisites. 
//We need the ‘E’ part because in each recursive call, at max, we remove (and add back) all the edges.
