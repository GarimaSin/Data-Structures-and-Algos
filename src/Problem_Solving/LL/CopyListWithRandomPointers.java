package Problem_Solving.LL;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointers {

	public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node head1 = head;
        Node head2 = new Node(-1);
        Node ptr = head2;
        while(head != null) {
            Node tmp = new Node(head.val);
            ptr.next = tmp;
            map.put(head, tmp);
            head = head.next;
            ptr = ptr.next;
        }
        
        head = head1;
        head2 = head2.next;
        Node headNew = head2;
        while(head1 != null) {
            head2.random = map.get(head1.random);
            head1 = head1.next;
            head2 = head2.next;
        }
        return headNew;
    }
	
	
	//Simple code
	Node copyList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node i = head;
        while(i != null){
            map.put(i, new Node(i.val));
            i = i.next;
        }
        
        i = head;
        while(i!=null){
            map.get(i).next = map.get(i.next);
            map.get(i).random = map.get(i.random);
            i=i.next;
        }
        return map.get(head);
    }

	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		head.random = n2;
		n2.random = n4;
		n3.random = n5;
		n4.random = n3;
		n5.random = head;
		copyRandomList(head);
	}
	
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
}
