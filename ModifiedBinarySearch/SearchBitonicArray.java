public class SearchBitonicArray {
	static int findMax(int arr[]){
		int N = arr.length;
		int start = 0, end = N-1;
		while(start < end){
			int mid = start + (end-start)/2;
			if(arr[mid] > arr[mid+1]){
				end = mid;
			}
			else{
				start = mid+1;
			}
		}
		return start;
	}

	static int binarySearch(int arr[], int key, int start, int end){
		while(start <= end){
			int mid = start + (end-start)/2;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] < key){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return -1;
	}

	static int search(int arr[], int key){
		int maxIndex = findMax(arr);
		int keyIndex = binarySearch(arr,key,0,maxIndex);
		if(keyIndex != -1){
			return keyIndex;
		}
		return binarySearch(arr,key,maxIndex+1,arr.length-1);
	}

	public static void main(String[] args) {
		int result = search(new int[]{1,3,7,8,4,2}, 7);
		System.out.println(result);
	}

}
