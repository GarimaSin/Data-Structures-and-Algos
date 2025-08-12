package DataStructures.Udemy.BST;

public class BinarySearchTreeByLinkedListMain {

	public static void main(String[] args) {

		//Constructor
		BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();

		//Inserting values in BST
		System.out.println("Inserting 10 nodes in Tree");
		tree.insert(100);
		tree.insert(200);
		tree.insert(80);
		tree.insert(70);
		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(300);
		tree.insert(160);
		tree.insert(155);
		tree.insert(170);
		tree.insert(400);



		tree.printTreeGraphically();
		tree.levelOrderTraversal();
		System.out.println();
		
		tree.inorder(tree.root);
		System.out.println();
		tree.reverseInorder(tree.root);

		//Searching non-existing value in Tree

		System.out.println("\n\nSearching for value on BST...");
		tree.searchForValue(80);

		//Searching existing value in Tree
		System.out.println("\nSearching for value on BST...");
		tree.searchForValue(60);

		//Print Ancestors
		System.out.println("\n"+tree.printAncestors(tree.root, 150));
		
		//Deleting Node from Tree tree.deleteNodeOfBST(80); //Node does not exists
		tree.printTreeGraphically();


		tree.deleteNodeOfBST(100); //Node is having 0 Child
		tree.printTreeGraphically();
		
		//Traversing Tree
		tree.levelOrderTraversal();

		System.out.println(tree.printAncestors(tree.root, 150));
//		tree.deleteNodeOfBST(60); //Node is having 1 Child
//		tree.printTreeGraphically();
//
//		tree.deleteNodeOfBST(50); //Node is having 2 Child
//		tree.printTreeGraphically();

		//Deleting entire Tree
		tree.deleteTree();

		//Traversing Tree
		tree.levelOrderTraversal();
		 
	}//end of method

}//end of class