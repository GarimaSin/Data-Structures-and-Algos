package DataStructures.Udemy.Heap;

/**
 * START INSERTION FROM 1st INDEX
 * For extract op., remove the root, replace it with the last element in the tree, then heapify top to bottom at index 1
 * 		(since top is removed)
 * Insertion always done at last = sizeOfTree, hence heapify bottom to top at (sizeOfTree)
 * sizeOfTree = points to the last occupied cell of the array 
 * Extraction/Peek is done at the front ie at index 1
 * 
 * Below is the code for min-heap
 */

public class HeapByArray { 
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	private static final int FRONT = 1; 

	public HeapByArray(int maxsize) { 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE; 
	} 

	// Returns the position of the parent for the node currently at pos 
	private int parent(int pos) {
		return pos / 2; 
	} 

	// Returns the position of the left child for the node currently at pos
	private int leftChild(int pos) {
		return (2 * pos); 
	} 

	// Returns the position of the right child for the node currently at pos 
	private int rightChild(int pos) {
		return (2 * pos) + 1; 
	} 

	// Returns true if the passed node is a leaf node 
	private boolean isLeaf(int pos) {
		if (pos >= (size/2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) { 
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
	} 

	// Function to heapify the node at pos 
	private void minHeapify(int pos) {

		// If the node is a non-leaf node and greater than any of its child 
		if (!isLeaf(pos)) { 
			if (Heap[pos] > Heap[leftChild(pos)] 
					|| Heap[pos] > Heap[rightChild(pos)]) { 

				// Swap with the left child and heapify the left child 
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 

				// Swap with the right child and heapify the right child 
				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 

	// Function to insert a node into the heap 
	public void insert(int element) { 
		if (size >= maxsize) { 
			return; 
		} 
		Heap[++size] = element; 
		int current = size; 

		while (Heap[current] < Heap[parent(current)]) { 		//only have to compare with the parent 
																								//(since parent is the min/max amongst parent n both children).
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	// Function to print the contents of the heap 
	public void print() { 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] 
					+ " LEFT CHILD : " + Heap[2 * i] 
							+ " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	// Function to build the min heap using the minHeapify 
	public void minHeap() { 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
	} 

	// Function to remove and return the minimum element from the heap 
	public int remove() { 
		int popped = Heap[FRONT]; 
		Heap[FRONT] = Heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	} 

	public static void main(String[] arg) { 
		System.out.println("The Min Heap is "); 
		HeapByArray minHeap = new HeapByArray(15); 
		minHeap.insert(5); 
		minHeap.insert(3); 
		minHeap.insert(17); 
		minHeap.insert(10); 
		minHeap.insert(84); 
		minHeap.insert(19); 
		minHeap.insert(6); 
		minHeap.insert(22); 
		minHeap.insert(9); 
		minHeap.minHeap(); 

		minHeap.print(); 
		System.out.println("The Min val is " + minHeap.remove()); 
	} 
} 