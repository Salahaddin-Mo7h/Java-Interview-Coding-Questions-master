
public class SearchInARotatedArray {
	static int search(int arr[], int key){
		int start=0, end=arr.length-1;
		while(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[start] <= arr[mid]){
				if(arr[start] < key && key < arr[mid]){
					end = mid-1;
				}
				else{
					start = mid+1;
				}
			}
			else{
				if(arr[mid] < key && key <= arr[end]){
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int result = search(new int[]{4,5,7,8,1,3},1);
		System.out.println(result);
	}

}
