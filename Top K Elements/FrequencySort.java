import java.util.*;
public class FrequencySort {
	static String sortCharacterByFrequency(String str){
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++){
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
		}

		PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1,e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder(str.length());
		while(!maxHeap.isEmpty()){
			Map.Entry<Character,Integer> entry = maxHeap.poll();
			for(int i=0;i<entry.getValue();i++){
				sb.append(entry.getKey());
			}
		}
		return String.valueOf(sb);
	}

	public static void main(String[] args) {
		String result = sortCharacterByFrequency("Programming");
		System.out.println(result);
	}

}
