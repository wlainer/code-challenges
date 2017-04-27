package challenge.hackerrank.linkedlist;

public class InsertNPostition {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 5;

		Node n2 = new Node();
		n2.data = 1;

		Node n3 = new Node();
		n3.data = 3;

		head.next = n2;
		n2.next = n3;

		Node insertNth = InsertNth(head, 4, 2);

		print(insertNth);
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
	}

	static Node InsertNth(Node head, int data, int position) {
		Node newNode = new Node();
		newNode.data = data;

		int count = 0;
		Node prev = null;
		Node cur = head;
		while (cur != null && count < position) {
			count++;
			prev = cur;
			cur = cur.next;
		}
		
		if (count != position) {
			System.out.println("Not enough nodes in the list!");
		} else {
			if (prev == null) {
				newNode.next = head;
				head = newNode;
			} else {
				newNode.next = cur;
				prev.next = newNode;
			}
		}

		return head;

	}

}

class Node {
	Node next;
	int data;
}
