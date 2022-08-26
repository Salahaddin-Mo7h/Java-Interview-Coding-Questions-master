
import java.util.*;
public class KClosestPoints {
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
 		}

 		int distanceFromOrigin(){
 			return (x*x) + (y*y);
 		}
	}


	static List<Point> findKClosestPoints(Point[] points, int K){
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((p1,p2) -> p2.distanceFromOrigin() - p1.distanceFromOrigin());
		for(int i=0;i<K;i++){
			maxHeap.add(points[i]);
		}

		for(int i=K;i<points.length;i++){
			if(points[i].distanceFromOrigin() < maxHeap.peek().distanceFromOrigin()){
				maxHeap.poll();
				maxHeap.add(points[i]);
			}
		}

		return new ArrayList<Point>(maxHeap);
	}

	public static void main(String[] args) {
		Point[] points = new Point[]{new Point(1,3), new Point(3,4), new Point(2,-1)};
		List<Point> result = findKClosestPoints(points,2);
		for(Point p : result){
			System.out.print("[" + p.x + "," + p.y + "]");
		}
	}

}