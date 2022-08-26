
import java.io.*;
import java.util.*;

public class KthSmallestInAMatrix {

	static class Node{
		int row;
		int col;
		Node(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	static int findKthSmallest(int matrix[][], int K){
		PriorityQueue<Node> queue = new PriorityQueue<Node>((n1,n2) -> (matrix[n1.row][n1.col] - matrix[n2.row][n2.col]));

		for(int i=0;i<matrix.length && i<K;i++)
			queue.add(new Node(i,0));

			int count=0,result=0;
			while(!queue.isEmpty()){
				Node node = queue.poll();
				result = matrix[node.row][node.col];
				count++;

				if(count == K){
					break;
				}
				node.col++;
				if(matrix[0].length > node.col){
					queue.add(node);
				}
			}
		
		return result;
	}

	public static void main(String[] args) {
		int matrix[][] = {{2,6,8}, {3,7,10},{5,8,11}};
		int result = findKthSmallest(matrix, 5);
		System.out.println(result);
	}

}
