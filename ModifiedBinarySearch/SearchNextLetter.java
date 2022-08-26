
public class SearchNextLetter {
	static char search(char arr[], char key){
		int N = arr.length;
		
		if(arr[0] > key || arr[N-1] < key){
			return arr[0];
		}
		
		int start = 0, end = N-1;
		while(start <= end){
			int mid = start + (end-start)/2;
			if(key < arr[mid]){
				end = mid-1;
			}
			else{ //if(arr[mid] <= key)
				start = mid+1;
			}
		}
		return arr[start%N];
	}

	public static void main(String[] args) {
		char arr[] = new char[]{'a', 'c', 'f', 'h'};
		System.out.println(search(arr,'f'));
	}

}
