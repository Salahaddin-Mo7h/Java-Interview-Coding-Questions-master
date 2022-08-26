import java.util.PriorityQueue;

public class MergeKSortedArrays {
	static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}

	static ListNode mergeLists(ListNode[] lists){
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((n1,n2) -> n1.val - n2.val);
		for(ListNode root : lists){
			if(root != null){
				queue.add(root);
			}
		}

		ListNode head = null;
		ListNode tail = null;
		while(!queue.isEmpty()){
			ListNode node = queue.poll();
			if(head == null){
				head = tail = node;
			}
			else{
				tail.next = node;
				tail = tail.next;
			}

			if(node.next != null){
				queue.add(node.next);
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);

		ListNode result = mergeLists(new ListNode[]{l1, l2, l3});
		while(result != null){
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}

}
