package DataStructures.Trie;

public class TrieMain {
	public static void main(String[] args) {
		TrieDS t  =new TrieDS();

		//CASE#1
//		t.insert("bcde");
//		t.insert("bckg");
//		t.delete("bcde");
//		System.out.println(t.search("bcde"));	//False
//		System.out.println(t.search("bckg"));	//True


		//CASE#2
		t.insert("bcde");
		t.insert("bcdefg");
		t.delete("bcde");
		System.out.println(t.search("bcde"));		//False
		System.out.println(t.search("bcdefg"));	//True


		//CASE#3
//		t.insert("bcde");
//		t.insert("bc");
//		t.delete("bcde");
//		System.out.println(t.search("bcde"));	//False
//		System.out.println(t.search("bc"));		//True
//		System.out.println(t.search("b"));			//False


		//CASE#4
		t.insert("bcde");
		t.delete("bc");
		t.delete("bcde");
		System.out.println(t.search("bcde"));	//False
		System.out.println(t.search("bc"));	//False


		// construct a new Trie node
//		Trie head = new Trie();
//
//		head.insert("techie");
//		head.insert("techi");
//		head.insert("tech");
//
//		System.out.println(head.search("tech"));            // true
//		System.out.println(head.search("techi"));           // true
//		System.out.println(head.search("techie"));          // true
//		System.out.println(head.search("techiedelight"));   // false
//
//		head.insert("techiedelight");
//
//		System.out.println(head.search("tech"));            // true
//		System.out.println(head.search("techi"));           // true
//		System.out.println(head.search("techie"));          // true
//		System.out.println(head.search("techiedelight"));   // true
	}
}
