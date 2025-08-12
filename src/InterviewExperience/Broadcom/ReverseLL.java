package InterviewExperience.Broadcom;


public class ReverseLL {

	private static class Node {
	    private Node next;
	    private int data;
	    public Node(int data) {
	        this.data = data;
	    }
	}
	
	// 1 -> 2 -> 3 -> 4 -> 5
	// 5 -> 4 -> 3 -> 2 -> 1
//	Node head = null;
	private Node reverseRecursively(Node currentNode){
		if(currentNode.next == null) {
			return currentNode;
		}
		
		Node tmp = reverseRecursively(currentNode.next); //tmp = 5
		currentNode.next.next = currentNode;		// cu = 4, 5 -> 4
		currentNode.next = null;								// 4 -> 5 ///  5 -> 4      1-2- 3 <-4 <- 5
		return tmp;					//5 
	}
}
