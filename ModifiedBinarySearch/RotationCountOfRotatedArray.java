
public class RotationCountOfRotatedArray {
	static int findRotations(int arr[]){
		int start=0, end=arr.length-1;
		while(start < end){
			int mid = start + (end-start)/2;
			if(mid < end && arr[mid] > arr[mid+1]){
				return mid+1;
			}
			if(mid > start && arr[mid-1] > arr[mid]){
				return mid;
			}

			if(arr[start] < arr[mid]){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int result = findRotations(new int[]{3,4,5,7,1,2});
		System.out.println(result);
	}

}
