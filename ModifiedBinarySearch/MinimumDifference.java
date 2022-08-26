
public class MinimumDifference {
	static int findMinDifference(int[] arr, int key){
		int N = arr.length;
		if(key < arr[0]){
			return arr[0];
		}
		if(arr[N-1] < key){
			return arr[N-1];
		}

		int start=0, end=N-1;
		while(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] < key){
				start = mid+1;
			}
			else if(key < arr[mid]){
				end = mid-1;
			}
			else{
				return mid;
			}
		}
		if((arr[start] - key) < (key - arr[end])){
			return arr[start];
		}
		return arr[end];
	}

	public static void main(String[] args) {
		int result = findMinDifference(new int[]{4,6,10}, 7);
		System.out.println(result);
		
		result = findMinDifference(new int[]{1,3,8,10,15}, 12);
		System.out.println(result);
	}

}
