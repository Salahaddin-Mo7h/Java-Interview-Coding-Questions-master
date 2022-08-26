public class OrderAgnosticBinarySearch {
	static int binarySearch(int arr[], int key){
		int start=0, end=arr.length-1;
		boolean isAscending = arr[start] < arr[end];

		while(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] == key){
				return mid;
			}

			else if(isAscending){
				if(arr[mid] < key){
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}

			else{
				if(arr[mid] > key){
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
		int arr[] = new int[]{1, 3, 5, 7, 8, 10};
		System.out.println(binarySearch(arr,7));
	}

}

