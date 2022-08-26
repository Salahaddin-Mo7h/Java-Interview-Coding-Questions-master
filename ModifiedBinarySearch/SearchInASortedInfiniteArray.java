public class SearchInASortedInfiniteArray {
	static class ArrayReader
	{
		int[] arr;

		ArrayReader(int[] arr){
			this.arr = arr;
		}

		public int get(int index){
			if(index >= arr.length)
				return Integer.MAX_VALUE;
			return arr[index];
		}
	}

	static int search(ArrayReader reader, int key){
		int start = 0, end = 1;
		while(reader.get(end) < key){
			int new_start = end+1;
			end += (end-start+1) * 2;
			start = new_start;
		}
		return binarySearch(reader,key,start,end);
	}

	static int binarySearch(ArrayReader reader, int key, int start, int end){
		while(start <= end){
			int mid = start + (end-start)/2;
			if(key < reader.get(mid)){
				end = mid-1;
			}
			else if(key > reader.get(mid)){
				start = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader(new int[]{4,6,8,10,12,14,16,18,20,22,24,26,28,30});
		System.out.println(search(reader,24));
	}

}

