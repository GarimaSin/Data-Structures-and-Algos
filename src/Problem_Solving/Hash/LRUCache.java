package Problem_Solving.Hash;

/**
 * Here, head.next = 1st node
 * And   tail.prev = last node
 */

//Check this code-------

import java.util.HashMap;

public class LRUCache {

	HashMap<Integer, Node> map;
	int capicity, count;
	Node head, tail;

	public LRUCache(int capacity) {
		this.capicity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capicity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		int res = 0;
		lRUCache.set(1, 1); // cache is {1=1}
		lRUCache.set(2, 2); // cache is {1=1, 2=2}
		Node temp = lRUCache.head.next;
		while(temp.next != null) {
			System.out.println(temp.key + " +  " + temp.value);
			temp = temp.next;
		}

		res = lRUCache.get(1);    // return 1
		System.out.println(res);

		lRUCache.set(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		temp = lRUCache.head.next;
		while(temp.next != null) {
			System.out.println(temp.key + " +  " + temp.value);
			temp = temp.next;
		}

		res = lRUCache.get(2);    // returns -1 (not found)
		System.out.println(res);

		lRUCache.set(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		temp = lRUCache.head.next;
		while(temp.next != null) {
			System.out.println(temp.key + " +  " + temp.value);
			temp = temp.next;
		}

		res = lRUCache.get(1);    // return -1 (not found)
		System.out.println(res);

		res = lRUCache.get(3);    // return 3
		System.out.println(res);

		res = lRUCache.get(4);	// return 4
		System.out.println(res);
	}
}


class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}